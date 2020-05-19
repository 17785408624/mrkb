package com.mrkb.web.controller.sys;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.dao.BasicStoreMapper;
import com.mrkb.dao.modle.store.Business;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.service.BusinessService;
import com.mrkb.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 *
 * @author liangyi 璇剧▼controller Storecontroller
 */
@Controller
@RequestMapping("/admin_business")
public class BusinessController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private BasicStoreMapper basicStoreMapper;
    @Autowired
    private BusinessService businessService;
    /**
     * 商家管理跳转页面
     *
     * @return 杩斿洖/sys/storeManage.html
     */
    @RequestMapping("/businessManage")
    public String businessManage() {
        return "sys/store/businessManage";
    }

    /**
     *新增商家
     *
     * @param business
     * @return
     */
    @ResponseBody
    @RequestMapping("/businessAdd")
    public ResponseData businessAdd(@RequestBody Business business) {
        ResponseData r = new ResponseData();
        StoreBasics storeBasics2 = null;
        business.setAdd_time(System.currentTimeMillis());
        business.setStatus_state(0);
        int add=businessService.add(business);

        if (add == 1) {
            r.setErrorCode(ResponseCode.SUCC_DO.getCode());
            r.setMessage(ResponseCode.SUCC_DO.getMsg());
            return r;
        }
        r.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
        r.setMessage(ResponseCode.ERROR_FAIL.getMsg());
        return r;
    }


    /**
     * 查询所有商家
     *
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public ResponseData findAll(
            HttpServletRequest req) {
        Business business = new  Business();
        ResponseData R = new ResponseData();
        Integer pageNum =Integer.valueOf(req.getParameter("pageIndex"));
        Integer pageSize =Integer.valueOf(req.getParameter("pageSize"));
        PageHelper.startPage(pageNum, pageSize);
        List<Business> lb=businessService.findAll(business);
        PageInfo<Business> PageInfo = new PageInfo<>(lb);
        R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(PageInfo);
        return R;
    }

    /**
     * 查询单个商家
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getById/{id}")
    public ResponseData findById(@PathVariable("id") Integer id) {
        ResponseData R = new ResponseData();
        Business business = new  Business();
        business.setBusiness_id(id);
        business=businessService.findById(business);

        R.setData(business);
        R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
        return R;
    }

    /**
     * 修改商家
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public ResponseData update(@RequestBody Business business) {
        ResponseData R = new ResponseData();
        Integer num = businessService.update(business);
        if (num > 0) {
            R.setErrorCode(ResponseCode.SUCC_DO.getCode());
            R.setMessage(ResponseCode.SUCC_DO.getMsg());
            return R;
        }
        R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
        R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
        return R;
    }

    /*
     * 删除商家
     */
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public ResponseData delete(@PathVariable("id") Integer id,HttpServletRequest request){
        ResponseData R = new ResponseData();
        Business business = new  Business();
        business.setBusiness_id(id);
        business=businessService.findById(business);
        String pictures = business.getBusiness_picture();
        if(pictures!=null){
            String[] picturess = pictures.split(";");
            String pathRoot = "C:/file";//图片保存根路径
            for (int i = 0; i < picturess.length; i++) {
                String path = pathRoot;//鍥剧墖缁濆璺緞
                path += picturess[i];
                File file = new File(path);
                file.delete();
            }
        }
        Integer num =businessService.delete(business);
        System.out.println("num澶т簬"+num);
        if(num>0){
            R.setErrorCode(ResponseCode.SUCC_DO.getCode());
            R.setMessage(ResponseCode.SUCC_DO.getMsg());
            return R;
        }
        R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
        R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
        return R;
    }


}
