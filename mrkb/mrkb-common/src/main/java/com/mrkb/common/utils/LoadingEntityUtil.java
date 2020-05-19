package com.mrkb.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
/**
 * 加载实体工具类
 *@param
 *@return
 * @author Administrator
 *
 */
public class LoadingEntityUtil {
	/**
	 * 
	 * @Title:             fromJson
	 * @Description:     TODO 通过JSONObject中的json数据装载实体类
	 * @param:             @param json net.sf.json.JSONObject对象 装载的值
	 * @param:             @param clas Class对象 需要装载的实体类类型
	 * @param:             @return
	 * @param:             @throws SecurityException
	 * @param:             @throws NoSuchMethodException
	 * @param:             @throws ClassNotFoundException
	 * @param:             @throws IllegalArgumentException
	 * @param:             @throws IllegalAccessException
	 * @param:             @throws InvocationTargetException
	 * @param:             @throws InstantiationException   
	 * @return:         Object 返回的对象  
	 * @throws
	 */
	public static Object fromJson(HttpServletRequest request,Class clas)
			throws SecurityException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class<?> clz=clas;//通过需要装载的对象类型创建一个class对象
		Object objetClz=clz.newInstance();//利用class反射初始化一个需要加载的对象
		Field[] fields = clz.getDeclaredFields();//得到加载对象的所有属性
		for(Field field:fields){//遍历对象的属性
			String fieldName=field.getName();//得到属性的名字
			String name = request.getParameter(fieldName);
			if(name!=null&&!name.equals("")&&!name.equals("0")){//如果json数据中有有已属性为键，并且取到的值不为空
			    Object o=request.getParameter(fieldName);
				String str=String.valueOf(fieldName.charAt(0));//获取名字的第一个字符
				StringBuffer methodNameB=new StringBuffer(fieldName);//将名字字符串转换为StringBuffer对象
				methodNameB.replace(0,1,str.toUpperCase());//将第一个字符替换为大写
				String methodName="set"+methodNameB.toString();//加上set拼出属性的set方法
				Class parameterTypes=field.getType();//获取属性的类型
				Method me=clz.getMethod(methodName, parameterTypes);//通过方法名，方法的参数类型获取到指定的方法
				if(parameterTypes.getName().equals("java.lang.String")){
					String meParam=request.getParameter(field.getName());
					me.invoke(objetClz,meParam );//执行方法；
				}else if(parameterTypes.getName().equals("java.lang.Integer")){
					int meParam=Integer.valueOf(request.getParameter(field.getName()));
					me.invoke(objetClz,meParam );//执行方法；
				}else if(parameterTypes.getName().equals("java.lang.Float")){
					Float meParam= Float.valueOf(request.getParameter(field.getName()));
					me.invoke(objetClz,meParam );//执行方法；
				}else if(parameterTypes.getName().equals("java.lang.Double")){
					Double meParam= Double.valueOf(request.getParameter(field.getName()));
					me.invoke(objetClz,meParam );//执行方法；
				}
			}
		}
		return objetClz;//返回用class反射初始化的对象
	}
	
}
