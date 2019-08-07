package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author dongren
 * @create 2019-07-29 14:15
 */
@SpringBootApplication
@EnableEurekaServer
public class LeyouRegistry_App10086 {
    public static void main(String[] args) {
        SpringApplication.run(LeyouRegistry_App10086.class,args);
    }
}
