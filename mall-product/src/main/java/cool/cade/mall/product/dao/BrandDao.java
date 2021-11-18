package cool.cade.mall.product.dao;

import cool.cade.mall.product.entity.BrandEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌
 * 
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 08:31:13
 */
@Mapper
public interface BrandDao extends BaseMapper<BrandEntity> {
	
}
