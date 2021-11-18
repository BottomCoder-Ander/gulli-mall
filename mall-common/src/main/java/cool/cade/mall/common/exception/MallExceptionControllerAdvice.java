package cool.cade.mall.common.exception;

import cool.cade.mall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cade
 * @date 2021/11/18 - 0:05
 */
@Slf4j
@RestControllerAdvice(basePackages = "cool.cade.mall.product.controller")
public class MallExceptionControllerAdvice{

    /**
     * 处理数据校验异常
     * @param e 异常对象
     * @return response 的json字符串
    */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handlerValidException(MethodArgumentNotValidException e){
        log.error("数据校验出现了问题{}, 异常类型: {}", e.getMessage(), e.getClass());

        Map<String, String> errMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((item)->{
            String message = item.getDefaultMessage();
            String field = item.getField();
            errMap.put(field, message);
        });
        return R.error(BizCodeEnume.VALID_EXCEPTION).put("data", errMap);

    }

    public R handleException(){
        log.error("unknown exception");
        return R.error();
    }


}
