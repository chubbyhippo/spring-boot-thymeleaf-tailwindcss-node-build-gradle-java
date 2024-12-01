package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

class DemoApplicationTests {

    @Test
    void shouldRunMainWithoutException() {
        final var RANDOM_PORT_NUMBER = "--server.port=0";
        assertThatNoException().isThrownBy(() -> DemoApplication.main(new String[]{RANDOM_PORT_NUMBER}));
    }

}
