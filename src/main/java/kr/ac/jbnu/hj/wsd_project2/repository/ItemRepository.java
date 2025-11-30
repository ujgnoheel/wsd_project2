package kr.ac.jbnu.hj.wsd_project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.ac.jbnu.hj.wsd_project2.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
