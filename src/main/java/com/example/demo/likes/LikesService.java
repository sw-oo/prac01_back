package com.example.demo.likes;

import com.example.demo.board.BoardRepository;
import com.example.demo.board.model.Board;
import com.example.demo.common.exception.BaseException;
import com.example.demo.common.model.BaseResponseStatus;
import com.example.demo.likes.model.LikesDto;
import com.example.demo.user.UserRepository;
import com.example.demo.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository likesRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public LikesDto.CreateRes save(LikesDto.CreateReq dto, Long userIdx, Long boardIdx) {
        User user = userRepository.findById(userIdx).orElseThrow(() -> BaseException.from(BaseResponseStatus.SIGNUP_INVALID_UUID));
        Board board = boardRepository.findById(boardIdx).orElseThrow(() -> BaseException.from(BaseResponseStatus.BOARD_INVAILD_ID));

        return LikesDto.CreateRes.from(likesRepository.save(dto.toEntity(user, board)));
    }
}
