package org.qhn.demo.test;

import com.google.gson.Gson;
import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: qihenan
 * @Date: 2019/12/25 14:29
 * @Description:
 */
@RestController
public class SimpleController {

    private static Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @GetMapping("/send/{messge}")
    public String send(@PathVariable String messge) {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        Gson gson = new Gson();
        logger.info("发送消息 ----->>>>>  message = {}", gson.toJson(message));
        kafkaTemplate.send("hello", gson.toJson(message));
        kafkaTemplate.send("test", "test:" + messge);
        return messge;
    }

}
