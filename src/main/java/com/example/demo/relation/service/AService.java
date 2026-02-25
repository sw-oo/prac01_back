package com.example.demo.relation.service;

import com.example.demo.relation.model.A;
import com.example.demo.relation.repository.ARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AService {
    private final ARepository aRepository;

    public void read(Long idx) {
        A a = aRepository.findById(idx).orElseThrow();
    }

    public List<A> list() {
        List<A> list = aRepository.findAll();
        return list;
    }
}
