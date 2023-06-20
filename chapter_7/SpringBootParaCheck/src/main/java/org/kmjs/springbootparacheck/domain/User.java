package org.kmjs.springbootparacheck.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message="姓名不能为空")
    private String name;
    @NotNull(message="年纪不能为空")
    @Min(value = 0, message = "输入年龄小于最小值")
    @Max(value = 150, message = "输入年龄大于最大值")
    private Integer age = -1;
    @Length(min=7,max=11,message = "输入号码错误")
    private String phoneNum;
    @NotBlank(message="姓名不能为空")
    private String address;

    @Override
    public String toString() {
        return "name is " + name + ", age is " + age + ", phoneNum is " + phoneNum + ", address is" + address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
