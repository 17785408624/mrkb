package com.mrkb.web.controller.sys;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mrkb.common.utils.FileUtil;

@Controller
@RequestMapping("/test")
public class test {
	
	//处理文件上传
    @RequestMapping(value="/uploadimg",method=RequestMethod.POST,consumes = "multipart/form-data")
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request,HttpServletResponse response) {
     
        String contentType = file.getContentType();   //图片文件类型
        String fileName = file.getOriginalFilename();  //图片名字

        //文件存放路径
        String filePath = "C:\\file\\";
        
        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
       try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }

       // 返回图片的存放路径
        return filePath;
    }

}
