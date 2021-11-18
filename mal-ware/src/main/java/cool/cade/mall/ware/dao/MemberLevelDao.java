package cool.cade.mall.ware.dao;

import cool.cade.mall.ware.entity.MemberLevelEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员等级
 * 
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 10:32:23
 */
@Mapper
public interface MemberLevelDao extends BaseMapper<MemberLevelEntity> {
	
}
