package com.ktnet.gethub.oss.core.domain.dao.oss;

import com.ktnet.gethub.oss.core.domain.dao.Member;
import com.ktnet.gethub.oss.core.domain.dao.Order;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cust")
@Getter
@NoArgsConstructor
public class Cust {

    @Id @Column(length = 40, name = "cust_id")
    private String custId;

    @OneToMany(mappedBy = "cust")
    private List<Tp> tps = new ArrayList<>();

    @OneToOne(mappedBy = "cust", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private Indial indial;

    @Column(length = 40)
    private String custName;

    @Column(length = 1)
    private String custType;

    @Column(length = 1)
    private String custStatus;

    @Column(length = 3)
    private String custMsgFormat;

    @Column(length = 40)
    private String custGroup;

    @Column(length = 6)
    private String nextRawMsgNum;

    @Column(length = 1)
    private String msgAcptType;

    @Column(length = 1)
    private String msgDlvrType;

    @Column(length = 5)
    private String msgRetentionPerid;

    @Column(length = 7)
    private String ackMsgType;

    @Column(length = 4)
    private String notifMsgType;

    @Column(length = 1)
    private String billFlag;

    @Column(length = 1)
    private String billObjFlag;

    @Column(length = 4)
    private String aspcopyTpQual;

    @Column(length = 1)
    private String aspcopyUseFlag;

    @Column(length = 1)
    private String slotFlag;

    @Column(length = 14)
    private String ServiceApplyDatetime;

    @Column(length = 14)
    private String ServiceApprvDatetime;

    @Column(length = 14)
    private String ServiceAbandnDatetime;

    @Column(length = 14)
    private String tradeRegistNum;

    @Column(length = 14)
    private String businessNum;

    @Column(length = 14)
    private String taxPresidentName;

    @Column(length = 14)
    private String taxCompanyName;

    @Column(length = 17)
    private String taxZipCode;

    @Column(length = 128, name = "TAX_ADDR_1")
    private String taxAddr1;

    @Column(length = 128, name = "TAX_ADDR_2")
    private String taxAddr2;

    @Column(length = 100)
    private String taxBusiType;

    @Column(length = 100)
    private String taxBusiItem;

    @Column(length = 10)
    private String charSet;

    @Column(length = 1)
    private String hostServiceUseFlag;

    @Column(length = 128)
    private String remark;

    @Column(length = 16, nullable = false)
    private String registUserId;

    @Column(length = 14, nullable = false)
    private String registDatetime;

    @Column(length = 16)
    private String modifyUserId;

    @Column(length = 14)
    private String modifyDatetime;

    //==생성 메서드==//
    @Builder
    public Cust(String custId, String custName, String registUserId) {
        this.custId = custId;
        this.custName = custName;
        this.registUserId =  registUserId;
        this. registDatetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

}
