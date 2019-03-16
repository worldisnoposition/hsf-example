package com.aliware.edas.jpa.testrest;

import com.alibaba.fastjson.JSONObject;
import com.aliware.edas.jpa.entity.SimpleWorkInfoEntity;
import com.aliware.edas.jpa.repository.SimpleWorkInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "simpleWorkInfo")
@Slf4j
public class TestControllerRest {
    @Autowired
    private SimpleWorkInfoRepository simpleWorkInfoRepository;

    @PostMapping(path = "add")
    public String addSimpleWork(SimpleWorkInfoEntity simpleWorkInfoEntity) {
        log.info(JSONObject.toJSONString(simpleWorkInfoEntity));
        simpleWorkInfoRepository.save(simpleWorkInfoEntity);
        return "success";
    }
}
