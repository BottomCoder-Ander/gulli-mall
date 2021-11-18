package cool.cade.mall.product.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
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

}