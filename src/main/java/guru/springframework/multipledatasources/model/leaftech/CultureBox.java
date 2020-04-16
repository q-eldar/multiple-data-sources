package guru.springframework.multipledatasources.model.leaftech;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cultureboxes")
public class CultureBox {

    @Id
    private String productid;
    private String productdescription;
    private int productquantity;
    private float productprice;
}
