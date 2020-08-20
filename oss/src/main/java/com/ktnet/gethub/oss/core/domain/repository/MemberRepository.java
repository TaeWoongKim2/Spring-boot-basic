package com.ktnet.gethub.oss.core.domain.repository;

import com.ktnet.gethub.oss.core.domain.dao.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository // @Repository가 존재하는 클래스는 Spring Bean 객체로 등록을 해준다!
@RequiredArgsConstructor
public class MemberRepository {

//    @PersistenceContext           // @PersistenceContext Spring이 EntityManage를 만들어서 자동으로 주입해준다!
//    private EntityManager em;

    private final EntityManager em; // But, 생성자를 통해 Injection할 수 있음! Only Spring Boot + JPA 만 가능하다!

    // 사용자 저장
    public void save(Member member) {
        em.persist(member);
    }

    // 사용자 단 건 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
        /*
            JPQL은 기존 SQL 쿼리와 다르다.
            기존 SQL쿼리는 Table 기준이지만, JPQL은 객체지향 쿼리로써 Entity객체를 기준으로 쿼리를 날린다.
        */
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
