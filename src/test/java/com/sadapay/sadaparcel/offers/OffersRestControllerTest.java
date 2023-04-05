package com.sadapay.sadaparcel.offers;

import com.sadapay.sadaparcel.api.model.offers.Offer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {OffersRestController.class})
public class OffersRestControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    OffersService offersService;

    @Test
    void getAllOffers() throws Exception {
        List<Offer> lines = List.of(
                new Offer("id 1", "offer 1", "desc 1", "itemId 1", BigDecimal.ONE, 2),
                new Offer("id 1", "offer 1", "desc 1", "itemId 1", BigDecimal.ONE, 2));

        when(offersService.getAll()).thenReturn(lines);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/offers").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$.offers", hasSize(2))).andDo(print());
    }
}
