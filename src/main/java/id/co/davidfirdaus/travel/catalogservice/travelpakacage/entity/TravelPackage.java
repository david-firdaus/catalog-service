package id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.co.davidfirdaus.travel.catalogservice.commons.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class TravelPackage extends BaseEntity {
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PackageStatus status = PackageStatus.OPEN;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PackageType type = PackageType.TRAVEL;

    @NotNull @NotEmpty
    private String name;

    private BigDecimal estimatePrice;

    private String termAndCondition;

    @JsonIgnore
    @Valid
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = PriceDetail.class, cascade = CascadeType.REMOVE, mappedBy = "travelPackage")
    private List<PriceDetail> priceDetails = new ArrayList<>();

    @JsonIgnore
    @Valid
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = ItineraryDetail.class, cascade = CascadeType.REMOVE, mappedBy = "travelPackage")
    private List<ItineraryDetail> itineraryDetails = new ArrayList<>();

    @Id
    @NotNull
    @GenericGenerator(name = "travelPackageIdGenerator", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "segment_value", value = "travelPackageId"),
            @org.hibernate.annotations.Parameter(name = "initialValue", value = "1"),
            @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled")
    })
    @GeneratedValue(generator = "travelPackageIdGenerator")
    private Long id;
}
