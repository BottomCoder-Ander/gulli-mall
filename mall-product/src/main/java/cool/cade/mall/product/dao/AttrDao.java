package cool.cade.mall.product.dao;

import cool.cade.mall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 * 
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 08:31:12
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	
}
