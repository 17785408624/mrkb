package com.mrkb.web.controller.sys;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.common.utils.FileUtil;
import com.mrkb.common.utils.globalStatic.GlobalStatic;

@Controller
@RequestMapping("/layuiupload")
/**
 * 文件上传 controller
 * 
 * @author liangyi
 *
 */
public class LayuiUploadController {
	/**
	 * 上传商品图片
	 * 
	 * @param file
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadStoreImg", method = RequestMethod.POST, consumes = "multipart/form-data")
	@ResponseBody
	public Map<String, Object> uploadImg(@Param("file") MultipartFile file, HttpServletRequest request)
			throws Exception {
		String date = String.valueOf(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date(Long.valueOf(date));
		String datePath = simpleDateFormat.format(date1).replace("-", "");

		// 设置上传的路径是C盘下的picture
		String imgPath = GlobalStatic.imgUrlSet+"store\\" + datePath + "\\";// 图片绝对路径
		// String realtivePath =
		// "http://localhost:8088/file/store/"+datePath+"/" ;//图片相对路径

		String realtivePath = "file/store/" + datePath + "/";// 图片相对路径
		String imgName = "";
		MultipartFile f = file;
		System.out.println(f.getBytes());
		// for (MultipartFile f : upfile) {
		// // 图片的名字用毫秒数+图片原来的名字拼接
		// //System.out.println(f.getSize());
		// //System.out.println(f.getBytes());
		imgName = System.currentTimeMillis() + f.getOriginalFilename();
		// System.out.println("imagName获取值"+imgName);
		//
		// // 上传文件
		// uploadFileUtil(f.getBytes(), imgPath, imgName);
		FileUtil.uploadFile(f.getBytes(), imgPath, imgName);
		// pictureSavePath = realtivePath+imgName;
		// }
		String realtivePath1 = GlobalStatic.imgUrlGet+"/store/" + datePath + "/" + imgName;// 图片相对路径
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map.put("code", 0);// 0表示成功，1失败
		map.put("msg", "上传成功");// 提示消息
		map.put("data", map2);
		map2.put("src", realtivePath1);// 图片url
		map2.put("url","/store/" + datePath + "/" + imgName );
		map2.put("title", imgName);// 图片名称，这个会显示在输入框里
		// String result = new JSONObject(map).toString();
		return map;
	}
	/**
	 * 上传news图片
	 * 
	 * @param file
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadNewsImg", method = RequestMethod.POST, consumes = "multipart/form-data")
	@ResponseBody
	public Map<String, Object> uploadNewsImg(@Param("file") MultipartFile file, HttpServletRequest request)
			throws Exception {
		String date = String.valueOf(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date(Long.valueOf(date));
		String datePath = simpleDateFormat.format(date1).replace("-", "");

		// 设置上传的路径是C盘下的picture
		String imgPath = GlobalStatic.imgUrlSet+"news\\" + datePath + "\\";// 图片绝对路径
		// String realtivePath =
		// "http://localhost:8088/file/store/"+datePath+"/" ;//图片相对路径

		String realtivePath = "file/news/" + datePath + "/";// 图片相对路径
		String imgName = "";
		MultipartFile f = file;
		System.out.println(f.getBytes());
		// for (MultipartFile f : upfile) {
		// // 图片的名字用毫秒数+图片原来的名字拼接
		// //System.out.println(f.getSize());
		// //System.out.println(f.getBytes());
		imgName = System.currentTimeMillis() + f.getOriginalFilename();
		// System.out.println("imagName获取值"+imgName);
		//
		// // 上传文件
		// uploadFileUtil(f.getBytes(), imgPath, imgName);
		FileUtil.uploadFile(f.getBytes(), imgPath, imgName);
		// pictureSavePath = realtivePath+imgName;
		// }
		String realtivePath1 = GlobalStatic.imgUrlGet+"/news/" + datePath + "/" + imgName;// 图片相对路径
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map.put("code", 0);// 0表示成功，1失败
		map.put("msg", "上传成功");// 提示消息
		map.put("data", map2);
		map2.put("src", realtivePath1);// 图片url
		map2.put("title", imgName);// 图片名称，这个会显示在输入框里
		// String result = new JSONObject(map).toString();
		return map;
	}
	/**
	 * 上传视频
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
			imgName = System.currentTimeMillis() + file.getOriginalFilename();
			
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
