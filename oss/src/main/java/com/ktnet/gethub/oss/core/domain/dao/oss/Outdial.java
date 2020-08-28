package com.ktnet.gethub.oss.core.domain.dao.oss;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "OUTDIAL")
@IdClass(OutdialKey.class)
@Getter
@NoArgsConstructor
public class Outdial implements Serializable {

    @Id
    private Cust cust;

    @Id
    private String locationId;

//    @OneToOne(optional = false)
//    @JoinColumns(value = {
//            @JoinColumn(name = "custId", updatable = false, insertable = false)
//    }, foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Cust cust;

//    @Id
//    @OneToOne(optional = false)
//    @JoinColumn(name = "cust_id")
//    private Cust cust;
//
//    @Column(length = 4)
//    private String locationId;

    @Column(length = 64)
    private String capId;

    @Column(length = 128)
    private String remoteAddr;

    @Column(length = 22)
    private String maxDlvrMsgCnt;

    @Column(length = 2)
    private String recvEofChar;

    @Column(length = 2)
    private String sendEofChar;

    @Column(length = 80)
    private String logonString;

    @Column(length = 80)
    private String logoffString;

    @Column(length = 40)
    private String logonAckString;

    @Column(length = 40)
    private String logoffAckString;

    @Column(length = 10)
    private String sessionCode;

    @Column(length = 40)
    private String noDataText;

    @Column(length = 512)
    private String description;

    @Column(length = 2)
    private String firstStatusCode;

    @Column(length = 2)
    private String traceLevel;

    @Column(length = 1)
    private String spLogicFlag;

    @Column(length = 1)
    private String spLogicUkFlag;

    @Column(length = 1)
    private String restartByteFlag;

    @Column(length = 1)
    private String mod255Flag;

    @Column(length = 1)
    private String oftpPassthruFlag;

    @Column(length = 1)
    private String oftpVer;

    @Column(length = 1)
    private String ackPendingFlag;

    @Column(length = 5)
    private String ackTimeout;

    @Column(length = 3)
    private String turnaroundTimeout;

    @Column(length = 3)
    private String sendRecvTimeout;

    @Column(length = 3)
    private String protocolTimeout;

    @Column(length = 1)
    private String validCheckFlag;

    @Column(length = 1)
    private String slotFlag;

    @Column(length = 2)
    private String dlvrInterval;

    @Column(length = 1)
    private String connLogFlag;

    @Column(length = 2)
    private String maxRetryCnt;

    @Column(length = 2)
    private String retryInterval;

    @Column(length = 10)
    private String baudRateCode;

    @Column(length = 1)
    private String padFlag;

    @Column(length = 1)
    private String padChar;

    @Column(length = 512)
    private String sourceDir;

    @Column(length = 512)
    private String destinationDir;

    @Column(length = 1)
    private String file_nameFormat;

    @Column(length = 2)
    private String processCnt;

    @Column(length = 1)
    private String dialFlag;

    @Column(length = 16, nullable = false)
    private String registUserId;

    @Column(length = 14, nullable = false)
    private String registDatetime;

    @Column(length = 16)
    private String modifyUserId;

    @Column(length = 14)
    private String modifyDatetime;

    @Column(length = 4)
    private String headerCode;

    @Builder
    public Outdial(Cust cust, String locationId, String registUserId) {
        this.cust = cust;
        this.locationId = locationId;
        this.registUserId = registUserId;
        this.registDatetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

}
