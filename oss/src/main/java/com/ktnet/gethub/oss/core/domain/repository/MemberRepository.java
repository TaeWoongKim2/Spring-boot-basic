package com.ktnet.gethub.oss.core.domain.repository;

import com.ktnet.gethub.oss.core.domain.dao.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;  // entity manager가 자동으로 생성해줌.

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
