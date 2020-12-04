package com.work.account.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.work.account.entity.Account;
import com.work.account.repository.AccountDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
@Service
public class AccountService {

    @Resource
    private AccountDAO accountDAO;

    /**
     * 减金额
     *
     * @Param [userId, money]
     **/
    public void reduce(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new Account().setUserId(userId));
        Account account = accountDAO.selectOne(wrapper);
        account.setMoney(account.getMoney().subtract(money));
        accountDAO.updateById(account);
    }
}
