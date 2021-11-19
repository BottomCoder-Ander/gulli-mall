package cool.cade.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.product.entity.AttrAttrgroupRelationEntity;
import cool.cade.mall.product.vo.AttrGroupRelationVO;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 08:31:13
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveBatch(List<AttrGroupRelationVO> vos);
}

