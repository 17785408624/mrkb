package com.mrkb.common.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JournalPrint {
	/**
	 * 写入错误日志
	 * @param e
	 * @param s
	 * @return
	 */
	public static int except(Exception e, String s) {
		String ee = String.valueOf(e);
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			String dateStr = sdf.format(date);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(dateStr);
			String dateNowStr = sdf1.format(date);
			String content = "测试使用字符串";
			File file = new File("E:/exception" + dateStr + ".txt");
			if (file.exists()) {
				FileWriter fw = new FileWriter(file, true);
				PrintWriter writer = new PrintWriter(fw);
				writer.append(dateNowStr);
				writer.println();
				writer.append(s);
				writer.println();
				e.printStackTrace(writer);
				writer.println();
				// bw.append(e);
				writer.close();
				fw.close();
				System.out.println("完成写入累加");
			} else {
				file = new File("E:/exception" + dateStr + ".txt");
				FileWriter fw = new FileWriter(file, true);
				PrintWriter writer = new PrintWriter(fw);
				writer.append(dateNowStr);
				writer.println();
				writer.append(s);
				writer.println();
				e.printStackTrace(writer);
				writer.println();
				// bw.append(e);
				writer.close();
				fw.close();
				System.out.println("首次完成写入");
			}

		} catch (Exception e1) {
			// TODO: handle exception
		}
		return 1;
	}
}
