package id.co.davidfirdaus.travel.catalogservice.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private String code;
    private String description;
}
