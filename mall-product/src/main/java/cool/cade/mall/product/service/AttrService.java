package cool.cade.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.product.entity.AttrEntity;
import cool.cade.mall.product.vo.AttrGroupRelationVO;
import cool.cade.mall.product.vo.AttrRespVO;
import cool.cade.mall.product.vo.AttrVO;

import java.util.List;
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


    AttrRespVO getAttrInfo(Long attrId);

    void updateAttr(AttrRespVO attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    List<AttrEntity> getRelationAttr(Long attrGroupId);

    void deleteRelation(AttrGroupRelationVO[] vos);

    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrGroupId);
}

