package edlar.springframework.eepleaf.model.inventory;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shrubs")
public class Shrub {

    @Id
    private String product_code;
    private String description;
    private Integer quality;
    private Float price;
}

