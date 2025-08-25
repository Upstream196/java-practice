package com.example;

public class R {
    private int code=200;

    private boolean flag=true;

    private Object data;

    public static R ok(Object data) {
        R r=new R();
        r.data=data;
        return r;
    }

    public static R fail(Object data) {
        R r=new R();
        r.code=500;
        r.flag=false;
        r.data=data;
        return r;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
