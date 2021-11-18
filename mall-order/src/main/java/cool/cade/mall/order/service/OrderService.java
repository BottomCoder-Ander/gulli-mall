package cool.cade.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 00:49:49
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

