package cool.cade.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.member.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 00:53:39
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

