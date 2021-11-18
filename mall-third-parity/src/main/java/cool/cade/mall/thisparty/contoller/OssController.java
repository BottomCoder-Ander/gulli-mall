package cool.cade.mall.thisparty.contoller;
/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.common.utils.IOUtils;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PolicyConditions;
import cool.cade.mall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * OSS Controller.
 *
 * @author <a href="mailto:fangjian0423@gmail.com">Jim</a>
 */
@Slf4j
@RestController
@RequestMapping("thirdparty/oss")
public class OssController {

    @Autowired
    private OSS ossClient;

    @Value("${alibaba.cloud.access-key}")
    private String accesskey;

    @Value("${alibaba.cloud.oss.bucket}")
    private String bucket;

    @Value("${alibaba.cloud.oss.endpoint}")
    private String endpoint;

    @GetMapping("/policy")
    public R policy(){
        String host = "https://" + bucket + "." + endpoint;

        Map<String, String> resMap = new LinkedHashMap<String, String>();
        String dirName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        long expireTime = 30;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
//        最大1M
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1024 * 1024);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dirName);

        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = null;
        binaryData = postPolicy.getBytes(StandardCharsets.UTF_8);
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);

        resMap.put("accessid", accesskey);
        resMap.put("policy", encodedPolicy);
        resMap.put("signature", postSignature);
        resMap.put("dir", dirName);
        resMap.put("host", host);
        resMap.put("expire", String.valueOf(expireEndTime / 1000));
        log.info("get policy sucess");
        log.info(resMap.toString());
        return R.ok().put("data",resMap);
    }


//    @GetMapping("/upload")
//    public String upload() {
//
//
//
//
//        try {
////            ossClient.putObject(OssApplication.BUCKET_NAME, "oss-test.json", this
////                .getClass().getClassLoader().getResourceAsStream("oss-test.json"));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return "oss upload fail: " + e.getMessage();
//        }
//        return "oss upload success";
//    }
//
//    @GetMapping("/file-resource")
//    public String fileResource() {
//        try {
//            return "get file resource success. content: " + StreamUtils.copyToString(
//                remoteFile.getInputStream(), Charset.forName(CharEncoding.UTF_8));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return "get resource fail: " + e.getMessage();
//        }
//    }
//
//    @GetMapping("/download")
//    public String download() {
//        try {
//            OSSObject ossObject = ossClient.getObject(OssApplication.BUCKET_NAME,
//                "oss-test.json");
//            return "download success, content: " + IOUtils
//                .readStreamAsString(ossObject.getObjectContent(), CharEncoding.UTF_8);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return "download fail: " + e.getMessage();
//        }
//    }
//
//    @GetMapping("/upload2")
//    public String uploadWithOutputStream() {
//        try {
//            try (OutputStream outputStream = ((WritableResource) this.remoteFile)
//                .getOutputStream();
//                 InputStream inputStream = localFile.getInputStream()) {
//                StreamUtils.copy(inputStream, outputStream);
//            }
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//            return "upload with outputStream failed";
//        }
//        return "upload success";
//    }

}