package gr.kantasni.raceconditiondemo.api;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Nikos Kantas (n.kantas)
 */
@Data
@AllArgsConstructor
public class SuccessResult implements IMockResult {
    private String name;
    private Integer number;
    private boolean swap;
}
