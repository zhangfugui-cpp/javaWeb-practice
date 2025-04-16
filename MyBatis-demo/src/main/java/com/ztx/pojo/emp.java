package com.ztx.pojo;
import java.util.Date;
public class emp {
    private Integer id;            // 员工ID
    private String name;          // 姓名
    private String sex;           // 性别
    private Date birthday;        // 出生日期（只包含年月日）
    private Date entryData;       // 入职时间（包含时分秒）
    private String job;           // 职位
    private Double salary;        // 薪资
    private String resume;        // 个人简介

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntryData() {
        return entryData;
    }

    public void setEntryData(Date entryData) {
        this.entryData = entryData;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", entryData=" + entryData +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", resume='" + resume + '\'' +
                '}';
    }
}
