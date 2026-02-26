package com.example.demo.reply;
import com.example.demo.common.exception.BaseException;
import com.example.demo.reply.model.Reply;
import com.example.demo.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.example.demo.common.model.BaseResponseStatus.REPLY_INVALID;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public void save(ReplyDto.RegReq dto) {
        replyRepository.save(dto.toEntity());
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
