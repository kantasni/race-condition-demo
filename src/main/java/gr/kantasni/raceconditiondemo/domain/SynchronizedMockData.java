package gr.kantasni.raceconditiondemo.domain;

import gr.kantasni.raceconditiondemo.api.MockData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Nikos Kantas (n.kantas)
 */
@Entity
@Data
@Table(name = "synchronized_mock_data")

public class SynchronizedMockData implements MockData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer number;

    @Column
    private boolean swapBoolean;
}
