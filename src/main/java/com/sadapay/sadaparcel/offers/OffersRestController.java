package com.sadapay.sadaparcel.offers;


import com.sadapay.sadaparcel.api.definition.offers.OffersApi;
import com.sadapay.sadaparcel.api.model.offers.GetOffers200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OffersRestController implements OffersApi {

    @Override
    public ResponseEntity<GetOffers200Response> getOffers() {
        return ResponseEntity.ok(new GetOffers200Response());
    }
}
