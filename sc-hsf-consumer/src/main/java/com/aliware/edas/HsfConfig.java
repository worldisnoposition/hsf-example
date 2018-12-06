package com.aliware.edas;

import com.alibaba.boot.hsf.annotation.HSFConsumer;
import com.aliware.edas.async.AsyncEchoService;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HsfConfig {

    @HSFConsumer(serviceGroup = "xhb",clientTimeout = 3000, serviceVersion = "1.0.0")
    private EchoService echoService;


    @HSFConsumer(clientTimeout = 3000, serviceVersion = "1.0.0", futureMethods = "future")
    private AsyncEchoService asyncEchoService;
}
