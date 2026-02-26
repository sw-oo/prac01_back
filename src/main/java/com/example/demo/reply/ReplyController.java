package com.example.demo.reply;

import com.example.demo.common.model.BaseResponse;
import com.example.demo.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reply")
@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping
    public ResponseEntity create(@RequestBody  ReplyDto.RegReq dto) {
        replyService.save(dto);
        return ResponseEntity.ok("reply success");
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable Long idx) {
        return ResponseEntity.ok().body(BaseResponse.success(replyService.read(idx)));
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(BaseResponse.success(replyService.list()));
    }
}
