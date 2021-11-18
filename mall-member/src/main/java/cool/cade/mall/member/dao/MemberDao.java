package cool.cade.mall.member.dao;

import cool.cade.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 00:53:40
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
