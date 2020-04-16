package guru.springframework.multipledatasources.model.orderinfo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;
    private String order_date;
    private String first_name;
    private String last_name;
    private String address;
    private String phone;
    private Float total_cost;
    private Boolean shipped;
    private String ordertable;
}
