package cool.cade.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import cool.cade.mall.common.valid.AddGroup;
import cool.cade.mall.common.valid.ListValue;
import cool.cade.mall.common.valid.UpdateStatusGroup;
import cool.cade.mall.common.valid.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 08:31:13
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "修改必须指定品牌id",groups = {UpdateGroup.class})
	@Null(message = "新增不能指定id", groups = {AddGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空")
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotEmpty
	@URL(message = "logo必须是一个合法的链接")
	private String logo;
	/**
	 * 介绍
	 */
	@NotEmpty
	private String  descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@NotEmpty
	@ListValue(vals={0,1}, message = "showStatus必须为0和1",groups = {UpdateStatusGroup.class})
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母")
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotEmpty
	@Min(value = 0, message = "排序必须大于等于0")
	private Integer sort;

}
