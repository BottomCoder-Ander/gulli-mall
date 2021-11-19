package cool.cade.mall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Cade
 * @date 12/11/2021 - 00:18
 */
@MapperScan("cool.cade.mall.member.dao")
// @EnableFeignClients(basePackages = "")
@EnableDiscoveryClient
@SpringBootApplication
public class MallMemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallMemberApplication.class, args);
    }
}
