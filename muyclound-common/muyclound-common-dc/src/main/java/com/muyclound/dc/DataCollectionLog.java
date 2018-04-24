package com.muyclound.dc;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import com.muyclound.dc.constant.DCConstant;
import com.muyclound.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 数据采集.
 * Created by yanglikai on 2018/4/23.
 */
@Component
public class DataCollectionLog implements InitializingBean {
  private static final Logger log = LoggerFactory.getLogger(DataCollectionLog.class);

  public static void log(CollectionData value) {
    log.info(JSONUtil.toJSON(value));
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    String appname = loggerContext.getName();

    RollingFileAppender appender = new RollingFileAppender();
    appender.setContext(loggerContext);
    appender.setName(DCConstant.DC_NAME);
    appender.setFile(DCConstant.LOGGER_HOME + "/" + appname + "/DC/datacollect.log");

    TimeBasedRollingPolicy rollingPolicy = new TimeBasedRollingPolicy();
    rollingPolicy.setFileNamePattern(DCConstant.LOGGER_HOME + "/" + appname + "/DC/datacollect.%d{yyyyMMdd}.log");
    rollingPolicy.setMaxHistory(30);
    rollingPolicy.setParent(appender);
    rollingPolicy.setContext(loggerContext);
    rollingPolicy.start();
    appender.setRollingPolicy(rollingPolicy);

    PatternLayoutEncoder encoder = new PatternLayoutEncoder();
    encoder.setPattern(DCConstant.PATTERN);
    encoder.setContext(loggerContext);
    encoder.start();
    appender.setEncoder(encoder);

    appender.start();

    ch.qos.logback.classic.Logger logger = loggerContext.getLogger(DataCollectionLog.class);
    logger.setLevel(Level.INFO);
    logger.setAdditive(false);
    logger.addAppender(appender);
  }
}
