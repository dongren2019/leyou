package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dongren
 * @create 2019-08-07 15:38
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LeyouAuth_App8087 {
    public static void main(String[] args) {
        SpringApplication.run(LeyouAuth_App8087.class,args);
    }
}
