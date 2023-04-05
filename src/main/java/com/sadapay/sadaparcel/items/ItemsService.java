package com.sadapay.sadaparcel.items;

import com.sadapay.sadaparcel.api.model.items.Item;
import com.sadapay.sadaparcel.api.model.items.Line;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemsService {
    final private ItemsRepository itemsRepository;

    public List<Line> getAll() {
        final List<ItemEntity> list = itemsRepository.findAll();

        return list.stream()
                .map(entity ->
                        new Line(new Item(entity.getId().toString(), entity.getName(), entity.getDescription(),
                                entity.getPrice()), entity.getQuantity()))
                .collect(Collectors.toList());
    }
}
