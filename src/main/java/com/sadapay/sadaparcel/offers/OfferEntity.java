package com.sadapay.sadaparcel.offers;

import com.sadapay.sadaparcel.items.ItemEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "offer")
public class OfferEntity implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String name;
    @Column
    private String description;
    @ManyToOne
    private ItemEntity item;
    @Column
    private BigDecimal priceReduction;
    @Column
    private Integer quantityThreshold;
}
