package com.ktnet.gethub.oss.core.domain.repository.oss;

import com.ktnet.gethub.oss.core.domain.dao.oss.Cust;
import com.ktnet.gethub.oss.core.domain.dao.oss.Tp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TpRepository {

    private final EntityManager em;

    // 사용자 저장
    public void save(Tp tp) {
        em.persist(tp);
    }

    // 사용자 단 건 조회
    public Tp findOne(String tpId) {
        return em.find(Tp.class, tpId);
    }

    public List<Tp> findAll() {
        return em.createQuery("select t from Tp t", Tp.class)
                .getResultList();
    }

    public List<Tp> findByTpName(String tpName) {
        return em.createQuery("select t from Tp t where t.tpName = :tpName", Tp.class)
                .setParameter("tpName", tpName)
                .getResultList();
    }

    public List<Tp> findByCustId(String custId) {
        return em.createQuery("select t from Tp t where t.custId = :custId", Tp.class)
                .setParameter("custId", custId)
                .getResultList();
    }

}
