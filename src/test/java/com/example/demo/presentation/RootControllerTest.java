package com.example.demo.presentation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@WebMvcTest(RootController.class)
class RootControllerTest {

    @Test
    @DisplayName("Should return index page response using mock mvc")
    void shouldReturnIndexPageResponseUsingMockMvc(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @DisplayName("should return index page using mock mvc tester")
    void shouldReturnIndexPageUsingMockMvcTester(@Autowired MockMvcTester mockMvcTester) {
        mockMvcTester.get()
                .uri("/")
                .assertThat()
                .doesNotHaveFailed()
                .hasStatusOk()
                .hasViewName("index");
    }
}