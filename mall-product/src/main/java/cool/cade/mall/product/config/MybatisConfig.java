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
@EnableTransactionManagement //开启事务，多查询要开启事务
@MapperScan("cool.cade.mall.product.dao")
public class MybatisConfig {
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
