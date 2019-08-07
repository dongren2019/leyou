package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dongren
 * @create 2019-08-05 13:28
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LeyouGoodsWeb_App8084 {

    public static void main(String[] args) {
        SpringApplication.run(LeyouGoodsWeb_App8084.class,args);
    }
}
