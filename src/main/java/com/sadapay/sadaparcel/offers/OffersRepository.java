package com.sadapay.sadaparcel.offers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OffersRepository extends JpaRepository<OfferEntity, UUID> {
}
