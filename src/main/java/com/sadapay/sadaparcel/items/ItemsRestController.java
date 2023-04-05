package com.sadapay.sadaparcel.items;

import com.sadapay.sadaparcel.api.definition.items.ItemsApi;
import com.sadapay.sadaparcel.api.model.items.GetInventory200Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemsRestController implements ItemsApi {

    final ItemsService itemsService;

    @Override
    public ResponseEntity<GetInventory200Response> getInventory() {
        return ResponseEntity.ok(new GetInventory200Response(itemsService.getAll()));
    }
}