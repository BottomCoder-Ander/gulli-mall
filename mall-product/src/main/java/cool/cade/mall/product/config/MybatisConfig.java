package cool.cade.mall.product.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Cade
 * @date 2021/11/18 - 16:34
 */
@Configuration
@EnableTransactionManagement //开启全局事务管理，只有开启这个，Transactional注解才有用
@MapperScan("cool.cade.mall.product.dao")
public class MybatisConfig {

    // 查询一般不加事务，即使幻读，也不是什么大事
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(){
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
//        设置请求的页面大于最大页操作后，true调会首页，false继续请求，默认false
        paginationInnerInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认500条，-1不受限制
        // paginationInnerInterceptor.setLimit(500);
        return paginationInnerInterceptor;

    }
}
