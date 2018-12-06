package com.aliware.edas.async;

import com.alibaba.boot.hsf.annotation.HSFProvider;
import com.aliware.edas.async.AsyncEchoService;



@HSFProvider(serviceInterface = AsyncEchoService.class, serviceVersion = "1.0.0")
public class AsyncEchoServiceImpl implements AsyncEchoService {
    @Override
    public String future(String string) {
        return string;
    }

    @Override
    public String callback(String string) {
        return string;
    }
}
