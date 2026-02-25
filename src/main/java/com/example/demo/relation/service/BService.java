package com.example.demo.relation.service;

import com.example.demo.relation.model.B;
import com.example.demo.relation.repository.BRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BService {
    private final BRepository bRepository;

    public void read(Long idx) {
        B b = bRepository.findById(idx).orElseThrow();
    }

    public List<B> list() {
        List<B> list = bRepository.findAll();
        return list;
    }
}
