package com.ktnet.gethub.oss.core.service;

import com.ktnet.gethub.oss.core.domain.dao.Member;
import com.ktnet.gethub.oss.core.domain.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;

@Service
@Transactional(readOnly = true) // (읽기전용 취급) readOnly = true 는 읽기 전용 JPA 데이터 조회 쿼리를 최적화 한다! (이유 찾아보기)
// @Transactional   // JPA의 모든 데이터 변경이나 로직들은 가급적이면, 트랜잭션 안에서 실행돼야 한다!
                    // public methods는 전부 트랜잭션 된다.
//@AllArgsConstructor       // 모든 변수에 대한 생성자 생성
@RequiredArgsConstructor    // final이 있는 변수에 대해서만 생성자 생성.
public class MemberService {

//    Spring @Autowired injection
//    장점 : 사용하기 편함.
//    단점 : 테스트시 변경이 어려움.
//    @Autowired
//    private final MemberRepository memberRepository;

//    javax.swing.Spring setter injection - 바로 주입하는 것이 아니라 Service에 들어와서 주입, 테스트 시 변경에 용이.
//    장점 : 변경하고 싶은 Repository로 변경이 쉬움.
//    단점 :
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    Spring 생성자 injection
//    장점 : 최신 트랜드. 중간에 변경될 일이 없음. 테스트 케이스 구현 시 놓치기 쉬운 것들을 잡을 수 있음.
//          최신 Spring 버전의 경우, @Component 생성자에 @Autowired 가 없다면 자동으로 injection을 해준다!
//    @Autowired
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional(readOnly = false) // Default, (readOnly = false)
    public Long join(Member member) {
        validateDuplicateMember(member);    // 중복 회원 로직
        memberRepository.save(member);
        return member.getId();              // 아직 DB에 저장 전 이라도, 영속성 Persistence에 의해 값이 ID가 자동으로 채워진다!
    }

    private void validateDuplicateMember(Member member) {
        // EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName());   // WAS를 통해 동시에 회원가입이 될 경우도 있다.
                                                                                    // 실무에서는 name을 unique 제약조건을 통해 multi-thread 환경 고려 권장!
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     */

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 하나 검색
     */
    public Member findMember(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
