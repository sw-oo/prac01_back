package com.example.demo.likes.model;

import com.example.demo.board.model.Board;
import com.example.demo.reply.model.Reply;
import com.example.demo.user.model.User;
import lombok.Builder;
import lombok.Getter;

public class LikesDto {

    @Getter
    public static class CreateReq {
        public static Likes toEntity(User user, Board board) {
            return Likes.builder()
                    .user(user)
                    .board(board)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class CreateRes {
        private Long idx;
        private Long userIdx;
        private Long boardIdx;

        public static CreateRes from(Likes entity) {
            return CreateRes.builder()
                    .idx(entity.getIdx())
                    .userIdx(entity.getUser().getIdx())
                    .boardIdx(entity.getBoard().getIdx())
                    .build();
        }
    }
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
