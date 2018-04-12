package com.muyclound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class MuycloundProviderUmcApplication {

  public static void main(String[] args) {
    SpringApplication.run(MuycloundProviderUmcApplication.class, args);
  }

  @RestController
  public static class SimpleStoresController {
    @RequestMapping("/simple/stores")
    @ResponseBody
    String getStores() {
      return "yanglikai";
    }
  }
}
