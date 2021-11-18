package cool.cade.mall.common.exception;

/**
 * @author Cade
 * @date 2021/11/18 - 0:15
 */

/**
 * 错误码和错误信息定义，5位表示，前两位表示所处五福，后两位位异常类型
 * 10： 通用
 *      001：参数格式校验
 * 11： 商品
 * 12：订单
 * 13：购物车
 * 14：物流
 */
public enum BizCodeEnume {
    UNKNOW_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "参数校验失败");


    private int code;
    private String msg;
    BizCodeEnume(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){return code;}

    public String getMsg(){return msg;}

}
