package com.ktnet.gethub.oss.core.domain.dao.oss;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 이와 같이 잡아주면 누군가의 new() 연산자를 통한 객체 생성을 막을 수 있다.
public class CommonCode {

    @EmbeddedId
    private CommonCodeKey id;

    @Column(length = 512)
    private String codeValue;

    @Column(length = 512)
    private String description;

    @Column(length = 1)
    private String useFlag;

    @Column(length = 16)
    private String registUserId;
    @Column(length = 14)
    private String registDatetime;

    @Column(length = 16)
    private String modifyUserId;
    @Column(length = 14)
    private String modifyDatetime;

    @Column(length = 8)
    private String userField;
    @Column(length = 22)
    private int orderSeq;

    @Builder
    public CommonCode(CommonCodeKey id) {
        this.id = id;
    }

}
