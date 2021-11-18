package cool.cade.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cade
 * @date 2021/11/15 - 9:59
 */

@RestController
public class GateWayConfigCenterTest {
    @Value("${spring.cloud.gateway.routes[0].uri}")
    private String routeUri;

    @Value("${spring.cloud.gateway.routes[0].id}")
    private String routeId;

    @Value("${spring.cloud.gateway.routes[0].predicates[0]}")
    private String routePredicatePath;

    @GetMapping("/gateway/testconfig")
    public String getconfig(){
        return routeUri + " " + routeId + " " + routePredicatePath;
    }

}
