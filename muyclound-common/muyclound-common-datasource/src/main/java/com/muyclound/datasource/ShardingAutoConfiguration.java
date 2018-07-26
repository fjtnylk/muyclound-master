package com.muyclound.datasource;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.muyclound.datasource.masterslave.SpringBootMasterSlaveRuleConfigurationProperties;
import com.muyclound.datasource.sharding.SpringBootShardingRuleConfigurationProperties;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import io.shardingjdbc.core.api.ShardingDataSourceFactory;
import io.shardingjdbc.core.constant.ShardingPropertiesConstant;
import io.shardingjdbc.core.exception.ShardingJdbcException;
import io.shardingjdbc.core.util.DataSourceUtil;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by yanglikai on 2018/7/25.
 */
@Configuration
@EnableConfigurationProperties({SpringBootShardingRuleConfigurationProperties.class, SpringBootMasterSlaveRuleConfigurationProperties.class})
public class ShardingAutoConfiguration implements EnvironmentAware {
  @Resource
  private SpringBootShardingRuleConfigurationProperties shardingProperties;

  @Resource
  private SpringBootMasterSlaveRuleConfigurationProperties masterSlaveProperties;

  private final Map<String, DataSource> dataSourceMap = new HashMap<>();

  private final Properties props = new Properties();

  @Bean
  public DataSource dataSource() throws SQLException {
    return null == masterSlaveProperties.getMasterDataSourceName() ? ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingProperties.getShardingRuleConfiguration(), new HashMap<>(), props)
        : MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveProperties.getMasterSlaveRuleConfiguration(), new HashMap<>());
  }

  @Override
  public void setEnvironment(Environment environment) {
    setDataSourceMap(environment);
    setShardingProperties(environment);
  }

  private void setDataSourceMap(final Environment environment) {
    RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "sharding.jdbc.datasource.");
    String dataSources = propertyResolver.getProperty("names");
    for (String each : dataSources.split(",")) {
      try {
        Map<String, Object> dataSourceProps = propertyResolver.getSubProperties(each + ".");
        Preconditions.checkState(!dataSourceProps.isEmpty(), "Wrong datasource properties!");
        DataSource dataSource = DataSourceUtil.getDataSource(dataSourceProps.get("type").toString(), dataSourceProps);
        dataSourceMap.put(each, dataSource);
      } catch (final ReflectiveOperationException ex) {
        throw new ShardingJdbcException("Can't find datasource type!", ex);
      }
    }
  }

  private void setShardingProperties(final Environment environment) {
    RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "sharding.jdbc.config.sharding.props.");
    String showSQL = propertyResolver.getProperty(ShardingPropertiesConstant.SQL_SHOW.getKey());
    if (!Strings.isNullOrEmpty(showSQL)) {
      props.setProperty(ShardingPropertiesConstant.SQL_SHOW.getKey(), showSQL);
    }
    String executorSize = propertyResolver.getProperty(ShardingPropertiesConstant.EXECUTOR_SIZE.getKey());
    if (!Strings.isNullOrEmpty(executorSize)) {
      props.setProperty(ShardingPropertiesConstant.EXECUTOR_SIZE.getKey(), executorSize);
    }
  }
}
