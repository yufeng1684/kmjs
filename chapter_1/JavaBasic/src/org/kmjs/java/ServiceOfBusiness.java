package org.kmjs.java;

public class ServiceOfBusiness {
    private String serverCode;
    private boolean isTrueFlag;
    public ServiceOfBusiness() {
        super();
    }

    public ServiceOfBusiness(String code, boolean isTrue) {
        this.serverCode = code;
        this.isTrueFlag = isTrue;
    }

    public boolean printFlag() {
        System.out.println(isTrueFlag);
        return isTrueFlag;
    }

    public String printServerCode() {
        System.out.println(serverCode);
        return serverCode;
    }
}
