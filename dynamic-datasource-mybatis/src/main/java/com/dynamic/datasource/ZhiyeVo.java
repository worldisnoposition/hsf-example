package com.dynamic.datasource;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class ZhiyeVo {
    @JSONField(name = "第三方名")
    public String thirdName;
    public String url;
    @JSONField(name = "第三方唯一标识")
    public String thirdNo;
    @JSONField(name = "薪酬范围")
    public String moneyRange;
    @JSONField(name = "薪酬上限")
    public String moneyHigh;
    @JSONField(name = "薪酬下限")
    public String moneyLow;
    @JSONField(name = "工作地点")
    public String address;
    @JSONField(name = "职位")
    public String zhiwei;
    @JSONField(name = "年限")
    public String workYears;
    @JSONField(name = "学历")
    public String xueli;
//    @JSONField(name = "要求")
//    public String yaoqiu;
    @JSONField(name = "公司名")
    public String companyName;
    @JSONField(name = "公司规模")
    public String companySize;
    @JSONField(name = "公司详情")
    public String companyDetail;
    @JSONField(name = "职位日期")
    public String workTime;
    @JSONField(name = "爬取日期")
    public String spiderTime;
    @JSONField(name = "其他信息")
    public String order;
    @JSONField(name = "福利")
    public String fuli;
    @JSONField(name = "公司唯一标识")
    public String companyNo;

}

//{
//        "第三方名":"boss直聘",
//        "url":"https://www.zhipin.com/job_detail/e417017161ef51001nFy0tW8FVA~.html",
//        "第三方唯一标识":"e417017161ef51001nFy0tW8FVA~",
//        "薪酬范围":"15k-30k",
//        "薪酬下限":"15000",
//        "薪酬上限":"30000",
//        "工作地点":"北京 朝阳区 大屯",
//        "职位":"爬虫工程师",
//        "年限":"1-3年",
//        "要求":"",
//        "学历":"本科",
//        "公司名":"百分点科技",
//        "公司规模":"500-999人",
//        "公司详情":"企业服务,D轮及以上",
//        "职位日期":"2018-08-07",
//        "爬去日期":"2018-0719",
//        "其他信息":""
//        }
