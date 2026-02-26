package com.example.demo.reply;

import com.example.demo.common.model.BaseResponse;
import com.example.demo.reply.model.ReplyDto;
import com.example.demo.user.model.AuthUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reply")
@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/{idx}")
    public ResponseEntity create(@RequestBody ReplyDto.RegReq dto, @AuthenticationPrincipal AuthUserDetails user, @PathVariable Long idx) {
        replyService.save(dto, user.getIdx(), idx);
        return ResponseEntity.ok("reply success");
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable Long idx, @AuthenticationPrincipal AuthUserDetails user) {
        return ResponseEntity.ok().body(BaseResponse.success(replyService.read(idx)));
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(BaseResponse.success(replyService.list()));
    }
}
