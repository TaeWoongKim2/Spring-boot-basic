package com.ktnet.gethub.oss.core.domain.dao.oss;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class OutdialKey implements Serializable {

    @EqualsAndHashCode.Include
    @OneToOne(optional = false)
    @JoinColumn(name = "cust_id")
    private Cust cust;

    @EqualsAndHashCode.Include
    @Id
    private String locationId;

    @Builder
    public OutdialKey(Cust cust, String locationId) {
        this.cust = cust;
        this.locationId = locationId;
    }
}
