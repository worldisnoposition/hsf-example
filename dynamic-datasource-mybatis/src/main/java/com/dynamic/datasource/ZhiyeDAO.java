package com.dynamic.datasource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZhiyeDAO {
//    @Insert("insert into zhiye (thirdName) values('haha')")
//@Datasource("secondary.master")
void saveZhiye(@Param("list") List<ZhiyeVo> list);
}
