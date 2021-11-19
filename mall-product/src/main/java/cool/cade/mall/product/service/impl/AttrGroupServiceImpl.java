package cool.cade.mall.product.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import cool.cade.mall.product.entity.AttrEntity;
import cool.cade.mall.product.service.AttrService;
import cool.cade.mall.product.vo.AttrGroupWithAttrsVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.common.utils.Query;

import cool.cade.mall.product.dao.AttrGroupDao;
import cool.cade.mall.product.entity.AttrGroupEntity;
import cool.cade.mall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    AttrService attrService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        IPage<AttrGroupEntity> page = null;
        if(catelogId == 0) {
            page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
            );
        } else{
            String key = (String) params.get("key");
            QueryWrapper<AttrGroupEntity> attrQueryWrapper
                        = new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId);
            if(!StringUtils.isEmpty(key)) {
                attrQueryWrapper.and((obj)->{
                    obj.eq("attr_group_id", key).or().like("attr_group_name", key);
                });
            }
            page = this.page(new Query<AttrGroupEntity>().getPage(params), attrQueryWrapper);

        }

        return new PageUtils(page);
    }


    /**
     * 根据分类id，查出所有的分组以及这些组里面的属性
     * @param catelogId
     * @return
     */
    @Override
    public List<AttrGroupWithAttrsVO> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
    //    查询分组信息
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));

    //    查询所有属性
        List<AttrGroupWithAttrsVO> collect = attrGroupEntities.stream().map(group -> {
            AttrGroupWithAttrsVO attrGroupWithAttrsVO = new AttrGroupWithAttrsVO();
            BeanUtils.copyProperties(group, attrGroupWithAttrsVO);
            List<AttrEntity> relationAttr = attrService.getRelationAttr(attrGroupWithAttrsVO.getAttrGroupId());
            attrGroupWithAttrsVO.setAttrs(relationAttr);

            return attrGroupWithAttrsVO;
        }).collect(Collectors.toList());

        return collect;
    }

}