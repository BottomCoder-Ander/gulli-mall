package cool.cade.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cool.cade.mall.common.utils.PageUtils;
import cool.cade.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author cade
 * @email cade@cade.cool
 * @date 2021-11-14 00:53:40
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

