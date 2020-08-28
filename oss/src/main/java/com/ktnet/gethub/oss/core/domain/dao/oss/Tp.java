package com.ktnet.gethub.oss.core.domain.dao.oss;

import com.ktnet.gethub.oss.core.domain.dao.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "TP")
@Getter
@NoArgsConstructor
public class Tp {

    @Id
    @Column(length = 39)
    private String tpId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    private Cust cust;

    @Column(length = 60)
    private String tpName;

    @Column(length = 1)
    private String tpType;

    @Column(length = 8)
    private String tpUserData;

    @Column(length = 1)
    private String billFlag;

    @Column(length = 4)
    private String qual;

    @Column(length = 35, nullable = false)
    private String identifier;

    @Column(length = 35)
    private String locationId;

    @Column(length = 35)
    private String sfiddestOrOgie;

    @Column(length = 35)
    private String msgSubFormat;

    @Column(length = 35)
    private String dept;

    @Column(length = 35)
    private String title;

    @Column(length = 35)
    private String chargerName;

    @Column(length = 35)
    private String zipCode;

    @Column(length = 35, name = "addr_1")
    private String addr1;

    @Column(length = 35, name = "addr_2")
    private String addr2;

    @Column(length = 35)
    private String phoneNum;

    @Column(length = 35)
    private String faxNum;

    @Column(length = 35)
    private String emailAddr;

    @Column(length = 35)
    private String businessNum;

    @Column(length = 35)
    private String aspcopyTpFlag;

    @Column(length = 16, nullable = false)
    private String registUserId;

    @Column(length = 14, nullable = false)
    private String registDatetime;

    @Column(length = 16)
    private String modifyUserId;

    @Column(length = 14)
    private String modifyDatetime;

    @Column(length = 1)
    private String ediFlag;

    @Builder
    public Tp(Cust cust, String tpId, String identifier, String registUserId) {
        this.cust = cust;
        this.tpId = tpId;
        this.identifier = identifier;
        this.registUserId =  registUserId;
        this. registDatetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

}
