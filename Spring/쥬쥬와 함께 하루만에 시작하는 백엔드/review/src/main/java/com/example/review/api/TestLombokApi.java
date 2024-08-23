package com.example.review.api;

import lombok.Getter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLombokApi {

    @GetMapping("/test/lombok")
    public TestLombokResponseBody testLombok() {
        return new TestLombokResponseBody("김찬영", 23);
    }

    @Getter
    @AllArgsConstructor
    public static class TestLombokResponseBody{
        String name;

        Integer age;
    }
}
