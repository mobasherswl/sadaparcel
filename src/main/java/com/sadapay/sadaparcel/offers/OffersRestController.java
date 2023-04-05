package com.sadapay.sadaparcel.offers;


import com.sadapay.sadaparcel.api.definition.offers.OffersApi;
import com.sadapay.sadaparcel.api.model.offers.GetOffers200Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OffersRestController implements OffersApi {

    private final OffersService offersService;

    @Override
    public ResponseEntity<GetOffers200Response> getOffers() {
        return ResponseEntity.ok(new GetOffers200Response(offersService.getAll()));
    }
}
