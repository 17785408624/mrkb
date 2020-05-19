package com.mrkb.web.controller.sys;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.common.utils.FileUtil;

@Controller
@RequestMapping("/upload")
/**
 * 文件上传 controller
 * 
 * @author liangyi
 *
 */
public class FileUploadController {
	/**
	 * 上传视频图片
	 * 
	 * @param file
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value="/uploadViews" , method=RequestMethod.POST,consumes = "multipart/form-data")
	@ResponseBody
	public ResponseData uploadViews(MultipartFile file, HttpServletRequest request) throws Exception {
		//System.out.println("寰楀埌鐨刟reaName:" + areaName);
		ResponseData  r  = new ResponseData();
		String date = String.valueOf(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date(Long.valueOf(date));
		String datePath = simpleDateFormat.format(date1).replace("-", "");
		
		// 璁剧疆涓婁紶鐨勮矾寰勬槸D鐩樹笅鐨刾icture
		String imgPath = "C:/file/views/"+datePath+"/" ;//鍥剧墖缁濆璺緞
		String realtivePath = "/views/"+datePath+"/" ;//鍥剧墖鐩稿璺緞
		Object pictureSavePath = null;
		String imgName ="";
		//request.getSession().getServletContext().getRealPath("C:/img");
		//System.out.println("鍥剧墖璺緞"+file.toString());
//		for (MultipartFile f : file) {
			// 鍥剧墖鐨勫悕瀛楃敤姣鏁�+鍥剧墖鍘熸潵鐨勫悕瀛楁嫾鎺�
			//System.out.println(f.getSize());
			//System.out.println(f.getBytes());
			imgName = System.currentTimeMillis() + "";
			
			// 涓婁紶鏂囦欢
			 //uploadFileUtil(f.getBytes(), imgPath, imgName);
			 FileUtil.uploadFile(file.getBytes(), imgPath, imgName);
			 pictureSavePath = realtivePath+imgName;
//		}
		  /*HashMap<String, Object>  map  =new HashMap<String, Object>();
		  map.put("path", pictureSavePath);
		  map.put("imgName",imgName);*/
		 r.setData(pictureSavePath);
		 r.setMessage(ResponseCode.SUCC_DO.getMsg());
		 return r;
	}
}
