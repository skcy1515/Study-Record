package com.example.review.api;

import com.example.review.model.TestEntity;
import com.example.review.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestQueryApi {
    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestEntity> queryJpa() {
        return testService.findAllByNameByJPA("찬영");
    }
}
