package gr.kantasni.raceconditiondemo.api;

import lombok.Data;

/**
 * @author Nikos Kantas (n.kantas)
 */
@Data
public class ErrorResult implements IMockResult {
    private String error = "Error";
}
