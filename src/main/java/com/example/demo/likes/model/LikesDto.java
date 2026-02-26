package com.example.demo.likes.model;

import com.example.demo.reply.model.Reply;
import lombok.Builder;
import lombok.Getter;

public class LikesDto {
    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private Long boardIdx;
        private String writer;

        public static ListRes from(Likes entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .boardIdx(entity.getBoard().getIdx())
                    .writer(entity.getUser().getName())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ReadRes {
        private Long idx;
        private Long boardIdx;
        private String writer;

        public static ReadRes from(Likes entity) {
            return ReadRes.builder()
                    .idx(entity.getIdx())
                    .boardIdx(entity.getBoard().getIdx())
                    .writer(entity.getUser().getName())
                    .build();
        }
    }
}
