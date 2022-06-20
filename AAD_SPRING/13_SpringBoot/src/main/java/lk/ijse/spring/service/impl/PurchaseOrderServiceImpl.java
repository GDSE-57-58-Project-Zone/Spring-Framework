package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.OrderItem_PK;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderDetailsRepo;
import lk.ijse.spring.repo.OrdersRepo;
import lk.ijse.spring.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void purchaseOrder(OrdersDTO dto) {
        Orders order = mapper.map(dto, Orders.class);
        if (!ordersRepo.existsById(dto.getOid())) {
            ordersRepo.save(order);

            if (dto.getOrderDetails().size() < 1) throw new RuntimeException("No items added for the order..!");

            //update the item
            for (OrderDetails orderDetail : order.getOrderDetails()) {
                Item item = itemRepo.findById(orderDetail.getItemCode()).get();
                item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
                itemRepo.save(item);
            }

        } else {
            throw new RuntimeException("Purchase Order Failed..!, Order ID " + dto.getOid() + " Already Exist.!");
        }
    }

    @Override
    public void deleteOrder(String oid) {
        if (ordersRepo.existsById(oid)) {
            ordersRepo.deleteById(oid);
        } else {
            throw new RuntimeException("Delete Order Failed..!, Order ID " + oid + " Not Exist..!");
        }

    }

    @Override
    public void updateOrder(OrdersDTO dto) {
        if (ordersRepo.existsById(dto.getOid())) {

            Orders order = mapper.map(dto, Orders.class);
            if (dto.getOrderDetails().size() < 1) throw new RuntimeException("No items added for the order..!");

            for (OrderDetails od : order.getOrderDetails()) {
                Item item = itemRepo.findById(od.getItemCode()).get();
                OrderDetails previous = orderDetailsRepo.findById(new OrderItem_PK(od.getOid(), od.getItemCode())).get();

                //Update the Item Qty
                int newQty = od.getQty();
                int prevQty = previous.getQty();
                if (newQty > prevQty) {
                    int dif = newQty - prevQty;
                    item.setQtyOnHand(item.getQtyOnHand() - dif);
                } else if (newQty < prevQty) {
                    int dif = prevQty - newQty;
                    item.setQtyOnHand(item.getQtyOnHand() + dif);
                }
                itemRepo.save(item);
            }
            //then delete the old order
            ordersRepo.deleteById(dto.getOid());
            //finally update the new order
            ordersRepo.save(order);
        } else {
            throw new RuntimeException("Update Order Failed..!, Order ID " + dto.getOid() + " Not Exist.!");
        }
    }

    @Override
    public OrdersDTO searchOrder(String oid) {
        if (ordersRepo.existsById(oid)) {
            return mapper.map(ordersRepo.findById(oid), OrdersDTO.class);
        } else {
            throw new RuntimeException("Search Order Failed..!, Order ID " + oid + " Not Exist.!");
        }

    }

    @Override
    public List<OrdersDTO> getAllOrders() {
        return mapper.map(ordersRepo.findAll(), new TypeToken<List<OrdersDTO>>() {
        }.getType());
    }
}
