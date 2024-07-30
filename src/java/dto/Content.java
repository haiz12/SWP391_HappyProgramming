/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author admin
 */
public class Content {
    private String bin;
    private String accountNumber;
    private String accountName;
    private String amount;
    private String description;
    private String orderCode;
    private String curency;
    private String paymentLinkId;
    private String status;
    private String checkoutUrl;
    private String qrCode;
    

    public Content() {
    }

    public Content(String bin, String accountNumber, String accountName, String amount, String description, String orderCode, String curency, String paymentLinkId, String status, String checkoutUrl, String qrCode) {
        this.bin = bin;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.amount = amount;
        this.description = description;
        this.orderCode = orderCode;
        this.curency = curency;
        this.paymentLinkId = paymentLinkId;
        this.status = status;
        this.checkoutUrl = checkoutUrl;
        this.qrCode = qrCode;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCurency() {
        return curency;
    }

    public void setCurency(String curency) {
        this.curency = curency;
    }

    public String getPaymentLinkId() {
        return paymentLinkId;
    }

    public void setPaymentLinkId(String paymentLinkId) {
        this.paymentLinkId = paymentLinkId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCheckoutUrl() {
        return checkoutUrl;
    }

    public void setCheckoutUrl(String checkoutUrl) {
        this.checkoutUrl = checkoutUrl;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

        
}
