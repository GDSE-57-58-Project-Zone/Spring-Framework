package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Orders {
    @Id
    private String oid;
    private LocalDate date;

    //Out=verse
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerID",referencedColumnName = "id",nullable = false)
    private Customer customer;

    //Inverse
    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

    public Orders(String oid, LocalDate date, Customer customer) {
        this.oid = oid;
        this.date = date;
        this.customer = customer;
    }
}
