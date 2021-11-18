package cool.cade.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 08:31:13
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

