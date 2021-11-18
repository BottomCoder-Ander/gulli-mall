package cool.cade.mall.product.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.common.utils.Query;

import cool.cade.mall.product.dao.CategoryDao;
import cool.cade.mall.product.entity.CategoryEntity;
import cool.cade.mall.product.service.CategoryService;

@Slf4j
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1.查出所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        if(categoryEntities == null) {
            log.warn("categoryEntities is null");
            return null;
        }

        // 先转成一个map
        Map<Long, CategoryEntity> catId2CatEntityMap = categoryEntities
                            .stream()
                            .collect(Collectors.toMap(CategoryEntity::getCatId, cat -> cat));

        // 2.将数据组装成树形结构
        // 可以用流操作，但是没必要
        for (CategoryEntity cat: categoryEntities) {
            if(cat.getParentCid().intValue() != 0) {
                CategoryEntity parentCategory = catId2CatEntityMap.get(cat.getParentCid());
                // 父类已经删除了
                if(parentCategory == null) continue;
                if(parentCategory.getChildren() == null)
                    parentCategory.setChildren(new ArrayList<>());
                parentCategory.getChildren().add(cat);
            }
        }

        // 只保留一级菜单
        categoryEntities = categoryEntities.stream()
                            .filter(cat-> cat.getParentCid() == 0)
                            .collect(Collectors.toList());

        try {
            // 排序
            for (CategoryEntity cat: categoryEntities) {
                if (cat.getChildren() != null) {
                    cat.getChildren().sort(Comparator.comparing(CategoryEntity::getSort));
                }
            }
            categoryEntities.sort(Comparator.comparing(CategoryEntity::getSort));
        }catch (NullPointerException e){
            log.error("category.sort == NULL");
            for (CategoryEntity cat: categoryEntities) {
                if(cat.getSort() == null) {
                    log.info(cat.toString());
                }
            }
            categoryEntities = null;
        }

        return categoryEntities;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO: 检查后再删除，检查当前删除在其他地方是否被使用

        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCatelogPathById(Long catelogId) {
        ArrayList<Long> paths = new ArrayList<Long>();
        findParentPath(catelogId, paths);
        return (Long[]) paths.toArray();
    }

    private void findParentPath(Long catelogId, List<Long> paths){
        CategoryEntity byId = this.getById(catelogId);
        if(byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(), paths);
        }
        paths.add(catelogId);
    }

}