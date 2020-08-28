package com.ktnet.gethub.oss.core.domain.repository.oss;

import com.ktnet.gethub.oss.core.domain.dao.Member;
import com.ktnet.gethub.oss.core.domain.dao.oss.Cust;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustRepository {

    private final EntityManager em;

    // 사용자 저장
    public void save(Cust cust) {
        em.persist(cust);
    }

    // 사용자 단 건 조회
    public Cust findOne(String custId) {
        return em.find(Cust.class, custId);
    }

    public List<Cust> findAll() {
        return em.createQuery("select c from Cust c", Cust.class)
                .getResultList();
    }

    public List<Cust> findByName(String custName) {
        return em.createQuery("select c from Cust c where c.custName = :custName", Cust.class)
                .setParameter("custName", custName)
                .getResultList();
    }

}
