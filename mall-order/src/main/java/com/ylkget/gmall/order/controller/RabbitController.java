package com.ylkget.gmall.order.controller;

import com.ylkget.gmall.order.entity.OrderEntity;
import com.ylkget.gmall.order.entity.OrderReturnReasonEntity;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * RabbitController
 * </p>
 *
 * @author joe 2021/2/28 16:44
 */
@RestController
public class RabbitController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    /*
     * @author joe 2021/2/28 16:45
     * http://127.0.0.1:9000/sendMq
     * @param num: 
     * @return {@link java.lang.String }
     **/
    @GetMapping("/sendMq")
    public String sendMq(@RequestParam(value = "num",defaultValue = "10") Integer num){
        for (int i=0;i<num;i++){
            if(i%2 == 0){
                OrderReturnReasonEntity reasonEntity = new OrderReturnReasonEntity();
                reasonEntity.setId(1L);
                reasonEntity.setCreateTime(new Date());
                reasonEntity.setName("哈哈-"+i);
                rabbitTemplate.convertAndSend("hello-java-exchange", "hello.java", reasonEntity,new CorrelationData(UUID.randomUUID().toString()));
            }else {
                OrderEntity entity = new OrderEntity();
                entity.setOrderSn(UUID.randomUUID().toString());
                // 模拟发送失败
//                rabbitTemplate.convertAndSend("hello-java-exchange", "hello22.java", entity,new CorrelationData(UUID.randomUUID().toString()));
                rabbitTemplate.convertAndSend("hello-java-exchange", "hello.java", entity,new CorrelationData(UUID.randomUUID().toString()));
            }
        }

        return "ok";
    }

}
