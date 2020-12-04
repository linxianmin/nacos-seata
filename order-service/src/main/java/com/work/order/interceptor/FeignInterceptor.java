package com.work.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.common.util.StringUtils;
import io.seata.core.context.RootContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {

        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
            System.out.println("feign xid：" + xid);
        }

        requestTemplate.header(RootContext.KEY_XID, xid);
    }
}