package id.co.davidfirdaus.travel.catalogservice.commons.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    @Version
    @JsonIgnore
    private Long version;

    @JsonIgnore
    private String entityKey =  UUID.randomUUID().toString();
}
