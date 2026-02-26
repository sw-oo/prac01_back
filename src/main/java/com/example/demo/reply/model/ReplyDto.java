package com.example.demo.reply.model;

import com.example.demo.board.model.Board;
import com.example.demo.user.model.User;
import lombok.Builder;
import lombok.Getter;

public class ReplyDto {
    @Getter
    public static class RegReq {
        private String contents;

        public Reply toEntity(User user, Board board) {
            return Reply.builder()
                    .contents(this.contents)
                    .user(user)
                    .board(board)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class RegRes {
        private Long idx;
        private String contents;
        private Long userIdx;
        private Long boardIdx;

        public static RegRes from(Reply entity) {
            return RegRes.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .userIdx(entity.getUser().getIdx())
                    .boardIdx(entity.getBoard().getIdx())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String contents;
        private Long boardIdx;
        private String writer;

        public static ListRes from(Reply entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .boardIdx(entity.getBoard().getIdx())
                    .writer(entity.getUser().getName())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ReadRes {
        private Long idx;
        private String contents;
        private Long boardIdx;
        private String writer;

        public static ReadRes from(Reply entity) {
            return ReadRes.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .boardIdx(entity.getBoard().getIdx())
                    .writer(entity.getUser().getName())
                    .build();
        }
    }
}
