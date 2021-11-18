package cool.cade.mall.order.dao;

import cool.cade.mall.order.entity.UndoLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 00:49:49
 */
@Mapper
public interface UndoLogDao extends BaseMapper<UndoLogEntity> {
	
}
