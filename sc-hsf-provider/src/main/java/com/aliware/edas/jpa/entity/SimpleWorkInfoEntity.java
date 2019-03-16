package com.aliware.edas.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "simple_work_info_03", schema = "zhiye", catalog = "")
public class SimpleWorkInfoEntity {
    private int id;
    private String thirdName;
    private String url;
    private String thirdNo;
    private String moneyRange;
    private String moneyHigh;
    private String moneyLow;
    private String address;
    private String zhiwei;
    private String workYears;
    private String xueli;
    private String companyName;
    private String companySize;
    private String companyDetail;
    private String workTime;
    private String spiderTime;
    private String order;
    private String fuli;
    private String companyNo;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "thirdName")
    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "thirdNo")
    public String getThirdNo() {
        return thirdNo;
    }

    public void setThirdNo(String thirdNo) {
        this.thirdNo = thirdNo;
    }

    @Basic
    @Column(name = "moneyRange")
    public String getMoneyRange() {
        return moneyRange;
    }

    public void setMoneyRange(String moneyRange) {
        this.moneyRange = moneyRange;
    }

    @Basic
    @Column(name = "moneyHigh")
    public String getMoneyHigh() {
        return moneyHigh;
    }

    public void setMoneyHigh(String moneyHigh) {
        this.moneyHigh = moneyHigh;
    }

    @Basic
    @Column(name = "moneyLow")
    public String getMoneyLow() {
        return moneyLow;
    }

    public void setMoneyLow(String moneyLow) {
        this.moneyLow = moneyLow;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "zhiwei")
    public String getZhiwei() {
        return zhiwei;
    }

    public void setZhiwei(String zhiwei) {
        this.zhiwei = zhiwei;
    }

    @Basic
    @Column(name = "workYears")
    public String getWorkYears() {
        return workYears;
    }

    public void setWorkYears(String workYears) {
        this.workYears = workYears;
    }

    @Basic
    @Column(name = "xueli")
    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    @Basic
    @Column(name = "companyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "companySize")
    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    @Basic
    @Column(name = "companyDetail")
    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail;
    }

    @Basic
    @Column(name = "workTime")
    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    @Basic
    @Column(name = "spiderTime")
    public String getSpiderTime() {
        return spiderTime;
    }

    public void setSpiderTime(String spiderTime) {
        this.spiderTime = spiderTime;
    }

    @Basic
    @Column(name = "`order`")
    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Basic
    @Column(name = "fuli")
    public String getFuli() {
        return fuli;
    }

    public void setFuli(String fuli) {
        this.fuli = fuli;
    }

    @Basic
    @Column(name = "companyNo")
    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleWorkInfoEntity that = (SimpleWorkInfoEntity) o;

        if (id != that.id) return false;
        if (thirdName != null ? !thirdName.equals(that.thirdName) : that.thirdName != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (thirdNo != null ? !thirdNo.equals(that.thirdNo) : that.thirdNo != null) return false;
        if (moneyRange != null ? !moneyRange.equals(that.moneyRange) : that.moneyRange != null) return false;
        if (moneyHigh != null ? !moneyHigh.equals(that.moneyHigh) : that.moneyHigh != null) return false;
        if (moneyLow != null ? !moneyLow.equals(that.moneyLow) : that.moneyLow != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (zhiwei != null ? !zhiwei.equals(that.zhiwei) : that.zhiwei != null) return false;
        if (workYears != null ? !workYears.equals(that.workYears) : that.workYears != null) return false;
        if (xueli != null ? !xueli.equals(that.xueli) : that.xueli != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (companySize != null ? !companySize.equals(that.companySize) : that.companySize != null) return false;
        if (companyDetail != null ? !companyDetail.equals(that.companyDetail) : that.companyDetail != null)
            return false;
        if (workTime != null ? !workTime.equals(that.workTime) : that.workTime != null) return false;
        if (spiderTime != null ? !spiderTime.equals(that.spiderTime) : that.spiderTime != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        if (fuli != null ? !fuli.equals(that.fuli) : that.fuli != null) return false;
        if (companyNo != null ? !companyNo.equals(that.companyNo) : that.companyNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (thirdName != null ? thirdName.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (thirdNo != null ? thirdNo.hashCode() : 0);
        result = 31 * result + (moneyRange != null ? moneyRange.hashCode() : 0);
        result = 31 * result + (moneyHigh != null ? moneyHigh.hashCode() : 0);
        result = 31 * result + (moneyLow != null ? moneyLow.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zhiwei != null ? zhiwei.hashCode() : 0);
        result = 31 * result + (workYears != null ? workYears.hashCode() : 0);
        result = 31 * result + (xueli != null ? xueli.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companySize != null ? companySize.hashCode() : 0);
        result = 31 * result + (companyDetail != null ? companyDetail.hashCode() : 0);
        result = 31 * result + (workTime != null ? workTime.hashCode() : 0);
        result = 31 * result + (spiderTime != null ? spiderTime.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (fuli != null ? fuli.hashCode() : 0);
        result = 31 * result + (companyNo != null ? companyNo.hashCode() : 0);
        return result;
    }
}
