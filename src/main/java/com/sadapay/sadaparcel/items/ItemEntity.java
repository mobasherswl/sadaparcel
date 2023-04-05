package com.sadapay.sadaparcel.items;

import com.sadapay.sadaparcel.offers.OfferEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "item")
public class ItemEntity implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal price;
    @Column
    private Integer quantity;
    @OneToMany(mappedBy="item", fetch = FetchType.EAGER)
    private Set<OfferEntity> offers;
}
