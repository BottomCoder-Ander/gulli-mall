package cool.cade.mall.product.vo;

import lombok.Data;
import sun.plugin.dom.core.Attr;

/**
 * @author Cade
 * @date 2021/11/18 - 21:44
 */
@Data
public class AttrRespVO extends AttrVO {
    /**
     * catelogName: 手机/数码/手机， 所属分类名字
     * groupName: 主体， 所属分组名字
     */

    private String catelogName;
    private String groupName;

    private Long[] catelogPath;
}
