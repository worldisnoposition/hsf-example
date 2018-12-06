package com.aliware.edas.async;


public interface AsyncEchoService {
    String future(String string);
    String callback(String string);
}
