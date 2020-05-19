package com.mrkb.shiro.service.impl;
import com.mrkb.dao.dao.BasicUserMapper;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.shiro.mapper.ShiroUserMapper;
import com.mrkb.shiro.mapper.ShiroUserRoleMapper;
import com.mrkb.shiro.model.SysUser;
import com.mrkb.shiro.model.User;
import com.mrkb.shiro.service.ShiroUserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Administrator
 * @create 2017/12/3
 * @since 1.0.0
 */
@Service
public class ShiroUserServiceImpl implements ShiroUserService{

    @Autowired
    private ShiroUserMapper userMapper;
    
    @Autowired
    private ShiroUserRoleMapper userRoleMapper;
    @Autowired
    private BasicUserMapper basicUsermapper;

    //log对象 操作日志
    private static final transient Logger log = LoggerFactory.getLogger(ShiroUserServiceImpl.class);
    
    @Override
    public User findByUsername(String username) {
//        System.out.println("userMapper:"+this.userMapper);
//        User user = this.userMapper.findByUsername(username);
//        System.out.println(user.toString());
        return this.userMapper.findByUsername(username).get(0);
    }

    
	/**
	 * 分页查询用户信息
	 */
	public List<User> getUserPageList(User user) {
		List<User>list = new ArrayList<User>();
		list = userMapper.getUserPageList(user);
		return list;
	}


	/**
	 * 新增系统用户
	 */
	public Integer addNewUser(User user,String role_id) {
		Long time = System.currentTimeMillis();
		//默认密码000000（6个零）
		String password = new Sha256Hash("letang123456").toHex();
		Integer num=0;
		user.setUser_register_data(time);
		user.setUser_password(password);
		try {
			num = userMapper.insert(user);
			Integer user_basics_id=user.getUser_basics_id();
			//新增用户绑定角色
			if(!role_id.equals("") || role_id.length()==0){
				Map<String, Object> role = new HashMap<String, Object>();
				role.put("user_id", user_basics_id);
				role.put("role_id", role_id);
				role.put("create_time", new Date());
				num = userRoleMapper.insertSelective(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("新增用户"+user.getUser_account_num()+"异常");
			log.error("新增用户"+user.getUser_account_num()+"异常");
			return num;
		}
		return num;
	}


	/**
	 * 删除用户
	 */
	public Integer removeUser(Integer user_id) {
		Integer num =0;
		try {
			//删除用户账号
			num =userMapper.removeUser(user_id);
			//删除用户角色
			num=userRoleMapper.delByUserId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("系统管理删除用户异常");
			log.error("系统管理删除用户异常");
			return num;
		}
		return num;
	}

	
	

	/**
	 * 编辑用户信息
	 */
	public Integer editUser(User user) {
		Integer num=0;
		Map<String, Object>param = new HashMap<String, Object>();
		try {
			num = userMapper.editUser(user);
			if(user.getRole_id()!=null){
				param.put("role_id", user.getRole_id());
				param.put("user_id", user.getUser_basics_id());
				param.put("create_time",new Date());
				//删除原有的角色再新增
				userRoleMapper.delByUserId(user.getUser_basics_id());
				num = userRoleMapper.insertSelective(param);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("系统管理编辑用户信息异常");
			log.error("系统管理编辑用户信息异常");
			return num;
		}
		return num;
	}

	

	/**
	 * 根据用户ID查询用户信息
	 */
	public User findUserByUserId(Integer user_id) {
		User user = new User();
		try {
			user = userMapper.findUserByUserId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("系统管理编辑用户信息异常");
			log.error("系统管理编辑用户信息异常");
			return null;
		}
		return user;
	}


	@Override
	public int updateUserBasics(BasicsUser basicsUser) {
		return basicUsermapper.updateUserBasics(basicsUser);
	}
	@Override
	public SysUser findBySysUsername(String basicsUser) {
		return userMapper.findBySysUsername(basicsUser);
	}
}