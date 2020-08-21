package com.ktnet.gethub.oss.core.service;

import com.ktnet.gethub.oss.core.domain.dao.Member;
import com.ktnet.gethub.oss.core.domain.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class): jUnit5 에서 빠짐!
@SpringBootTest
@Transactional // 테스트 케이스(클래스)에 있으면, 기본적으로 Rollback!
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    // @Rollback(false) insert Query를 보이게 할 수 있지만, DB에 데이터가 남음!
    public void 회원가입() throws Exception {
        // given
        Member member = Member.builder()
                .name("kim")
                .build();
        // when
        Long saveId = memberService.join(member);
        /**
         * 테스트 코드 시, insert 문이 없다.
         * @Transactional 이 Rollback을 해버리기 때문
         */
        
        // then
        em.flush(); // insert Query를 보이게 할 수 있음. DB에 데이터가 남지 않음!
        assertEquals(member, memberRepository.findOne(saveId));
    }
    
    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = Member.builder()
                .name("kim")
                .build();

        Member member2 = Member.builder()
                .name("kim")
                .build();
        // when
        memberService.join(member1);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });
//        try {
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            return;
//        }
//        // then
//        fail("예외가 발생해야 합니다.");
        /**
         * Assert에 기본적으로 fail이라는 것을 가지고 있다.
         * fail을 타면 안되는 테스트이다.
         * @Test(expected = IllegalStateException.class) 속성 값을 통해 출력되는 Exception을 잡아낼 수 있다!
         * @junit5 부터는 @Test(expected = Exception.class) 이 없어지고 위와 같은 Assertions.assertThrows를 통해 테스트할 수 있다!
         */

    }

}