package com.mrkb.web.controller.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mrkb.dao.modle.apply.WithdrawalApplyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.account.CapitalAccount;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.apply.BonusExtractApplyEntity;
import com.mrkb.dao.modle.user.UserWeiXinAndInformationGrade;
import com.mrkb.service.ApplyService;
import com.mrkb.service.IntegraService;


@Controller("admin_bonus")
@RequestMapping("/admin_bonus")
public class BonusExController {

    @Autowired
    private ApplyService applyService;//提现
    @Autowired
    private IntegraService integraService;//积分
    /**
     * 兑换到余额列表
     *
     * @param response
     * @param request
     * @return string
     */
    @RequestMapping("exchangeBonus")
    public String exchangeBonus(HttpServletResponse response,
                                HttpServletRequest request) {
        return "sys/bonus/exchangeBonus";
    }
    /**
     * 提现列表
     *
     * @param response
     * @param request
     * @return string
     */
    @RequestMapping("withdrawalBonus")
    public String withdrawalBonus(HttpServletResponse response,
                                  HttpServletRequest request) {
        return "sys/bonus/withdrawalBonus";
    }


    /**
     * 根据用户ID查询  用户基本信息、微信信息及会员等级
     * 开发人员：陈文军
     * 2018-05-03
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("findUserWXIFGrade")
    @ResponseBody
    public ResponseData findUserWXIFGrade(HttpServletResponse response,
                                          HttpServletRequest request,
                                          @RequestBody Map<String, Object> jsonData){
        Integer user_id = Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
        UserWeiXinAndInformationGrade uwxg = integraService.findUserWXIFGrade(user_id);
        ResponseData rs = new ResponseData();
        rs.setData(uwxg);
        return rs;

    }

    /**注：时间插件没有获取时分秒，只获取当天的时间戳。
     * 查询提现申请
     * 2018-05-25
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("adminFindIntegr")
    @ResponseBody
    public ResponseData adminFindIntegr(@RequestParam("pageSize") Integer pageSize,
                                        @RequestParam("pageIndex") Integer pageIndex,HttpServletRequest req) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //默认待打款(1)状态
        Integer apply_status=1;
        try {
            apply_status = Integer.valueOf(req.getParameter("state"));
            map.put("apply_status", apply_status);
        } catch (NumberFormatException e) {
        }
        //日期范围查询
		/*Long apply_add_date;
		try {
			apply_add_date = Long.valueOf(String.valueOf(jsonData.get("datetime")));
			map.put("apply_add_date", apply_add_date);
		} catch (NumberFormatException e) {
		}*/
        //提现单日程查询
        Long apply_add_date2;
        try {
            apply_add_date2 = Long.valueOf(req.getParameter("datetime"));
            map.put("apply_add_date2", apply_add_date2);
        } catch (NumberFormatException e) {
        }
        //控制查询当天时间值
        Long date;
        try {
            date = Long.valueOf(req.getParameter("datetime"));
            Long apply_add_date1 = date+(24*60*60*1000);
            map.put("apply_add_date1", apply_add_date1);
        } catch (NumberFormatException e) {
        }
		/*//控制时间范围值
		Long datetime2;
	    try {
			datetime2 = Long.valueOf(String.valueOf(jsonData.get("datetime2")));
			Long datetime = datetime2+(24*60*60*1000);
			map.put("datetime2", datetime);
		} catch (NumberFormatException e1) {
		}*/
        //根据用户ID查询
        Integer user_basics_id;
        try {
            user_basics_id = Integer.valueOf(req.getParameter("user_basics_id"));
            map.put("user_basics_id", user_basics_id);
        } catch (NumberFormatException e) {

        }
        PageHelper.startPage(pageIndex, pageSize);
        List<WithdrawalApplyEntity> listbean = applyService.selectWithdrawalApplyToStatus(apply_status);
        PageInfo<WithdrawalApplyEntity> PageInfo = new PageInfo<>(listbean);
        ResponseData rs = new ResponseData();
        rs.setData(PageInfo);
        return rs;
    }
    /**注：时间插件没有获取时分秒
     * 查询打款申请状态
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("adminFindToMoney")
    @ResponseBody
    public ResponseData adminFindToMoney(HttpServletResponse response,
                                         HttpServletRequest request,
                                         @RequestBody Map<String, Object> jsonData) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //默认待打款(3)状态
        Integer apply_status;
        try {
            apply_status = Integer.valueOf(String.valueOf(jsonData.get("state")));
            map.put("apply_status", apply_status);
        } catch (NumberFormatException e) {
        }
        //日期范围查询
        Long apply_edit_date;
        try {
            apply_edit_date = Long.valueOf(String.valueOf(jsonData.get("datetime")));
            map.put("apply_edit_date", apply_edit_date);
        } catch (NumberFormatException e) {
        }
        //打款单日程查询
        Long apply_edit_date2;
        try {
            apply_edit_date2 = Long.valueOf(String.valueOf(jsonData.get("datetime")));
            map.put("apply_edit_date2", apply_edit_date2);
        } catch (NumberFormatException e) {
        }
        //控制查询当天时间值
        Long date;
        try {
            date = Long.valueOf(String.valueOf(jsonData.get("datetime")));
            Long apply_edit_date1 = date+(24*60*60*1000);
            map.put("apply_edit_date1", apply_edit_date1);
        } catch (NumberFormatException e) {
        }
        //控制时间范围值
        Long datetime2;
        try {
            datetime2 = Long.valueOf(String.valueOf(jsonData.get("datetime2")));
            Long datetime = datetime2+(24*60*60*1000);
            map.put("datetime2", datetime);
        } catch (NumberFormatException e1) {
        }
        //根据用户ID查询
        Integer user_basics_id;
        try {
            user_basics_id = Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
            map.put("user_basics_id", user_basics_id);
        } catch (NumberFormatException e) {
        }
        List<BonusExtractApplyEntity> listbean = applyService.findBonusMoney(map);
        ResponseData rs = new ResponseData();
        rs.setData(listbean);
        return rs;
    }
    /**注：时间插件没有获取时分秒
     * 打款时间组合查询控制器
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("timeCombination")
    @ResponseBody
    public ResponseData timeCombination(HttpServletResponse response,
                                        HttpServletRequest request,
                                        @RequestBody Map<String, Object> jsonData) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //日期范围查询
        Long apply_edit_date;
        try {
            apply_edit_date = Long.valueOf(String.valueOf(jsonData.get("datetime")));
            map.put("apply_edit_date", apply_edit_date);
        } catch (NumberFormatException e) {
        }
        //控制时间范围值
        Long datetime2;
        try {
            datetime2 = Long.valueOf(String.valueOf(jsonData.get("datetime2")));
            Long datetime = datetime2+(24*60*60*1000);
            map.put("datetime2", datetime);
        } catch (NumberFormatException e1) {
        }
        List<BonusExtractApplyEntity> listbean = applyService.findTimeCombination(map);
        ResponseData rs = new ResponseData();
        rs.setData(listbean);
        return rs;
    }
    /**注：时间插件没有获取时分秒
     * 提现时间组合查询控制器
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("presentTimeCombination")
    @ResponseBody
    public ResponseData presentTimeCombination(HttpServletResponse response,
                                               HttpServletRequest request,
                                               @RequestBody Map<String, Object> jsonData) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //日期范围查询
        Long apply_add_date;
        try {
            apply_add_date = Long.valueOf(String.valueOf(jsonData.get("datetime")));
            map.put("apply_add_date", apply_add_date);
        } catch (NumberFormatException e) {
        }
        //控制时间范围值
        Long datetime2;
        try {
            datetime2 = Long.valueOf(String.valueOf(jsonData.get("datetime2")));
            Long datetime = datetime2+(24*60*60*1000);
            map.put("datetime2", datetime);
        } catch (NumberFormatException e1) {
        }
        List<BonusExtractApplyEntity> listbean = applyService.presentTimeCombination(map);
        ResponseData rs = new ResponseData();
        rs.setData(listbean);
        return rs;
    }
    /**
     * 组合查询打款申请状态
     * 开发人员：陈文军
     * 2018-05-25
     * 注：时间插件没有获取时分秒，只获取当天的时间戳。
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("adminFindCombinatorial")
    @ResponseBody
    public ResponseData adminFindCombinatorial(HttpServletResponse response,
                                               HttpServletRequest request,
                                               @RequestBody Map<String, Object> jsonData) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //选择的状态
        Integer apply_status;
        try {
            apply_status = Integer.valueOf(String.valueOf(jsonData.get("state")));
            map.put("apply_status", apply_status);
        } catch (NumberFormatException e) {
        }
        //选择的时间
        Long apply_edit_date;
        try {
            apply_edit_date = Long.valueOf(String.valueOf(jsonData.get("datetime")));
            map.put("apply_edit_date", apply_edit_date);
        } catch (NumberFormatException e) {
        }
        //日期范围，单控制无效
        Long datetime;
        try {
            datetime = Long.valueOf(String.valueOf(jsonData.get("datetime2")));
            Long datetime2 = datetime+(24*60*60*1000);
            map.put("datetime2", datetime2);
        } catch (NumberFormatException e1) {
        }
        //输入的用户ID
        Integer user_basics_id;
        try {
            user_basics_id = Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
            map.put("user_basics_id", user_basics_id);
        } catch (NumberFormatException e) {
        }
        List<BonusExtractApplyEntity> listbean = applyService.findCombinatorial(map);
        ResponseData rs = new ResponseData();
        rs.setData(listbean);
        return rs;
    }
    /**
     * 组合查询提現申请状态
     * 开发人员：陈文军
     * 2018-05-25
     * 注：时间插件没有获取时分秒
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("findPfCombinatorial")
    @ResponseBody
    public ResponseData findPfCombinatorial(HttpServletResponse response,
                                            HttpServletRequest request,
                                            @RequestBody Map<String, Object> jsonData) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //选择的状态
        Integer apply_status;
        try {
            apply_status = Integer.valueOf(String.valueOf(jsonData.get("state")));
            map.put("apply_status", apply_status);
        } catch (NumberFormatException e) {
        }
        //选择的时间
        Long apply_add_date;
        try {
            apply_add_date = Long.valueOf(String.valueOf(jsonData.get("datetime")));
            map.put("apply_add_date", apply_add_date);
        } catch (NumberFormatException e) {
        }
        //日期范围，单控制无效
        Long datetime;
        try {
            datetime = Long.valueOf(String.valueOf(jsonData.get("datetime2")));
            Long datetime2 = datetime+(24*60*60*1000);
            map.put("datetime2", datetime2);
        } catch (NumberFormatException e1) {
        }
        //输入的用户ID
        Integer user_basics_id;
        try {
            user_basics_id = Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
            map.put("user_basics_id", user_basics_id);
        } catch (NumberFormatException e) {
        }
        List<BonusExtractApplyEntity> listbean = applyService.findPfCombinatorial(map);
        ResponseData rs = new ResponseData();
        rs.setData(listbean);
        return rs;

    }
    /**
     * 拒绝打款申请状态
     * 开发人员：陈文军
     * 2018-04-25
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("updatebonusstate7")
    @ResponseBody
    public ResponseData updatebonusstate7(HttpServletResponse response,
                                          HttpServletRequest request,
                                          @RequestBody Map<String, Object> jsonData){
        BonusExtractApplyEntity bonusExtractApplyEntity = new BonusExtractApplyEntity();
        try {
            Integer bonus_extract_apply_id = Integer.valueOf(String.valueOf(jsonData
                    .get("bonus_extract_apply_id")));// 编号
            bonusExtractApplyEntity.setBonus_extract_apply_id(bonus_extract_apply_id);
        } catch (Exception e) {
            // TODO: handle exception
        }
        bonusExtractApplyEntity.setApply_status(7);
        int bonusstate = applyService.updatebonusstate(bonusExtractApplyEntity);
        ResponseData rs = new ResponseData();
        rs.setData(bonusstate);
        rs.setIsSuccess(true);
        return rs;

    }
    /**
     * 通过提现申请状态
     * 开发人员：陈文军
     * 2018-04-25
     * @param response
     * @param request
     * @return vnl
     */
    @ResponseBody
    @RequestMapping("updatebonusstate3/{id}")
    public ResponseData updatebonusstate3(HttpServletResponse response,
                                          HttpServletRequest request,
                                          @PathVariable("id") Integer id){
        BonusExtractApplyEntity bonusExtractApplyEntity = new BonusExtractApplyEntity();
        Integer bonus_extract_apply_id = id;// 编号
        bonusExtractApplyEntity.setBonus_extract_apply_id(bonus_extract_apply_id);
        bonusExtractApplyEntity.setApply_status(3);
        Long date = System.currentTimeMillis();
        bonusExtractApplyEntity.setApply_edit_date(date);
        int bonusstate = applyService.updatebonusstate(bonusExtractApplyEntity);
        ResponseData rs = new ResponseData();
        rs.setData(bonusstate);
        rs.setIsSuccess(true);
        return rs;

    }
    /**
     * 拒绝提现申请状态
     * 开发人员：陈文军
     * 2018-04-25
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("updatebonusstate8/{id}")
    @ResponseBody
    public ResponseData updatebonusstate8(HttpServletResponse response,
                                          HttpServletRequest request,
                                          @PathVariable("id") Integer id){
        BonusExtractApplyEntity bonusExtractApplyEntity = new BonusExtractApplyEntity();
        bonusExtractApplyEntity.setBonus_extract_apply_id(id);
        bonusExtractApplyEntity.setApply_status(2);
        int bonusstate = applyService.updatebonusstate(bonusExtractApplyEntity);
        ResponseData rs = new ResponseData();
        rs.setData(bonusstate);
        rs.setIsSuccess(true);
        return rs;

    }
    /**
     * 查询交易流水提现记录
     * 开发人员：陈文军
     * 2018-04-26
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("adminFindTradingFlow")
    @ResponseBody
    public ResponseData adminFindTradingFlow(HttpServletResponse response,
                                             HttpServletRequest request,
                                             @RequestBody Map<String, Object> jsonData) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            String name = String.valueOf(jsonData.get("information_compellation"));
            if(name.equals(null)||name.equals("null")){
                map.put("information_compellation", null);
            }else{
                map.put("information_compellation", name);
            }

        } catch (Exception e) {
            map.put("information_compellation", null);
        }

        try {
            String number = String.valueOf(jsonData.get("information_card"));
            if(number.equals(null)||number.equals("null")){
                map.put("information_card", null);
            }else{
                map.put("information_card", number);
            }

        } catch (Exception e) {
            map.put("information_card", null);
        }
        int apply_status=1;
        try {
            apply_status = Integer.valueOf(String.valueOf(jsonData.get("state")));
            map.put("apply_status", apply_status);
        } catch (NumberFormatException e) {
            map.put("apply_status", null);
        }
        List<WithdrawalApplyEntity> listbean = applyService.selectWithdrawalApplyToStatus(apply_status);
        System.out.println("查询结果："+listbean);
        ResponseData rs = new ResponseData();
        rs.setData(listbean);
        rs.setIsSuccess(true);
        return rs;
    }
    /**
     * 查询全部积分
     * 开发人员：陈文军
     * 2018-04-27
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("findIntegra")
    @ResponseBody
    public ResponseData findIntegra(HttpServletResponse response,
                                    HttpServletRequest request,
                                    @RequestBody Map<String, Object> jsonData){
        HashMap< String, Object> map = new HashMap<String, Object>();
        Integer user_basics_id;
        try {
            user_basics_id = Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
            map.put("user_basics_id", user_basics_id);
        } catch (NumberFormatException e) {
        }
        String account_option_name=null;
        try {
            account_option_name = String.valueOf(jsonData.get("IntegrName")).equals("null")?null:String.valueOf(jsonData.get("IntegrName"));
            map.put("account_option_name", account_option_name);
        } catch (Exception e) {
        }
        ResponseData rs = new ResponseData();
        List<IntegralAccount> listIntegr = integraService.findIntegraByPage(map);
        int sum = listIntegr.size();
        System.out.println("查询结果总数："+sum);
        /*添加分页参数并与结果集一并返回*/
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("totalNumber", request.getAttribute("totalNumber"));
        map1.put("totalPage", request.getAttribute("totalPage"));
        map1.put("currentPage", request.getAttribute("currentPage"));
        map1.put("listIntegr", listIntegr);
        rs.setData(map1);
        return rs;
    }
    /**
     * 查询所有购买记录
     * 开发人员：陈文军
     * 2018-04-27
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("adminFindCapital")
    @ResponseBody
    public ResponseData adminFindCapital(HttpServletResponse response,
                                         HttpServletRequest request,
                                         @RequestBody Map<String, Object> jsonData){
        HashMap<String, Object> map = new HashMap<String, Object>();
        Integer user_basics_id;
        try {
            user_basics_id = Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
            map.put("user_basics_id", user_basics_id);
            map.put("capital_account_type", 1);
        } catch (Exception e) {
        }
        ResponseData rs = new ResponseData();
        List<CapitalAccount> listCapital = integraService.findCapitalAccountByPage(map);
        //vnl.setObject(listCapital);
        /*添加分页参数并与结果集一并返回*/
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("totalNumber", request.getAttribute("totalNumber"));
        map1.put("totalPage", request.getAttribute("totalPage"));
        map1.put("currentPage", request.getAttribute("currentPage"));
        map1.put("listCapital", listCapital);
        rs.setData(map1);
        return rs;
    }
    /**
     * 查询单个用户购买流水
     * 开发人员：陈文军
     * 2018-05-07
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("findCapitalOne")
    @ResponseBody
    public ResponseData findCapitalOne(HttpServletResponse response,
                                       HttpServletRequest request,
                                       @RequestBody Map<String, Object> jsonData){
        Integer user_basics_id = Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
        List<CapitalAccount> listCapital = integraService.findCapitalOne(user_basics_id);
        ResponseData rs = new ResponseData();
        rs.setData(listCapital);
        rs.setIsSuccess(true);
        return rs;
    }
    /**
     * 查询单个用户购买流水
     * 开发人员：陈文军
     * 2018-05-07
     * @param response
     * @param request
     * @return vnl
     */
    @RequestMapping("findBonusExtractOne")
    @ResponseBody
    public ResponseData findBonusExtractOne(HttpServletResponse response,
                                            HttpServletRequest request,
                                            @RequestBody Map<String, Object> jsonData){
        Integer user_basics_id = Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
        List<BonusExtractApplyEntity> listBonus = applyService.findBonusExtractOne(user_basics_id);
        ResponseData rs = new ResponseData();
        rs.setData(listBonus);
        return rs;
    }
}
