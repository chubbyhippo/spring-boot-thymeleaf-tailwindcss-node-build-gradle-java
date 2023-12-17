package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatNoException;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void shouldRunMainWithoutException() {
        var randomPortNumber = "--server.port=0";
        assertThatNoException().isThrownBy(() -> DemoApplication.main(new String[]{randomPortNumber}));
    }

}
