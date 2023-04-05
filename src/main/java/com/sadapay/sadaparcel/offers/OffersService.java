package com.sadapay.sadaparcel.offers;

import com.sadapay.sadaparcel.api.model.offers.Offer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OffersService {
    private final OffersRepository offersRepository;

    public List<Offer> getAll() {
        return offersRepository.findAll()
                .stream()
                .map(entity -> new Offer(entity.getId().toString(), entity.getName(), entity.getDescription(),
                        entity.getItem().getId().toString(), entity.getPriceReduction(), entity.getQuantityThreshold()))
                .collect(Collectors.toList());
    }
}
