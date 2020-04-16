package guru.springframework.multipledatasources.model.inventory;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "seeds")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Seed {

    @Id
    private String product_code;
    private String description;
    private Integer quantity;
    private Float price;
}

