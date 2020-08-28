package com.ktnet.gethub.oss.core.domain.repository.oss;

import com.ktnet.gethub.oss.core.domain.dao.oss.Indial;
import com.ktnet.gethub.oss.core.domain.dao.oss.Tp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class IndialRepository {

    private final EntityManager em;

    // Indial 저장
    public void save(Indial indial) {
        em.persist(indial);
    }

    // Indial 조회
    public Indial findByCustId(String custId) {
        return em.find(Indial.class, custId);
    }

}
