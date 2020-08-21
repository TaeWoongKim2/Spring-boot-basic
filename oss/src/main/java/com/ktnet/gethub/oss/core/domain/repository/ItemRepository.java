package com.ktnet.gethub.oss.core.domain.repository;

import com.ktnet.gethub.oss.core.domain.dao.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository // @Repository가 존재하는 클래스는 Spring Bean 객체로 등록을 해준다!
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        /**
         * 완전 신규 생성 시, ID 값이 NULL 이다.
         * 이 경우, em.persist를 통해서 새로 생성하는 것이고
         * 아닐 경우, em.merge를 통해서...
         */
        if(item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }


}
