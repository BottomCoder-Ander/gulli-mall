package cool.cade.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.product.entity.AttrEntity;
import cool.cade.mall.product.vo.AttrVO;

import java.util.Map;

/**
 * 商品属性
 *
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 08:31:12
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVO attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId);
}

