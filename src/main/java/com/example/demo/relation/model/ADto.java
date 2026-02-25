package com.example.demo.relation.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class ADto {
    @Builder
    @Getter
    public static class ARes {
        Long idx;
        String a01;
        List<BDto.BRes> BList;

        public static ARes from(A entity) {
            return ARes.builder()
                    .idx(entity.getIdx())
                    .a01(entity.getA01())
                    .BList(entity.getBList().stream().map(BDto.BRes::from).toList())
                    .build();
        }
    }
}
