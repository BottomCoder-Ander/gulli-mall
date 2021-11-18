package cool.cade.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 10:32:23
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

