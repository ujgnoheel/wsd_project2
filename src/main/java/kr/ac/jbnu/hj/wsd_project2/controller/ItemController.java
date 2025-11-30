package kr.ac.jbnu.hj.wsd_project2.controller;

import jakarta.validation.Valid;
import kr.ac.jbnu.hj.wsd_project2.dto.ItemRequest;
import kr.ac.jbnu.hj.wsd_project2.dto.ItemResponse;
import kr.ac.jbnu.hj.wsd_project2.entity.Item;
import kr.ac.jbnu.hj.wsd_project2.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // 1) 상품 생성
    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@Valid @RequestBody ItemRequest request) {
        Item item = new Item();
        item.setName(request.getName());
        item.setPrice(request.getPrice());

        Item savedItem = itemService.createItem(item);

        return ResponseEntity
                .status(HttpStatus.CREATED)   // 201
                .body(ItemResponse.from(savedItem));
    }

    // 3) 전체 상품 조회
    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        List<ItemResponse> response = itemService.getAllItems()
                .stream()
                .map(ItemResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    // 5) 상품 수정
    @PutMapping("/{id}")
    public ResponseEntity<ItemResponse> updateItem(
            @PathVariable Long id,
            @Valid @RequestBody ItemRequest request
    ) {
        Item updated = itemService.updateItem(id, request.getName(), request.getPrice());
        return ResponseEntity.ok(ItemResponse.from(updated));
    }

    // 7) 상품 삭제 (성공: 204, 실패: 404)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);   // 없으면 404 던지도록 구현
        return ResponseEntity.noContent().build();  // 204
    }
}