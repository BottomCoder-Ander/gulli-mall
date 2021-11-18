package cool.cade.mall.thisparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


import javax.validation.constraints.Pattern;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Cade
 * @date 2021/11/17 - 19:00
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MallThirdPartyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallThirdPartyApplication.class, args);
    }
}
