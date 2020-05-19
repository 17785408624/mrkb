/**
 * FileName:         SearchUserUtilSeriviceImpl.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-28     下午5:18:13
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-28     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.common.utils.serviceutil.serviceutilimpl;

import com.mrkb.common.utils.publicUtil;
import com.mrkb.dao.modle.user.UserEntity;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class SearchUserUtilSeriviceImpl {//搜索用户信息业务工具类
	public static UserEntity assembleSearchConditionUserEntity(String searchTerms){//组装搜索条件UserEntity实体类
		UserEntity userEntity=new UserEntity(); 
		if(publicUtil.isNum(searchTerms)){//判断参数是否为数字 搜索词可以转为数字
			int searchTermsInt=Integer.parseInt(searchTerms);
			if(publicUtil.isUser_basics_id(searchTermsInt)){//数字是否为用户id类型
				userEntity.setUser_basics_id(searchTermsInt);
			}
			if(publicUtil.isInformation_phone(searchTermsInt)){//是否为手机号码类型
				userEntity.setInformation_phone(searchTerms);
			}
			if(publicUtil.isInformation_card(searchTerms)){//是否为身份证类型
				userEntity.setInformation_card(searchTerms);
			}
			if(publicUtil.isWeixin_nickname(searchTerms)){//是否为微信昵称类型
				userEntity.setWeixin_nickname(searchTerms);
			}
			if(publicUtil.isNick_name(searchTerms)){//是否为用户昵称类型
				userEntity.setNick_name(searchTerms);
			}
			if(publicUtil.isUser_account_num(searchTerms)){//是否为用户账号类型
				userEntity.setUser_account_num(searchTerms);
			}
		}else{//搜索词不能转为数字
			if(publicUtil.isInformation_card(searchTerms)){//是否为身份证类型
				userEntity.setInformation_card(searchTerms);
			}
			if(publicUtil.isWeixin_nickname(searchTerms)){//是否为微信昵称类型
				userEntity.setWeixin_nickname(searchTerms);
			}
			if(publicUtil.isInformation_compellation(searchTerms)){//是否为用户真实姓名的类型
				userEntity.setInformation_compellation(searchTerms);
			}
			if(publicUtil.isNick_name(searchTerms)){//是否为用户昵称类型
				userEntity.setNick_name(searchTerms);
			}
			if(publicUtil.isUser_account_num(searchTerms)){//是否为用户账号类型
				userEntity.setUser_account_num(searchTerms);
			}
		}
		return userEntity;
		
		
	}

}
