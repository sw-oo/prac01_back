package com.example.demo.relation.controller;

import com.example.demo.common.model.BaseResponse;
import com.example.demo.relation.service.AService;
import com.example.demo.relation.model.A;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/a")
@RequiredArgsConstructor
@RestController
public class AController {
    private final AService aService;

    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable Long idx) {
        aService.read(idx);
        return ResponseEntity.ok(BaseResponse.success("read Success"));
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        List<A> list = aService.list();
        return ResponseEntity.ok(aService.list());
    }

}
