package com.sadapay.sadaparcel.offers;

import com.sadapay.sadaparcel.api.model.offers.Offer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class OffersServiceTest {

    @Autowired
    OffersService offersService;

    @Test
    public void getAll() {
        List<Offer> offers = offersService.getAll();

        Assertions.assertTrue(!offers.isEmpty());
    }
}