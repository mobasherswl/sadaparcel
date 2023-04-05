package com.sadapay.sadaparcel.items;

import com.sadapay.sadaparcel.api.model.items.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ItemsServiceTest {
    @MockBean
    ItemsRepository itemsRepository;
    @Autowired
    ItemsService itemsService;

    @Test
    void getAll() {
        ItemEntity item = new ItemEntity().setName("name").setDescription("desc").setPrice(BigDecimal.TEN).setQuantity(2);

        itemsRepository.save(item);

        List<Line> itemEntityList = itemsService.getAll();

        Assertions.assertTrue(!itemEntityList.isEmpty());
    }
}