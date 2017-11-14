package id.co.davidfirdaus.travel.catalogservice.travelpakacage.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import id.co.davidfirdaus.travel.catalogservice.commons.entity.BaseEntity;
import id.co.davidfirdaus.travel.catalogservice.destinations.entity.Destination;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class ItineraryDetail extends BaseEntity {

    @JsonBackReference
    @NotNull
    @ManyToOne(targetEntity = TravelPackage.class)
    private TravelPackage travelPackage;

    @NotNull @OneToOne(targetEntity = Destination.class)
    private Destination destination;

    @Id
    @NotNull
    @GenericGenerator(name = "itineraryDetailIdGenerator", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "segment_value", value = "itineraryDetailId"),
            @org.hibernate.annotations.Parameter(name = "initialValue", value = "1"),
            @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled")
    })
    @GeneratedValue(generator = "itineraryDetailIdGenerator")
    private Long id;
}
