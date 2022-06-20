package lk.ijse.spring.repo;

import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.OrderItem_PK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, OrderItem_PK> {
}
