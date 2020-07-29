package com.ktnet.gethub.oss.core.domain.dao.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue("B") // 상속관계 지정
@Getter
public class Book extends Item {

    private String author;
    private String isbn;

}
/*

*/
