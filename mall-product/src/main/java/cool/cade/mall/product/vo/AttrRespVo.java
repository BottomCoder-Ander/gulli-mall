package cool.cade.mall.product.vo;

import lombok.Data;

/**
 * @author Cade
 * @date 2021/11/18 - 21:44
 */
@Data
public class AttrRespVo {
    /**
     * catelogName: 手机/数码/手机， 所属分类名字
     * groupName: 主体， 所属分组名字
     */

    private String catelogName;
    private String groupName;
}
