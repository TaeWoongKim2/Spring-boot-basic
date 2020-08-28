package com.ktnet.gethub.oss.core.domain.repository.oss;

import com.ktnet.gethub.oss.core.domain.dao.oss.Cust;
import com.ktnet.gethub.oss.core.domain.dao.oss.Tp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TpRepositoryTest {

    @Autowired EntityManager em;
    @Autowired TpRepository tpRepository;
    
    @Test
    public void 식별자테스트() throws Exception {
        // given
        Cust cust = Cust.builder()
                .custId("EDITEST01")
                .custName("EDI TEST")
                .registUserId("woong46")
                .build();
        em.persist(cust);

        Tp tp = Tp.builder()
                .cust(cust)
                .tpId("57EDITEST01")
                .identifier("EDITEST01")
                .registUserId("woong46")
                .build();

        // when
        tpRepository.save(tp);
        Tp findTp = tpRepository.findOne(tp.getTpId());

        // then
        // Assert J 라는 라이브러리를 가지고 있기 때문에 쉽게 결과를 체크할 수 잇음.
        assertEquals(findTp.getTpId(), tp.getTpId());
        assertEquals(findTp.getCust().getCustId(), tp.getCust().getCustId());
        assertEquals(tp, findTp);
    }
    
}