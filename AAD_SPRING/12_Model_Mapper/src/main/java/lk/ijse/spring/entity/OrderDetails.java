package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class OrderDetails {
    @EmbeddedId
    private OrderItem_PK orderItem_pk;
    private int qty;
    private double unitPrice;

    //Out-Verse
    @ManyToOne
    @JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false)
    private Orders orders;

    //Out-verse
    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "code",insertable = false,updatable = false)
    private Item item;

    public OrderDetails(String oid,String itemCode, int qty, double unitPrice) {
        this.orderItem_pk = new OrderItem_PK(oid,itemCode);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
}
