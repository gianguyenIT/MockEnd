package fa.training.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "currencies")
public class Currencies implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currencies_id")
    private Long currenciesId;
    @Column(name = "name", length = 64)
    private String name;
    @Column(name = "symbol", length = 3)
    private String symbol;
    @Column(name = "code", length = 4)
    private String code;
}
