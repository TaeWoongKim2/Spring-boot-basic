package com.ktnet.gethub.oss;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestClassTest {
    @Test
    void name() {
        TestClass test = TestClass.builder().author("EHOTO").build();
        System.out.println(test.getAuthor());
    }
}