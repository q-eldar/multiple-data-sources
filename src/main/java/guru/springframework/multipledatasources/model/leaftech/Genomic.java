package guru.springframework.multipledatasources.model.leaftech;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "genomics")
public class Genomic {

    @Id
    private String productid;
    private String productdescription;
    private int productquantity;
    private float productprice;
}
