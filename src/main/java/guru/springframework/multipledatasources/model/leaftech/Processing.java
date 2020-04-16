package guru.springframework.multipledatasources.model.leaftech;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "processing")
public class Processing {

    @Id
    private String productid;
    private String productdescription;
    private int productquantity;
    private float productprice;
}
