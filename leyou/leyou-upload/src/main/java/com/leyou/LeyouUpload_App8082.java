package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dongren
 * @create 2019-07-30 22:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LeyouUpload_App8082 {
    public static void main(String[] args) {
        SpringApplication.run(LeyouUpload_App8082.class,args);
    }
}
