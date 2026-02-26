package com.example.demo.reply;
import com.example.demo.board.BoardRepository;
import com.example.demo.board.model.Board;
import com.example.demo.common.exception.BaseException;
import com.example.demo.reply.model.Reply;
import com.example.demo.reply.model.ReplyDto;
import com.example.demo.user.UserRepository;
import com.example.demo.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.example.demo.common.model.BaseResponseStatus.*;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public void save(ReplyDto.RegReq dto, Long userIdx, Long boardIdx) {
        User user = userRepository.findById(userIdx).orElseThrow(() -> BaseException.from(SIGNUP_INVALID_UUID));
        Board board = boardRepository.findById(boardIdx).orElseThrow(() -> BaseException.from(BOARD_INVAILD_ID));
        replyRepository.save(dto.toEntity(user, board));
    }

    public ReplyDto.ReadRes read(Long idx) {
        Reply reply = replyRepository.findById(idx).orElseThrow(() -> BaseException.from(REPLY_INVALID));
        return ReplyDto.ReadRes.from(reply);
    }

    public List<ReplyDto.ListRes> list() {
        List<Reply> replyList = replyRepository.findAll();
        return replyList.stream().map(ReplyDto.ListRes::from).toList();
    }

}
