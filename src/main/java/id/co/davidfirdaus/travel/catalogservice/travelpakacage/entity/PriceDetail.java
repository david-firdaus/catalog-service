package id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import id.co.davidfirdaus.travel.catalogservice.commons.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class PriceDetail extends BaseEntity {

    @JsonBackReference
    @NotNull
    @ManyToOne(targetEntity = TravelPackage.class)
    private TravelPackage travelPackage;

    @NotNull
    @Min(value = 100)
    private BigDecimal price;

    @NotNull
    private Date departureDate;

    @NotNull @Min(value = 1)
    private Integer days;

    @NotNull @Min(value = 1)
    private Integer nights;

    private String note;

    @Id
    @NotNull
    @GenericGenerator(name = "priceDetailIdGenerator", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "segment_value", value = "priceDetailPackageId"),
            @org.hibernate.annotations.Parameter(name = "initialValue", value = "1"),
            @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled")
    })
    @GeneratedValue(generator = "priceDetailIdGenerator")
    private Long id;
}
