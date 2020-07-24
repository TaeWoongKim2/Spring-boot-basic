package com.ktnet.gethub.oss.core.domain.repository;

import com.ktnet.gethub.oss.core.domain.dao.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // 해당 어노테이션이 TEST Class에 있으면, 롤백을 해버림!
//@Rollback(false)    // 이 어노테이션을 통해 롤백을 막을 수 있음!
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember() throws Exception {

        // given
        Member member = new Member();
        member.setName("EHOTO");

        // when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        // then
        // Assert J 라는 라이브러리를 가지고 있기 때문에 쉽게 결과를 체크할 수 잇음.
        assertEquals(findMember.getId(), member.getId());
        assertEquals(findMember.getName(), member.getName());
        assertEquals(member, findMember);
    }

}