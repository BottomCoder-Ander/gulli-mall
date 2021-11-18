package cool.cade.mall.thirdparty;

/**
 * @author Cade
 * @date 2021/11/17 - 14:55
 */

import com.aliyun.oss.OSSClient;
import cool.cade.mall.thisparty.MallThirdPartyApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 */

@SpringBootTest(classes = MallThirdPartyApplication.class)
public class MallOSSTest {
    @Autowired
    private OSSClient ossClient;

    @Test
    public void testOSS() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Cade\\Pictures\\chunk.png");
        ossClient.putObject("mall-cade", "osstest2.png", inputStream);

        System.out.println("上传完成");

    }
}
