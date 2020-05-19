package com.mrkb.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Service;

import com.mrkb.dao.dao.BonusExtractApplyMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.dao.WithdrawalApplyMapper;
import com.mrkb.dao.modle.apply.BonusExtractApplyEntity;
import com.mrkb.dao.modle.apply.WithdrawalApplyEntity;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.service.ExcelService;

@Service("ExcelServiceImpl")
public class ExcelServiceImpl implements ExcelService {
	
	@Resource
	private BonusExtractApplyMapper bonusExtractApplyMapper;
	@Resource
	private  UserInformationMapper  userInformationMapper;
	@Resource
	private WithdrawalApplyMapper withdrawalApplyMapper;
	@Override
	/**
	 * 
	 * <p>Title: export</p >
	 * <p>Description:制作excel表的过程 及excel导出过程</p >
	 * @param title
	 * @param body1
	 * @param body2
	 * @param body3
	 * @param fos
	 * @see com.medicinefood.service.ExcelService#export(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.io.FileOutputStream)
	 */
	public void export(String title,String[] body1,String body2,String[] body3,int[] idsArray,OutputStream out) {
		/*保留两位小数点*/
		DecimalFormat df = new DecimalFormat(".00"); 
		// TODO Auto-generated method stub
			try{
	             // 第一步，创建一个workbook，对应一个Excel文件
	             HSSFWorkbook workbook = new HSSFWorkbook();
	             // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
	             HSSFSheet hssfSheet = workbook.createSheet(title);
	             // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
	             HSSFRow hssfRow = hssfSheet.createRow(0);
	             // 第四步，创建单元格，并设置值表头 设置表头居中
	             HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
	             //居中样式
	             hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	             // 填充模式   
	            // hssfCellStyle.setFillPattern(HSSFCellStyle.ALIGN_CENTER);  
	            // 表头标题样式
	             HSSFFont headfont = workbook.createFont();//创建样式
	             headfont.setFontName("黑体");//字体类型
	             headfont.setFontHeightInPoints((short) 18);// 字体大小
	             headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
	             HSSFCellStyle headstyle = workbook.createCellStyle();
	             headstyle.setFont(headfont);
	             headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
	             headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
	             headstyle.setLocked(true);   
	            
	             // 列名样式
	             HSSFFont font = workbook.createFont();//创建样式
	             font.setFontName("宋体");//字体类型
	             font.setFontHeightInPoints((short) 16);// 字体大小
	             HSSFCellStyle style = workbook.createCellStyle();
	             style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	             style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	             style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	             style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	             style.setFont(font);
	             style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
	             style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
	             style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//设置前景填充样式
	             style.setFillForegroundColor(HSSFColor.TURQUOISE.index);//前景填充色
	             style.setLocked(true);
	             // 普通单元格样式（中文）
	             HSSFFont font2 = workbook.createFont();//创建样式
	             font2.setFontName("宋体");//字体类型
	             font2.setFontHeightInPoints((short) 12);// 字体大小
	             HSSFCellStyle style2 = workbook.createCellStyle();
	             style2.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	             style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	             style2.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	             style2.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	             style2.setFont(font2);
	             style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
	             style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
	             style2.setWrapText(true); // 换行
	             // 特殊单元格样式1（中文）
	             HSSFFont font3 = workbook.createFont();//创建样式
	             font3.setFontName("宋体");//字体类型
	             font3.setFontHeightInPoints((short) 12);// 字体大小
	             HSSFCellStyle style3 = workbook.createCellStyle();
	             style3.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	             style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	             style3.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	             style3.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	             style3.setFont(font3);
	             style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 左右居右
	             style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);// 上下靠下
	             style3.setWrapText(true); // 换行
	             
	          // 特殊单元格样式2（中文）
	             HSSFFont font4 = workbook.createFont();
	             font4.setFontName("黑体"); 
	             font4.setFontHeightInPoints((short) 12);
	             headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
	             HSSFCellStyle style4 = workbook.createCellStyle();
	             style4.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	             style4.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	             style4.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	             style4.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	             style4.setFont(font4);
	             style4.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左右居左
	             style4.setVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);// 上下靠下
	             style4.setWrapText(true); // 换行
	             
