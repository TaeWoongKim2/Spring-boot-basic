package com.ktnet.gethub.oss.core.domain.repository.oss;

import com.ktnet.gethub.oss.core.domain.dao.oss.Cust;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CustRepositoryTest {

    @Autowired EntityManager em;
    @Autowired CustRepository custRepository;

    @Test
    public void testCust() throws Exception {
        // given
        Cust cust = Cust.builder()
                .custId("EDITEST01")
                .custName("EDI TEST")
                .registUserId("woong46")
                .build();

        // when
        custRepository.save(cust);
        Cust findCust = custRepository.findOne(cust.getCustId());

        // then
        // Assert J 라는 라이브러리를 가지고 있기 때문에 쉽게 결과를 체크할 수 잇음.
        assertEquals(findCust.getCustId(), cust.getCustId());
        assertEquals(findCust.getCustName(), cust.getCustName());
        assertEquals(cust, findCust);

    }
}