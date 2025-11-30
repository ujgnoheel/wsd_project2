package kr.ac.jbnu.hj.wsd_project2.dto;

import kr.ac.jbnu.hj.wsd_project2.entity.Item;
import lombok.Getter;

@Getter
public class ItemResponse {

    private Long id;
    private String name;
    private Integer price;

    public static ItemResponse from(Item item) {
        ItemResponse res = new ItemResponse();
        res.id = item.getId();
        res.name = item.getName();
        res.price = item.getPrice();
        return res;
    }
}
