package com.example.demo.likes;


import com.example.demo.common.model.BaseResponse;
import com.example.demo.likes.model.LikesDto;
import com.example.demo.user.model.AuthUserDetails;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/likes")
@RequiredArgsConstructor
@RestController
public class LikesController {
    private final LikesService likesService;

    @PostMapping("/{boardIdx}")
    public ResponseEntity create(@RequestBody LikesDto.CreateReq dto, @AuthenticationPrincipal AuthUserDetails user, @PathVariable Long boardIdx) {
        return ResponseEntity.ok().body(BaseResponse.success(likesService.save(dto, user.getIdx(), boardIdx)));
    }


}
