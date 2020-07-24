package com.ktnet.gethub.oss;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestClass {
    private String author;

    @Builder
    TestClass(String author) {
        this.author = author;
    }

}
