package cn.kafka.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
@EnableSwagger2
public class KafkaDemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(KafkaDemoApplication.class).run(args);
    }
}