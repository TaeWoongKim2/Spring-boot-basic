package com.ktnet.gethub.oss.core.domain.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)   // Default, ORDINAL : 자동적으로 순번이 매겨짐. 위험!!! 꼭, STRING으로 사용하는 것이 좋음!
    private DeliveryStatus status ;// READY,

}
