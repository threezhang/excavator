package com.excavator;

import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author by jiuru on 15/4/4.
 */
@Controller
@RequestMapping("/resume")
public class ResumeController {

    private static final String ACCESS_KEY = "MgJbJZM4Wp6I6NucZZgbwBoDVQqRWttbMK_D87Ar";

    private static final String SECRET_KEY = "EUUqwtwxl-UAccFPzxlDMtmjKdLvenpo9kdGBgQF";

    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    private UploadManager uploadManager = new UploadManager();


    // 简单上传，使用默认策略
    private String getUpToken0(){
        return auth.uploadToken("excavator");
    }


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.HEAD})
    public String resume(ModelMap model) {
        return "resume";
    }

    @RequestMapping(value = "/send", method = {RequestMethod.POST, RequestMethod.HEAD})
    public String send(@RequestParam("testfile") CommonsMultipartFile file) {
        try {
            OutputStream os = new FileOutputStream("/etc/tomcat8/temp/"+file.getOriginalFilename());
            InputStream is = file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();
            Response res = uploadManager.put("/etc/tomcat8/temp/"+file.getOriginalFilename(), file.getOriginalFilename(), getUpToken0());
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "resume";
    }

}
