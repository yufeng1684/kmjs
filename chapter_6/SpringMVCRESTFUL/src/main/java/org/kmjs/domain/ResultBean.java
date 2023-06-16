package org.kmjs.domain;

public class ResultBean {
    private int code;
    private Product data;
    private String msg;

    public ResultBean() {

    }

    public ResultBean(int code, Product data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static ResultBean ofSuccess(Product obj) {
        ResultBean ret = new ResultBean();
        ret.setCode(200);
        ret.setData(obj);
        return ret;
    }

    public static ResultBean ofSuccess(String msg) {
        ResultBean ret = new ResultBean();
        ret.setCode(200);
        ret.setMsg(msg);
        return ret;
    }

    public static ResultBean ofSuccess(Product obj, String msg) {
        ResultBean ret = new ResultBean();
        ret.setCode(200);
        ret.setData(obj);
        ret.setMsg(msg);
        return ret;
    }

    public static ResultBean ofSuccess() {
        ResultBean ret = new ResultBean();
        ret.setCode(200);
        return ret;
    }

    public static ResultBean ofFail(int code, String desc) {
        ResultBean ret = new ResultBean();
        ret.setCode(code);
        ret.setMsg(desc);
        return ret;
    }

    public int getCode() {
        return code;
    }

    public Product getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Product data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
