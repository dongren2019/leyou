package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author dongren
 * @create 2019-07-29 14:25
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class LeyouGateWay_App10010 {
    public static void main(String[] args) {
        SpringApplication.run(LeyouGateWay_App10010.class,args);
    }
}


