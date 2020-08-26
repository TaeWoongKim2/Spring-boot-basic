package com.ktnet.gethub.oss.core.domain.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 읽기 전용이 된다. 값을 변경된다고 변경되지 않음.
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(String name) {
        this.name = name;
    }

}
