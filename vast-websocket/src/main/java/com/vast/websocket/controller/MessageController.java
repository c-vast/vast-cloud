package com.vast.websocket.controller;

import com.vast.common.annotation.IgnoreUserToken;
import com.vast.common.enums.ResultCode;
import com.vast.common.result.Result;
import com.vast.websocket.session.WebSocketSessionManage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {

    @GetMapping("send/{userId}/{message}")
    @IgnoreUserToken
    public Result send(@PathVariable("userId") String userId,@PathVariable("message") String message){
        boolean b = WebSocketSessionManage.sendMessage(userId, message);
        if (b){
            return Result.success();
        }
        return Result.failure(ResultCode.FAILURE);
    }
}
