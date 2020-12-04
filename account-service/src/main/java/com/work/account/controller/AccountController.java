package com.work.account.controller;


import com.work.account.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Program Name: springcloud-nacos-seata
 * <p>
 * Description:
 * <p>
 *
 * @author zhangjianwei
 * @version 1.0
 * @date 2019/8/28 4:05 PM
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
     * 减金额
     *
     * @return java.lang.Boolean
     * @Param [userId, money]
     **/
    @RequestMapping(path = "/reduce")
    public Boolean reduce(String userId, @RequestParam("money") BigDecimal money) {
        accountService.reduce(userId, money);
        return true;
    }

}
