package com.sadapay.sadaparcel.items;

import com.sadapay.sadaparcel.api.model.items.Item;
import com.sadapay.sadaparcel.api.model.items.Line;
import com.sadapay.sadaparcel.items.ItemsService;
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
@WebMvcTest
public class ItemsRestControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    ItemsService itemsService;

    @Test
    void getAllItems() throws Exception {
        List<Line> lines = List.of(
                new Line(new Item().id("1").name("item 1").price(BigDecimal.TEN).description("desc 1"), 2),
                new Line(new Item().id("2").name("item 2").price(BigDecimal.ONE).description("desc 2"), 5));

        when(itemsService.getAll()).thenReturn(lines);
        mockMvc.perform(
                MockMvcRequestBuilders.get("/items").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
    }
}
