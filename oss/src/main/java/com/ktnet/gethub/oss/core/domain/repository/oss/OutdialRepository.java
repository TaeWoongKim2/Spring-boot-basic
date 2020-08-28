package com.ktnet.gethub.oss.core.domain.repository.oss;

import com.ktnet.gethub.oss.core.domain.dao.oss.Indial;
import com.ktnet.gethub.oss.core.domain.dao.oss.Outdial;
import com.ktnet.gethub.oss.core.domain.dao.oss.OutdialKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class OutdialRepository {

    private final EntityManager em;

    // Indial 저장
    public void save(Outdial outdial) {
        em.persist(outdial);
    }

    // Indial 조회
    public Outdial findByCustId(OutdialKey outdialKey) {
        return em.find(Outdial.class, outdialKey);
    }

}
