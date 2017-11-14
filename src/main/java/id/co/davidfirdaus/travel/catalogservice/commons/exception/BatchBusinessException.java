package id.co.davidfirdaus.travel.catalogservice.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchBusinessException extends RuntimeException {
    private List<BusinessException> exceptions;

}
