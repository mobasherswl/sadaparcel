package com.sadapay.sadaparcel.offers;

import com.sadapay.sadaparcel.api.model.offers.Offer;
import com.sadapay.sadaparcel.items.ItemEntity;
import com.sadapay.sadaparcel.items.ItemsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OffersServiceTest {
    @Autowired
    OffersRepository offersRepository;
    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    OffersService offersService;

    @Test
    public void getAll() {
        ItemEntity item = new ItemEntity().setName("name").setDescription("desc").setPrice(BigDecimal.TEN).setQuantity(2);

        item = itemsRepository.save(item);

        OfferEntity offer = new OfferEntity().setName("offer 1").setDescription("desc")
                .setPriceReduction(BigDecimal.ONE).setItem(item).setQuantityThreshold(2).setItem(item);

        offer = offersRepository.save(offer);
        item = itemsRepository.save(item.setOffers(Set.of(offer)));
        item = itemsRepository.findById(item.getId()).get();

        List<Offer> offers = offersService.getAll();

        Assertions.assertTrue(!offers.isEmpty());
        Assertions.assertEquals(item.getId().toString(), offers.get(0).getItemId().toString());
        Assertions.assertEquals(offer.getId().toString(), item.getOffers().iterator().next().getId().toString());
    }
}