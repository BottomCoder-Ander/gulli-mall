package cool.cade.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.order.entity.MqMessageEntity;

import java.util.Map;

/**
 * 
 *
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 00:49:49
 */
public interface MqMessageService extends IService<MqMessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

