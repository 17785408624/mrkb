package com.mrkb.web.controller.sys;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.service.BizUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys")
public class BizUserController {

    @Autowired
    private BizUserService userService;

    //查询
    @RequestMapping(value = "/getObject")
    public ResponseData getObject(){
        ResponseData R = new ResponseData();
        List<Map<String, Object>> user = userService.getObject();
        R.setData(user);
        R.setIsSuccess(true);
        R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        return R;
    }



    /**
     * 分页查询示例
     * @param pageNum(页数)
     * @param pageSize(每页显示多少)
     * @return
     */
    @RequestMapping("/pagehelperText/{pageNum}/{pageSize}")
    public ResponseData pagehelperText(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        ResponseData R = new ResponseData();
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> user = userService.getObject();
        PageInfo<Map<String,Object>> PageInfo = new PageInfo<>(user);
        R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(PageInfo);
        return R;
    }

}
