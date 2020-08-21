package com.ktnet.gethub.oss.core.domain.repository;

import com.ktnet.gethub.oss.core.domain.dao.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository // @Repository가 존재하는 클래스는 Spring Bean 객체로 등록을 해준다!
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        /**
         * 파라미터 들어온 상품의 ID 값에 따라 다른 프로세를 돈다 !!!
         * NULL인 경우, em.persist를 통해서 상품을 새로 생성하는 것이고,
         * NOT NULL인 경우, em.merge를 통해서 강제로 업데이트(?)하는 것이다 !!!
         */
        if(item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

}
