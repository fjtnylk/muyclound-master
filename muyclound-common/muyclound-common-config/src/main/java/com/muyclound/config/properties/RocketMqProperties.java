package com.muyclound.config.properties;

import lombok.Data;

/**
 * Created by yanglikai on 2018/4/11.
 */
@Data
public class RocketMqProperties {
  private String producerGroup;
  private String consumerGroup;
  private String namesrvAddr;

  /**
   * 生产者是否使用可靠消息, 默认不使用 @MqConsumerStore
   */
  private boolean reliableMessageProducer;

  /**
   * 消费者是否使用可靠消息, 默认不使用 @MqProducerStore
   */
  private boolean reliableMessageConsumer;
}
