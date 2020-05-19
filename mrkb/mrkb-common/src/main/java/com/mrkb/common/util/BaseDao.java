package com.mrkb.common.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;




/**
 * 数据对象基础操作类
 * @author yong	
 * 
 */
public interface BaseDao<T> extends Serializable {
	
	/**
	 * 获取列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**
	 * 根据主键得到某个对象
	 * @param pk
	 */
	public T get(Object pk);
	
	/**
	 * 根据一组主键（数组），得到多个对象，以列表形式返回
	 * @param pks
	 * @return
	 */
	public List<T> getByIds(String[] pks);
	
	/**
	 * 根据条件查询数据条件
	 * @param q
	 * @return
	 */
	public Long count(T obj);
	
	/**
	 * 根据条件查询数据
	 * @param q
	 * @return
	 */
	public List<T> queryAll(T obj);
	
	/**
	 * 根据条件查询分页数据
	 * @param q
	 * @return
	 */
	public List<T> pageList(T obj);
	/**
	 * 只查询需要的列名的list
	 * 
	 * @param query
	 * @return list key为数据库中带有下划线的key,需要转驼峰结构
	 */
	public  List<Map<String, Object>> queryColumnList(T obj);
	
	/**
	 * 增加对象
	 * @param obj
	 */
	public int insert(T obj);
	
	/**
	 * 增加对象  （只插入！= null 字段）
	 * @param obj
	 * @return
	 */
	public int insertSelective(T obj);

	/**
	 * 修改对象
	 * @param obj
	 */
	public int update(T obj);
	
	/**
	 * 修改对象 (只修改！= null字段)
	 * @param obj
	 */
	public int updateSelective(T obj);

	/**
	 * 根据主键删除对象
	 * @param pk
	 */
	public int delete(T obj);
	
	/**
	 * 逻辑删除  设置delflag字段为1 ，当表包含delflag字段时，调用此方法，隐藏数据
	 * @param entity
	 * @return
	 */
	public int deleteByLogic(T entity);
	/**
	 * 根据列名条件删除对象
	 * @param pk
	 */
	public int deleteByCommonWhere(T obj);
	
	

}
