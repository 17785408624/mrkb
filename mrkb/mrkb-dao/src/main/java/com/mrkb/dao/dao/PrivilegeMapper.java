/**
 * FileName:         PrivilegeMapper.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-3-9     下午7:28:27
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-3-9     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.privilege.PrivilegeAdministrativeEntity;
import com.mrkb.dao.modle.privilege.PrivilegeAdministrativeGatherEntity;
import com.mrkb.dao.modle.privilege.PrivilegeAdministrativeUserEntity;
import com.mrkb.dao.modle.privilege.PrivilegeEntity;
import com.mrkb.dao.modle.privilege.PrivilegeGatherEntity;
import com.mrkb.dao.modle.privilege.PrivilegeGatherPrivilegeEntity;


/**
 * @param
 * @return
 * @author moerka-1
 * 
 */
@Mapper
public interface PrivilegeMapper {
	/**
	 * 
	 * @Title: batchInsertPrivilege
	 * @Description: 批量添加权限数据 TODO
	 * @param: @param privilegeEntityList 权限实体类集合
	 * @param: @return
	 * @return: int
	 * @throws
	 */
	int batchInsertPrivilege(
			@Param("privilegeEntityList") List<PrivilegeEntity> privilegeEntityList);// 批量添加权限数据
	int batchDeletePrivilege(
			@Param("privilegeEntityList")List<PrivilegeEntity> privilegeEntityList);//批量删除权限表的数据
	int batchDeletePrivilegeGP(
			@Param("privilegeEntityList")List<PrivilegeEntity> privilegeEntityList);//批量删除权限组权限表的数据
	int batchDeleteUserPrivilege(
			@Param("privilegeEntityList")List<PrivilegeEntity> privilegeEntityList,
			@Param("tableName")String tableName);//批量删除权限组权限表的数据
	/**
	 * 
	 * @Title:             selectAllPrivilege
	 * @Description:     TODO 根据权限cod查询权限
	 * @param:             @param privilege_code_num 不同终端的控制层，以数字code区分code 1后台管理 2pc 3微信端  4app端
	 * @param:             @return   PrivilegeEntity实体类
	 * @return:         List<PrivilegeEntity>   
	 * @throws
	 */
	List<PrivilegeEntity> selectAllPrivilegePrivilege_code_num(int privilege_code_num);//根据权限cod查询所有控制层数据
	/**
	 * 
	 * @Title:             SelectAllPrivilege
	 * @Description:     TODO 查询所有权限 包含所有终端控制层数据
	 * @param:             @return   
	 * @return:         List<PrivilegeEntity>   
	 * @throws
	 */
	List<PrivilegeEntity> selectAllPrivilege();//查询所有控制层权限
	int emptyPrivilege();//清空Privilege 权限表数据 
	int emptyPrivilegeGatherPrivilege();//清空PrivilegeGathPrivilege 权限集权限表数据
	int emptyPrivilegeGather();//清空PrivilegeGather 权限集表数据
	int emptyPrivilegeAdministrative();//清空PrivilegeAdministrative 权限管理组表数据
	int emptyPrivilegeAdministrativeGather();//清空PrivilegeAdministrativeGather 管理组权限集表数据
	int emptyPrivilegeAdministrativeUser();//清空emptyPrivilegeAdministrativeUser 管理组用户表数据
	int emptyUserPrivilege();//清空userPrivilege 清空用户权限表数据
	/**
	 * 
	 * @Title:             updatePrivilegeToPrivilegeId
	 * @Description:     TODO 根据权限的id修改是否需要权限认证字段的状态
	 * @param:             @param privilegeId 权限id
	 * @param:             @param privilege_verify 修改的字段-是否需要进行检验权限（1为需要进行访问权限认证）
	 * @param:             @return   
	 * @return:         int   修改的记录
	 * @throws
	 */
	int updatePrivilegeVerifyToPrivilegeId(@Param("privilegeIds")int[]privilegeIds,@Param("privilege_verify")int privilege_verify);
	/**
	 * 
	 * @Title:             updatePrivilegeToPrivilegeId
	 * @Description:     TODO 根据权限的id修改是否需要权限认证字段的状态
	 * @param:             @param privilegeId 权限id
	 * @param:             @param privilege_verify 修改的字段-是否需要进行检验权限（1为需要进行访问权限认证）
	 * @param:             @return   
	 * @return:         int   修改的记录
	 * @throws
	 */
	int updateOperationLog(@Param("is_operation_logs")int[]is_operation_logs,@Param("operation_type")int operation_type,@Param("is_operation_log")int is_operation_log);
	/**
	 * 
	 * @Title:             selectPrivilegesToPrivilegeId
	 * @Description:     TODO  通过privilegeIds查询一个或多个PrivilegeEntity实体类信息
	 * @param:             @param privilegeIds 权限id数组
	 * @param:             @return   
	 * @return:         List<PrivilegeEntity>  单个权限的集合 
	 * @throws
	 */
	List<PrivilegeEntity> selectPrivilegesToPrivilegeIds(@Param("privilegeIds")int[] privilegeIds);//通过privilegeIds查询PrivilegeEntity实体类信息
    /**
     * 
     * @Title:             insertPrivilegeGather
     * @Description:     TODO 添加一条权限集数据
     * @param:             @param privilegeGatherEntity 权限集实体类
     * @param:             @return   
     * @return:         int   
     * @throws
     */
	int insertPrivilegeGather(PrivilegeGatherEntity privilegeGatherEntity);//添加一条权限集数据
	/**
	 * 
	 * @Title:             insertBatchPrivilegeGatherPrivilege
	 * @Description:     TODO 批量添加权限集权限
	 * @param:             @param privilegeGatherPrivilegeEntityList 权限集权限实体类集合
	 * @param:             @return   
	 * @return:         int   添加的条数
	 * @throws
	 */
	int insertBatchPrivilegeGatherPrivilege(
			@Param("privilegeGatherPrivilegeEntityList")List<PrivilegeGatherPrivilegeEntity> 
			privilegeGatherPrivilegeEntityList);//批量添加权限集权限
	/**
	 * 
	 * @Title:             selectPrivilegeGatherToPrivilegeGatherType
	 * @Description:     TODO 根据类型查询权限集
	 * @param:             @param privilege_gather_type 权限集类型   1后台管理权限 2pc权限 3微信端权限 4app端权限
	 * @param:             @return   
	 * @return:         List<PrivilegeGatherEntity>   
	 * @throws
	 */
	List<PrivilegeGatherEntity> selectPrivilegeGatherToPrivilegeGatherType(
			@Param("privilegeGatherTypes")int[] privilegeGatherTypes);//根据类型查询权限集
	/**
	 * 
	 * @Title:             selectPrivilegeGather
	 * @Description:     TODO 根据权限集id查询单个权限集实体
	 * @param:             @param privilege_gather_id 权限集id
	 * @param:             @return   
	 * @return:         PrivilegeGatherEntity 权限集实体类  
	 * @throws
	 */
	PrivilegeGatherEntity selectPrivilegeGather(int privilege_gather_id);//根据权限集id查询单个权限集实体
	/**
	 * 
	 * @Title:             selectPrivilegesToPrivilegeGatherId
	 * @Description:     TODO 根据权限集id查询包含的权限
	 * @param:             @param privilege_gather_id
	 * @param:             @return   
	 * @return:         List<PrivilegeEntity> 权限实体集合
	 * @throws
	 */
	List<PrivilegeEntity>selectPrivilegesToPrivilegeGatherId(int privilege_gather_id);//根据权限集id查询包含的权限
	/**
	 * 
	 * @Title:             selectPrivilegeGatherToPGId
	 * @Description:     TODO 根据一个或多个权限集id查询权限集
	 * @param:             @param privilege_gather_ids 权限集id数组，一个或多个权限集id
	 * @param:             @return   
	 * @return:         List<PrivilegeGatherEntity> 权限集实体类集合  
	 * @throws
	 */
	List<PrivilegeGatherEntity> selectPrivilegeGatherToPGId(
			@Param("privilege_gather_ids")int[] privilege_gather_ids);//根据一个或多个权限集id查询权限集
	/**
	 * 
	 * @Title:             insertPrivilegeAdministrative
	 * @Description:     TODO 向管理组表插入数据
	 * @param:             @param privilegeAdministrativeEntity 管理组实体类
	 * @param:             @return   
	 * @return:         int  插入返回结果 插入条数
	 * @throws
	 */
	int insertPrivilegeAdministrative(PrivilegeAdministrativeEntity privilegeAdministrativeEntity);//向管理组表插入数据
	/**
	 * 
	 * @Title:             insertPrivilegeAdministrativeGatherBatch
	 * @Description:     TODO 批量向管理组权限表插入数据
	 * @param:             @param privilegeAdministrativeGatherList
	 * @param:             @return   
	 * @return:         int   插入的条数
	 * @throws
	 */
	int insertPrivilegeAdministrativeGatherBatch(
			@Param("privilegeAdministrativeGatherList")List<PrivilegeAdministrativeGatherEntity>
			privilegeAdministrativeGatherList);//批量向管理组权限表插入数据
	/**
	 * 
	 * @Title:             selectAllPrivilegeAdministrative
	 * @Description:     TODO 查询所有管理组
	 * @param:             @return   
	 * @return:         List<PrivilegeAdministrativeEntity>   管理组实体类集合
	 * @throws
	 */
	List<PrivilegeAdministrativeEntity> selectAllPrivilegeAdministrative();//查询所有管理组
	/**
	 * 
	 * @Title:             selectPrivilegeAdministrative
	 * @Description:     TODO 通过管理组id查询管理组信息
	 * @param:             @param administrative_id
	 * @param:             @return   
	 * @return:         PrivilegeAdministrativeEntity 管理组实体类
	 * @throws
	 */
	PrivilegeAdministrativeEntity selectPrivilegeAdministrativeToPaId(
			int administrative_id);//通过管理组id查询管理组信息
	/**
	 * 
	 * @Title:             selectPrivilegeGatherToPaId
	 * @Description:     TODO 通过管理组id查询权限集信息
	 * @param:             @param administrative_id
	 * @param:             @return   
	 * @return:         List<PrivilegeGatherEntity>   权限集实体类
	 * @throws
	 */
	List<PrivilegeGatherEntity>selectPrivilegeGatherToPaId(int administrative_id);//通过管理组id查询权限集信息
	/**
	 * 
	 * @Title:             selectPrivilegeToPaId
	 * @Description:     TODO  通过管理组id查询权限信息
	 * @param:             @param administrative_id 管理组id
	 * @param:             @return   满足条件的权限信息
	 * @return:         List<PrivilegeEntity>   权限实信息体类集合
	 * @throws
	 */
	List<PrivilegeEntity>selectPrivilegeToPaId(int administrative_id);//通过管理组id查询权限信息
	int insertBatchPrivilegeAdministrativeUsers(int adminstrative_id,int[]user_basics_id);//批量添加管理组用户
	/**
	 * 
	 * @Title:             insertPrivilegeAdministrativeUser
	 * @Description:     TODO 添加管理组用户信息
	 * @param:             @param privilegeAdministrativeUserEntity
	 * @param:             @return   添加结果
	 * @return:         int   返回1为添加成功
	 * @throws
	 */
	int insertPrivilegeAdministrativeUser(
			PrivilegeAdministrativeUserEntity privilegeAdministrativeUserEntity);//添加管理组用户信息
	/**
	 * 
	 * @Title:             deletePrivilegeAdministrativeUser
	 * @Description:     TODO 根据实体类中用户id与管理组id为条件删除一条管理组用户信息数据
	 * @param:             @param privilegeAdministrativeUserEntity 管理组用户信息实体类，包含管理组id与用户id
	 * @param:             @return   删除结果
	 * @return:         int   为1表示删除成功
	 * @throws
	 */
	int deletePrivilegeAdministrativeUser(
			PrivilegeAdministrativeUserEntity privilegeAdministrativeUserEntity);//根据实体类中用户id与管理组id为条件删除一条管理组用户信息数据
	/**
	 * 
	 * @Title:             insertUserPrivilegeAdminBatchToPidUids
	 * @Description:     TODO 添加用户的后台管理权限
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param privilege_ids 权限id数组 
	 * @param:             @param tableName 表名
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int insertUserPrivilegeAdminBatchToPidUids(@Param("tableName")String tableName,
			@Param("user_basics_id")int user_basics_id,@Param("privilege_ids")int[]privilege_ids);//添加用户的后台管理权限
	/**
	 * 
	 * @Title:             deleteUserPrivilegeAdminToPidUids
	 * @Description:     TODO 删除用户的后台管理权限
	 * @param:             @param tableName 表名
	 * @param:             @param user_basics_id  用户id
	 * @param:             @param privilege_ids  权限id数组
	 * @param:             @return   
	 * @return:         int   删除结果
	 * @throws
	 */
	int deleteUserPrivilegeAdminToPidUids(@Param("tableName")String tableName,
			@Param("user_basics_id")int user_basics_id,@Param("privilege_ids")int[]privilege_ids);//删除用户的后台管理权限
	/**
	 * 
	 * @Title:             findPrivilegeAdministrativeUserToUid
	 * @Description:     TODO 以用户id为条件查询管理组用户数据
	 * @param:             @param user_basics_id 用户id 
	 * @param:             @return   
	 * @return:         Map<String,String>[]   每条数据为一个map。//返回的数据数组
	 * @throws
	 */
	Map<String,String>[] findPrivilegeAdministrativeUserToUid(
			int user_basics_id);//以用户id为条件查询管理组用户数据
	/**
	 * 
	 * @Title:             selectPrivilegeToUid
	 * @Description:     TODO 查询用户的后台权限
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param tableName 储存用户后台权限数据的表名
	 * @param:             @return   
	 * @return:         PrivilegeEntity  用户权限实体类 
	 * @throws
	 */
	PrivilegeEntity[] selectPrivilegeToUid(
			@Param("user_basics_id")int user_basics_id,@Param("tableName")String tableName);//查询用户的权限
	/**
	 * 
	 * @Title:             selectPrivilegeUrlToUid
	 * @Description:     TODO 查询用户的权限路径
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param tableName 
	 * @param:             @return   权限表名
	 * @return:         String[]   权限对应的路径
	 * @throws
	 */
	String[]selectPrivilegeUrlToUid(
			@Param("user_basics_id")int user_basics_id,@Param("tableName")String tableName);//查询用户的权限路径
	/**
	 * 
	 * @Title:             selectPrivilegeUrlVerifyOffToPriCode
	 * @Description:     TODO 通过权限code查询未加入认证的权限路径
	 * @param:             @param privilege_code_num 权限数字code 1后台管理权限 2pc权限 3微信端权限 4app端权限 5其它
	 * @param:             @return   
	 * @return:         String[]   权限路径数组
	 * @throws
	 */
	String[] selectPrivilegeUrlVerifyOffToPriCode(
			int privilege_code_num);//通过权限code查询未加入认证的权限路径
	/**
	 * 
	 * @Title:             likeSelectPrivilegeToPrivilege_url
	 * @Description:     TODO 根据权限的链接地址模糊查询权限信息
	 * @param:             @param privilege_url 权限的链接
	 * @param:             @return   
	 * @return:         PrivilegeEntity[]   
	 * @throws
	 */
	PrivilegeEntity[] likeSelectPrivilegeToPrivilege_url(String privilege_url);//根据权限的链接地址模糊查询权限信息
	/**
	 * 
	 * @Title:             batchUpdatePrivilegeOperateName
	 * @Description:     TODO 批量更新权限名
	 * @param:             @param privilegeEntityList 权限实体集合
	 * @param:             @return   
	 * @return:         int   更新条数
	 * @throws
	 */
	int batchUpdatePrivilegeOperateName(
			@Param("privilegeEntityList")List<PrivilegeEntity> privilegeEntityList);
	/**
	 * 
	 * @Title:             deletePG
	 * @Description:     TODO 根据权限组id删除一条权限组数据
	 * @param:             @param privilege_gather_id 权限组id
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int deletePGToPGId(int privilege_gather_id);
	/**
	 * 
	 * @Title:             deletePGPToPGId
	 * @Description:     TODO 删除权限组权限
	 * @param:             @param privilege_gather_id 权限组数据id
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int deletePGPToPGId(int privilege_gather_id);
	
}
