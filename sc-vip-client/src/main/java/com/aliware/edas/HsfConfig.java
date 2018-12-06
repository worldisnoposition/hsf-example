package com.aliware.edas;

import com.taobao.hsf.app.spring.util.annotation.HSFConsumer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HsfConfig {
    @HSFConsumer(serviceGroup = "xhb",clientTimeout = 3000, serviceVersion = "1.0.0")
    private EchoService echoService;
}
