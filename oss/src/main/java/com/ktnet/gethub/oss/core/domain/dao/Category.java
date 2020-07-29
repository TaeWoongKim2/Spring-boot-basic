package com.ktnet.gethub.oss.core.domain.dao;

import com.ktnet.gethub.oss.core.domain.dao.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
        joinColumns = @JoinColumn(name = "category_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //==연관관계 메서드==//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }

}
/*
    Tip! 다 대 다 관계는 중간 테이블을 통해 풀어내는 과정이 필요하다!
    다대다 관계는 컬럼 값이 두개 이상으로 들어가면 실무에서는 구성하기가 어렵고 불필요하게 된다.
    다른 방식으로 풀어내는 것이 중요하다!
*/
