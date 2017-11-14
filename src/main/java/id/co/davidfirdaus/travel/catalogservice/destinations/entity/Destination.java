package id.co.davidfirdaus.travel.catalogservice.destinations.entity;

import id.co.davidfirdaus.travel.catalogservice.commons.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Destination extends BaseEntity {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private String city;

    @NotNull
    private String country;

    private String note;

    @Id
    @NotNull @GenericGenerator(name = "destinationIdGenerator", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "segment_value", value = "destinationId"),
            @org.hibernate.annotations.Parameter(name = "initialValue", value = "1"),
            @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled")
    })
    @GeneratedValue(generator = "destinationIdGenerator")
    private Long id;
}
