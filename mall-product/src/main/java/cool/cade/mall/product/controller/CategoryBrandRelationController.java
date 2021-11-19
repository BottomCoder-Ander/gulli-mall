package cool.cade.mall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cool.cade.mall.product.entity.BrandEntity;
import cool.cade.mall.product.vo.BrandVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cool.cade.mall.product.entity.CategoryBrandRelationEntity;
import cool.cade.mall.product.service.CategoryBrandRelationService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.common.utils.R;



/**
 * 品牌分类关联
 *
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 08:31:12
 */
@RestController
@RequestMapping("product/categorybrandrelation")
public class CategoryBrandRelationController {
    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBrandRelationService.queryPage(params);

        return R.ok().put("page", page);
    }

    @GetMapping("/brands/list")
    public R relationBrandLis(@RequestParam(value = "catId", required = true) Long catId){
        List<BrandEntity> entities = categoryBrandRelationService.getBrandsByCatId(catId);

        List<BrandVO> vos = entities.stream().map(item -> {
            BrandVO brandVO = new BrandVO();
            brandVO.setBrandId(item.getBrandId());
            brandVO.setBrandName(item.getName());
            return brandVO;
        }).collect(Collectors.toList());
        return R.ok().put("data", vos);
    }

    /**
     * 列表
     */
//    @RequestMapping(value = "/catelog/list", method = RequestMethod.GET)
    @GetMapping("/catelog/list")
    //@RequiresPermissions("product:categorybrandrelation:list")
    public R catelogList(@RequestParam("brandId") Long brandId){

        List<CategoryBrandRelationEntity> data = categoryBrandRelationService.list(new QueryWrapper<CategoryBrandRelationEntity>()
            .eq("brand_id", brandId));

        return R.ok().put("data", data);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("product:categorybrandrelation:info")
    public R info(@PathVariable("id") Long id){
		CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

        return R.ok().put("categoryBrandRelation", categoryBrandRelation);
    }

    /**
     * 保存关联信息，品牌和类别关联，先要查出类别名字和品牌名字，然后保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:categorybrandrelation:save")
    public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.saveDetail(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:categorybrandrelation:update")
    public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation){
		categoryBrandRelationService.updateById(categoryBrandRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:categorybrandrelation:delete")
    public R delete(@RequestBody Long[] ids){
		categoryBrandRelationService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
