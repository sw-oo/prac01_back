package com.example.demo.relation.repository;

import com.example.demo.relation.model.B;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BRepository extends JpaRepository<B, Long> {
}
