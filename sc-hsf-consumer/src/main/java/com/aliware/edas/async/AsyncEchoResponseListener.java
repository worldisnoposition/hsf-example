package com.aliware.edas.async;

import com.alibaba.boot.hsf.annotation.AsyncOn;
import com.taobao.hsf.exception.HSFException;
import com.taobao.hsf.tbremoting.invoke.CallbackInvocationContext;
import com.taobao.hsf.tbremoting.invoke.HSFResponseCallback;



@AsyncOn(interfaceName = AsyncEchoService.class,methodName = "callback")
public class AsyncEchoResponseListener implements HSFResponseCallback{
    @Override
    public void onAppException(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onAppResponse(Object appResponse) {
        Object timestamp = CallbackInvocationContext.getContext();
        System.out.println(timestamp + "   " +appResponse);
    }

    @Override
    public void onHSFException(HSFException hsfEx) {
        hsfEx.printStackTrace();
    }
}