	             // 设置列宽  （第几列，宽度）
	             hssfSheet.setColumnWidth( 0, 2500);
	             hssfSheet.setColumnWidth( 1, 4000);  
	             hssfSheet.setColumnWidth( 2, 6500);
	             hssfSheet.setColumnWidth( 3, 6500); 
	             hssfSheet.setColumnWidth( 4, 8500);  
	             hssfSheet.setColumnWidth( 5, 8000);
	             // 第一行表头标题
	             hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, body1.length-1));
	            //  HSSFRow row = hssfSheet.createRow(0);
	             hssfRow.setHeight((short) 0x349);
	             HSSFCell cell = hssfRow.createCell(0);
	             cell.setCellStyle(headstyle);
	             cell.setCellValue(title);
	          // 第二行列名
	             hssfRow = hssfSheet.createRow(1);
	             for (int i = 0; i < body1.length; i++) {
	            	 HSSFCell cell2 = hssfRow.createCell(i);
	            	 hssfRow.setHeight((short)400);
	            	 cell2.setCellValue(body1[i]);
	            	 cell2.setCellStyle(style);
	             }
	             // 第五步，写入实体数据 
	             List<BonusExtractApplyEntity> beApplyEntities =  bonusExtractApplyMapper.findBonusExtractByApplyIds(idsArray);          
	             Integer total_apply_sum = 0;
	             if(beApplyEntities != null && !beApplyEntities.isEmpty()&&beApplyEntities.size()!=0){
	                 for (int i = 0; i < beApplyEntities.size(); i++) {
	                    hssfRow = hssfSheet.createRow(i+2); 
	                     BonusExtractApplyEntity  bEntity  =beApplyEntities.get(i);
	                     // 第六步，创建单元格，并设置值  
	                     /*序号*/
                    	 // hssfRow.createCell(0).setCellValue(i+1);
	                     /*申请人id*/ 
	                     Integer user_basics_id = 0;
	                     String userName = null;
	                     UserInformationEntity userInfo = null;
	                     if(bEntity.getUser_basics_id()!= null){
	                    	 user_basics_id = bEntity.getUser_basics_id();
	                         userInfo = userInformationMapper.selectUserInformationEntityToUserId(user_basics_id);
	                         if(userInfo==null){
	                        	 userName="申请人不存在";
	                         }else{
	                        	 userName =userInfo.getInformation_compellation();
	                         }
	                     }
	                     /*申请金额*/
	                     Integer apply_sum = 0;
	                     if(bEntity.getApply_sum()!= null){
	                    	 apply_sum = bEntity.getApply_sum();
	                     }
	                     /*统计申请提现申请总金额*/
	                     total_apply_sum +=apply_sum;
	                     /*申请时间*/
	                     Long apply_add_date = 0l;
	                    if(bEntity.getApply_add_date()!= 0){
	                    	apply_add_date = bEntity.getApply_add_date();
	                     }
	                     Date date = new Date(apply_add_date);
	                     SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                     /*备注 该列数据为空白数据*/
	                     
	                     /*使用list封装获取的实体对象数据，并设置数据样式*/
	                     List<String> list = new ArrayList<>();
	                       list.add(i+1+"");
	                       list.add(user_basics_id+"");
	                       list.add(userName);
	                       list.add(df.format(apply_sum)+"");
	                       list.add(sd.format(date)+"");
	                       list.add("");
	                       for(int j=0;j<body1.length;j++){
	                    	 HSSFCell cell3 = hssfRow.createCell(j);
	                    	// System.out.println("list的值----"+list.get(j));
	                    	 cell3.setCellValue(list.get(j));
	                    	 if(j==3){
	                    		 cell3.setCellStyle(style3); 
	                    	 }else{
	                    		 cell3.setCellStyle(style2); 
	                    	 }
	                       }
	                 }
	                  /*合计金额*/
		                 hssfRow = hssfSheet.createRow(beApplyEntities.size()+2);
		                 /*设置样式该行样式*/
		                 for(int k=0;k<body1.length;k++){
		                	 HSSFCell cell4 = hssfRow.createCell(k);
		                	 if(k==3){
		                		 cell4.setCellValue(body2+":"+df.format(total_apply_sum));
		                	 }else{
		                		 cell4.setCellValue(""); 
		                	 }
	      	            	 cell4.setCellStyle(style3); 
		                 }
	                 /*绘制body3数据*/ 
	                 hssfRow = hssfSheet.createRow(beApplyEntities.size()+3);
	                 /*设置样式该行样式*/
	                 for(int i=0;i<body3.length;i++){
	                	    if(i==1){
	                	    	for(int j=0;j<body1.length;j++){
	                	    		HSSFCell cell5 = hssfRow.createCell(j);
	                	    		hssfRow.setHeight((short)1000);
	                	    		if(j==0){
	                	    			cell5.setCellValue(body3[i-1]); 	
	                	    		}
	                	    		if(j==3){
	                	    			cell5.setCellValue(body3[i]);
	                	    		}
		                	    	cell5.setCellStyle(style4);
	                	    	}
	                	    }
	                 }
	                 /*对body3合并单元格*/
		            Integer satrtRow0=beApplyEntities.size()+3;
		             Integer endRow0=beApplyEntities.size()+3;
		             Integer startCol0 =0;
		             Integer endCol0 =body1.length-4;
		             hssfSheet.addMergedRegion(new CellRangeAddress(satrtRow0, endRow0,
		            		 startCol0, endCol0));
		             
		             Integer satrtRow1=beApplyEntities.size()+3;
		             Integer endRow1=beApplyEntities.size()+3;
		             Integer startCol1 =body1.length-3;
		             Integer endCol1 =body1.length-1;
		             hssfSheet.addMergedRegion(new CellRangeAddress(satrtRow1, endRow1,
		            		 startCol1, endCol1));
	             }
	             // 第七步，将文件输出到客户端浏览器
	             try {
	                 workbook.write(out);
	                 out.flush();
	                 out.close();
	 
	             } catch (Exception e) {
	                 e.printStackTrace();
	             }
	         }catch(Exception e){
	             e.printStackTrace();
	             //throw new Exception("导出信息失败！");
	        }    
	     }
	@Override
	/**
	 * 
	 * <p>Title: downloadExcel</p >
	 * <p>Description:下载excel方法 </p >
	 * @param fileUrl,response
	 * @return
	 * @see com.medicinefood.service.ExcelService#downloadExcel(java.lang.String)
	 */
	public  void downloadExcel(String fileUrl, HttpServletResponse response)throws Exception{
		
		System.out.println("服务端路径filePath:"+fileUrl); 
		File f = new File(fileUrl); 
		if (!f.exists()) { 
		response.sendError(404, "File not found!"); 
		return; 
		} 
		BufferedInputStream br = new BufferedInputStream(new FileInputStream(f)); 
		byte[] buf = new byte[1024]; 
		int len = 0; 
		response.reset(); 
		response.setContentType("application/x-msdownload"); 
		response.setHeader("Content-Disposition", "attachment; filename=" + f.getName()); 
		OutputStream out = response.getOutputStream(); 
		while ((len = br.read(buf)) > 0) out.write(buf, 0, len); 
		br.close(); 
		out.close();
	}
	/**
	 * 
	 * <p>Title: downloadExcel</p >
	 * <p>Description:提款审核表</p >
	 * @param fileUrl,response
	 * @return
	 * @see com.medicinefood.service.ExcelService#downloadExcel(java.lang.String)
	 */
	@Override
	public void exportRemit(String title, String[] body1, String body2,
			String[] body3, int[] idsArray, OutputStream out) {
		/*保留两位小数点*/
		DecimalFormat df = new DecimalFormat(".00"); 
		// TODO Auto-generated method stub
			try{
	             // 第一步，创建一个workbook，对应一个Excel文件
	             HSSFWorkbook workbook = new HSSFWorkbook();
	             // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
	             HSSFSheet hssfSheet = workbook.createSheet(title);
	             // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
	             HSSFRow hssfRow = hssfSheet.createRow(0);
	             // 第四步，创建单元格，并设置值表头 设置表头居中
	             HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
	             //居中样式
	             hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	             // 填充模式   
	            // hssfCellStyle.setFillPattern(HSSFCellStyle.ALIGN_CENTER);  
	            // 表头标题样式
	             HSSFFont headfont = workbook.createFont();//创建样式
	             headfont.setFontName("黑体");//字体类型
	             headfont.setFontHeightInPoints((short) 18);// 字体大小
	             headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
	             HSSFCellStyle headstyle = workbook.createCellStyle();
	             headstyle.setFont(headfont);
	             headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
	             headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
	             headstyle.setLocked(true);   
	            
	             // 列名样式
	             HSSFFont font = workbook.createFont();//创建样式
	             font.setFontName("宋体");//字体类型
	             font.setFontHeightInPoints((short) 16);// 字体大小
	             HSSFCellStyle style = workbook.createCellStyle();
	             style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	             style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	             style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	             style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	             style.setFont(font);
	             style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
	             style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
	             style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//设置前景填充样式
	             style.setFillForegroundColor(HSSFColor.TURQUOISE.index);//前景填充色
	             style.setLocked(true);
	             // 普通单元格样式（中文）
	             HSSFFont font2 = workbook.createFont();//创建样式
	             font2.setFontName("宋体");//字体类型
	             font2.setFontHeightInPoints((short) 12);// 字体大小
	             HSSFCellStyle style2 = workbook.createCellStyle();
	             style2.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	             style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	             style2.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	             style2.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	             style2.setFont(font2);
	             style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
	             style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
	             style2.setWrapText(true); // 换行
	             // 特殊单元格样式1（中文）
	             HSSFFont font3 = workbook.createFont();//创建样式
	             font3.setFontName("宋体");//字体类型
	             font3.setFontHeightInPoints((short) 12);// 字体大小
	             HSSFCellStyle style3 = workbook.createCellStyle();
	             style3.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	             style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	             style3.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	             style3.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	             style3.setFont(font3);
	             style3.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 左右居右
	             style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);// 上下靠下
	             style3.setWrapText(true); // 换行
	             
	          // 特殊单元格样式2（中文）
	             HSSFFont font4 = workbook.createFont();
	             font4.setFontName("黑体"); 
	             font4.setFontHeightInPoints((short) 12);
	             headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
	             HSSFCellStyle style4 = workbook.createCellStyle();
	             style4.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	             style4.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	             style4.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	             style4.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	             style4.setFont(font4);
	             style4.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 左右居左
	             style4.setVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);// 上下靠下
	             style4.setWrapText(true); // 换行
	             
	             // 设置列宽  （第几列，宽度）
	             hssfSheet.setColumnWidth( 0, 2500);
	             hssfSheet.setColumnWidth( 1, 4000);  
	             hssfSheet.setColumnWidth( 2, 6500);
	             hssfSheet.setColumnWidth( 3, 6500); 
	             hssfSheet.setColumnWidth( 4, 8500);  
	             hssfSheet.setColumnWidth( 5, 8000);
	             // 第一行表头标题
	             hssfSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, body1.length-1));
	            //  HSSFRow row = hssfSheet.createRow(0);
	             hssfRow.setHeight((short) 0x349);
	             HSSFCell cell = hssfRow.createCell(0);
	             cell.setCellStyle(headstyle);
	             cell.setCellValue(title);
	          // 第二行列名
	             hssfRow = hssfSheet.createRow(1);
	             for (int i = 0; i < body1.length; i++) {
	            	 HSSFCell cell2 = hssfRow.createCell(i);
	            	 hssfRow.setHeight((short)400);
	            	 cell2.setCellValue(body1[i]);
	            	 cell2.setCellStyle(style);
	             }
	             // 第五步，写入实体数据 
	             List<WithdrawalApplyEntity> withdrawalApplyEntities =  withdrawalApplyMapper.findWithdrawalApplyToApplyIds(idsArray);          
	             Double total_apply_sum = 0.00;
	             if(withdrawalApplyEntities != null && !withdrawalApplyEntities.isEmpty()&&withdrawalApplyEntities.size()!=0){
	                 for (int i = 0; i < withdrawalApplyEntities.size(); i++) {
	                    hssfRow = hssfSheet.createRow(i+2); 
	                    WithdrawalApplyEntity  withdrawalApplyEntity  =withdrawalApplyEntities.get(i);
	                     // 第六步，创建单元格，并设置值  
	                     /*序号*/
                    	 // hssfRow.createCell(0).setCellValue(i+1);
	                     /*申请人id*/ 
	                     Integer user_basics_id = 0;
	                     String userName = null;
	                     UserInformationEntity userInfo = null;
	                     if(withdrawalApplyEntity.getUser_basics_id()!= null){
	                    	 user_basics_id = withdrawalApplyEntity.getUser_basics_id();
	                         userInfo = userInformationMapper.selectUserInformationEntityToUserId(user_basics_id);
	                         if(userInfo==null){
	                        	 userName="申请人不存在";
	                         }else{
	                        	 userName =userInfo.getInformation_compellation();
	                         }
	                     }
	                     /*申请金额*/
	                     Double apply_sum = 0.00;
	                     if(withdrawalApplyEntity.getApply_value()!= null){
	                    	 apply_sum = withdrawalApplyEntity.getApply_value();
	                     }
	                     /*统计申请提现申请总金额*/
	                     total_apply_sum +=apply_sum;
	                     /*申请时间*/
	                     Long apply_add_date = 0l;
	                    if(withdrawalApplyEntity.getApply_add_date()!= 0){
	                    	apply_add_date = withdrawalApplyEntity.getApply_add_date();
	                     }
	                     Date date = new Date(apply_add_date);
	                     SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                     /*备注 该列数据为空白数据*/
	                     
	                     /*使用list封装获取的实体对象数据，并设置数据样式*/
	                     List<String> list = new ArrayList<>();
	                       list.add(i+1+"");
	                       list.add(user_basics_id+"");
	                       list.add(userName);
	                       list.add(df.format(apply_sum)+"");
	                       list.add(sd.format(date)+"");
	                       list.add("");
	                       for(int j=0;j<body1.length;j++){
	                    	 HSSFCell cell3 = hssfRow.createCell(j);
	                    	// System.out.println("list的值----"+list.get(j));
	                    	 cell3.setCellValue(list.get(j));
	                    	 if(j==3){
	                    		 cell3.setCellStyle(style3); 
	                    	 }else{
	                    		 cell3.setCellStyle(style2); 
	                    	 }
	                       }
	                 }
	                  /*合计金额*/
		                 hssfRow = hssfSheet.createRow(withdrawalApplyEntities.size()+2);
		                 /*设置样式该行样式*/
		                 for(int k=0;k<body1.length;k++){
		                	 HSSFCell cell4 = hssfRow.createCell(k);
		                	 if(k==3){
		                		 cell4.setCellValue(body2+":"+df.format(total_apply_sum));
		                	 }else{
		                		 cell4.setCellValue(""); 
		                	 }
	      	            	 cell4.setCellStyle(style3); 
		                 }
	                 /*绘制body3数据*/ 
	                 hssfRow = hssfSheet.createRow(withdrawalApplyEntities.size()+3);
	                 /*设置样式该行样式*/
	                 for(int i=0;i<body3.length;i++){
	                	    if(i==1){
	                	    	for(int j=0;j<body1.length;j++){
	                	    		HSSFCell cell5 = hssfRow.createCell(j);
	                	    		hssfRow.setHeight((short)1000);
	                	    		if(j==0){
	                	    			cell5.setCellValue(body3[i-1]); 	
	                	    		}
	                	    		if(j==3){
	                	    			cell5.setCellValue(body3[i]);
	                	    		}
		                	    	cell5.setCellStyle(style4);
	                	    	}
	                	    }
	                 }
	                 /*对body3合并单元格*/
		            Integer satrtRow0=withdrawalApplyEntities.size()+3;
		             Integer endRow0=withdrawalApplyEntities.size()+3;
		             Integer startCol0 =0;
		             Integer endCol0 =body1.length-4;
		             hssfSheet.addMergedRegion(new CellRangeAddress(satrtRow0, endRow0,
		            		 startCol0, endCol0));
		             
		             Integer satrtRow1=withdrawalApplyEntities.size()+3;
		             Integer endRow1=withdrawalApplyEntities.size()+3;
		             Integer startCol1 =body1.length-3;
		             Integer endCol1 =body1.length-1;
		             hssfSheet.addMergedRegion(new CellRangeAddress(satrtRow1, endRow1,
		            		 startCol1, endCol1));
	             }
	             // 第七步，将文件输出到客户端浏览器
	             try {
	                 workbook.write(out);
	                 out.flush();
	                 out.close();
	 
	             } catch (Exception e) {
	                 e.printStackTrace();
	             }
	         }catch(Exception e){
	             e.printStackTrace();
	             //throw new Exception("导出信息失败！");
	        } 
		
	}
}

