package cool.cade.mall.product;

import cool.cade.mall.product.entity.BrandEntity;
import cool.cade.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Cade
 * @date 14/11/2021 - 08:01
 */
//@RunWith(SpringRunner.class)

@SpringBootTest
public class MallProductCURDTest {

    @Autowired
    BrandService brandService;

    @Test
    public void contextLoads(){
        BrandEntity brandEntity = new BrandEntity();

        List<BrandEntity> list = brandService.query().list();
        list.forEach(System.out::print);
    }
}
