package com.ktnet.gethub.oss.core.domain.dao.oss;

import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
@NoArgsConstructor
public class CommonCodeKey implements Serializable {

    public static final int CODE_SIZE = 55;

    @EqualsAndHashCode.Include
    @Column(length = 55)
    private String codeGroupId;

    @EqualsAndHashCode.Include
    @Column(length = 55)
    private String codeId;

    @Builder
    public CommonCodeKey(String codeGroupId, String codeId) {
        Preconditions.checkArgument(codeGroupId.length() <= CODE_SIZE);
        Preconditions.checkArgument(codeId.length() <= CODE_SIZE);

        this.codeGroupId = codeGroupId;
        this.codeId = codeId;
    }

}
