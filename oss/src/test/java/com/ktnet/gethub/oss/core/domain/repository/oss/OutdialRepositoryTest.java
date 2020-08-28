package com.ktnet.gethub.oss.core.domain.repository.oss;

import com.ktnet.gethub.oss.core.domain.dao.oss.Cust;
import com.ktnet.gethub.oss.core.domain.dao.oss.Outdial;
import com.ktnet.gethub.oss.core.domain.dao.oss.OutdialKey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OutdialRepositoryTest {

    @Autowired EntityManager em;
    @Autowired OutdialRepository outdialRepository;

    private static final String ADMIN_ID = "woong46";
    private static final String CUST_ID = "EDITEST01";
    private static final String CUST_NAME = "EDI TEST";
    private static final String OUTDIAL_LOC_ID = "GXMO";

    @Test
    @Rollback(false)
    public void 외부접속테스트() throws Exception {

        // given
        Cust cust = Cust.builder()
                .custId(CUST_ID)
                .custName(CUST_NAME)
                .registUserId(ADMIN_ID)
                .build();
        em.persist(cust);

        Outdial outdial = Outdial.builder()
                .cust(cust)
                .locationId(OUTDIAL_LOC_ID)
                .registUserId(ADMIN_ID)
                .build();

        OutdialKey outdialKey = OutdialKey.builder()
                .cust(cust)
                .locationId(OUTDIAL_LOC_ID)
                .build();

        // when
        outdialRepository.save(outdial);
        Outdial findOutdial = outdialRepository.findByCustId(outdialKey);

        // then
//        assertEquals(findOutdial.getCustId(), cust.getCustId());
//        assertEquals(findOutdial.getCust(), cust);
        assertEquals(findOutdial, outdial);
    }

}