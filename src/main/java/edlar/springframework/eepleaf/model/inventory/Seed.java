package edlar.springframework.eepleaf.model.inventory;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
//@Table(name = "seeds")
public class Seed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String memberId;
}

