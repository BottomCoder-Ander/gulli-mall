package cool.cade.mall.coupon.dao;

import cool.cade.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 09:22:58
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
