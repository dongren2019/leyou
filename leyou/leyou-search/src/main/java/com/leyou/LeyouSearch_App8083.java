package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dongren
 * @create 2019-08-03 19:33
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LeyouSearch_App8083 {
    public static void main(String[] args) {
        SpringApplication.run(LeyouSearch_App8083.class,args);
    }
}
