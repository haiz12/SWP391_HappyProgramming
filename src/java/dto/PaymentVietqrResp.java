/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author admin
 */
public class PaymentVietqrResp {
    private String code;
    private String desc;
    private PaymentResp data;

    public PaymentVietqrResp() {
    }

    public PaymentVietqrResp(String code, String desc, PaymentResp data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public PaymentResp getData() {
        return data;
    }

    public void setData(PaymentResp data) {
        this.data = data;
    }

}
