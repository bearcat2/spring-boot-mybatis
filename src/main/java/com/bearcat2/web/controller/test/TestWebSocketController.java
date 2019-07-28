package com.bearcat2.web.controller.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * <p> Description: 测试websocket相关的例子 控制器 </p>
 * <p> Title: TestWebSocketController </p>
 * <p> Create Time: 2019/7/28 16:40 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Slf4j
@Controller
@RequestMapping("/testWebSocket")
public class TestWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/index")
    public String websocketUi() {
        return "websocket_client";
    }

    @MessageMapping("/receivedClientMessage")
    public void receivedClientMessage(String message) {
        log.info("接收到客户端发送消息 = {}", message);
        String destination = "/topic/getServerResponse";
        String payload = StrUtil.format("服务端已接收消息,响应数据 => {} , 响应时间 => {}"
                , message
                , DateUtil.formatDateTime(new Date())
        );
        // 广播
        messagingTemplate.convertAndSend(destination, payload);
        log.info("服务端响应消息 = {}", payload);
    }
}
