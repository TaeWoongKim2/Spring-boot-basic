package com.ktnet.gethub.oss.core.domain.dao.oss;

import com.ktnet.gethub.oss.core.domain.dao.Delivery;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.sound.midi.Instrument;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "INDIAL")
@Getter
@NoArgsConstructor
public class Indial implements Serializable {

    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "cust_id")
    private Cust cust;

    @Column(length = 80)
    private String logonPswd;

    @Column(length = 64)
    private String capId;

    @Column(length = 22)
    private String maxDlvrMsgCnt;

    @Column(length = 2)
    private String recvEofChar;

    @Column(length = 2)
    private String sendEofChar;

    @Column(length = 80)
    private String logoffString;

    @Column(length = 40)
    private String logonAckString;

    @Column(length = 12)
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

    @Column(length = 22)
    private String ackTimeout;

    @Column(length = 128)
    private String remoteAddr;

    @Column(length = 1)
    private String validCheckFlag;

    @Column(length = 1)
    private String eofUseFlag;

    @Column(length = 14)
    private String pswdModifyDatetime;

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
    public Indial(Cust cust, String registUserId) {
        this.cust = cust;
        this.registUserId = registUserId;
        this.registDatetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

}
