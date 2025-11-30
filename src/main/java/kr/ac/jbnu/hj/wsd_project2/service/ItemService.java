package kr.ac.jbnu.hj.wsd_project2.service;

import kr.ac.jbnu.hj.wsd_project2.entity.Item;
import kr.ac.jbnu.hj.wsd_project2.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    // 1) 상품 생성
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // 3) 전체 상품 조회
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // 5) 상품 수정
    public Item updateItem(Long id, String name, Integer price) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));

        if (name != null) item.setName(name);
        if (price != null) item.setPrice(price);

        return itemRepository.save(item);
    }

    // 7) 상품 삭제 (물리 삭제)
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
        itemRepository.delete(item);
    }
}
