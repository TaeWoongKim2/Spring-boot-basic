package com.ktnet.gethub.oss.core.domain.repository.oss;

import com.ktnet.gethub.oss.core.domain.dao.oss.Cust;
import com.ktnet.gethub.oss.core.domain.dao.oss.Indial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class IndialRepositoryTest {

    @Autowired EntityManager em;
    @Autowired IndialRepository indialRepository;

    @Test
    @Rollback(false)
    public void 내부접속테스트() throws Exception {
        // given
        Cust cust = Cust.builder()
                .custId("EDITEST01")
                .custName("EDI TEST")
                .registUserId("woong46")
                .build();
        em.persist(cust);

        Indial indial = Indial.builder()
                .cust(cust)
                .registUserId("woong46")
                .build();

        // when
        indialRepository.save(indial);
        Indial findIndial = indialRepository.findByCustId(cust.getCustId());

        // then
        assertEquals(findIndial.getCust().getCustId(), cust.getCustId());
        assertEquals(findIndial.getCust(), cust);
        assertEquals(findIndial, indial);
    }

}