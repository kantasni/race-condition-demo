package gr.kantasni.raceconditiondemo.domain;

import gr.kantasni.raceconditiondemo.api.MockData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

/**
 * @author Nikos Kantas (n.kantas)
 */
@Entity
@Data
public class OptimisticMockData implements MockData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer number;

    @Column
    private boolean swapBoolean;

    @Version
    private Integer version;
}
