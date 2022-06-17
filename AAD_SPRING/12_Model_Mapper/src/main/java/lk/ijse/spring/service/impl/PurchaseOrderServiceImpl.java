package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrderDetailsDTO;
import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.*;
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
import java.util.Optional;

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
        if (!ordersRepo.existsById(dto.getOid())) {
           ordersRepo.save(new Orders(dto.getOid(),dto.getDate(),mapper.map(dto.getCustomer(), Customer.class)));
            for (OrderDetailsDTO od : dto.getOrderDetails()) {
                if (!orderDetailsRepo.existsById(new OrderItem_PK(od.getOid(),od.getItemCode()))) {
                    orderDetailsRepo.save(new OrderDetails(od.getOid(), od.getItemCode(), od.getQty(), od.getUnitPrice()));

                    Optional<Item> item = itemRepo.findById(od.getItemCode());
                    if (item.isPresent()) {
                        Item itm = item.get();
                        itm.setQtyOnHand(itm.getQtyOnHand()-od.getQty());
                        itemRepo.save(itm);
                    }else{
                        throw new RuntimeException("Transaction Rolled Back due to the Stock Update issue.!");
                    }

                }else{
                    throw new RuntimeException("Transaction Rolled Back due to the "+od.getItemCode()+" issue.!");
                }
            }
        }else{
            throw new RuntimeException("Purchase Order Failed..!, Order ID "+dto.getOid()+" Already Exist.!");
        }
    }

    @Override
    public void deleteOrder(String oid) {
    ordersRepo.deleteById(oid);
    }

    @Override
    public void updateOrder(OrdersDTO dto) {
        if (ordersRepo.existsById(dto.getOid())) {
            ordersRepo.save( mapper.map(dto,Orders.class));

        }else{
            throw new RuntimeException("Update Order Failed..!, Order ID "+dto.getOid()+" Not Exist.!");
        }
    }

    @Override
    public OrdersDTO searchOrder(String oid) {
       return mapper.map(ordersRepo.findById(oid),OrdersDTO.class);
    }

    @Override
    public List<OrdersDTO> getAllOrders() {
        return mapper.map(ordersRepo.findAll(),new TypeToken<List<OrdersDTO>>(){}.getType());
    }
}
