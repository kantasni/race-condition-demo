package gr.kantasni.raceconditiondemo.api;

import gr.kantasni.raceconditiondemo.domain.RaceConditionResolveMethod;
import lombok.Data;

/**
 * @author Nikos Kantas (n.kantas)
 */
@Data
public class GetMockDataRequest {
    private Integer number;
    private RaceConditionResolveMethod resolveMethod;
}
