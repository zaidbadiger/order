package com.clothingfly.order.Model;

import javax.persistence.*;

@Entity
public class PaymentChase {
    
    @Id
    @GeneratedValue
    @Column
    private long Id;
    @Column
    private String business;
    @Column
    private String accountNum;
    @Column
    private String cardHolder;
    @Column
    private String cardNumber;
    @Column
    private String expirationDate;
    @Column
    private String cvv;

    public PaymentChase(String business, String accountNum, String customerName, String creditCardNum, String expDate,
            String cvv) {
        this.business = business;
        this.accountNum = accountNum;
        this.cardHolder = customerName;
        this.cardNumber = creditCardNum;
        this.expirationDate = expDate;
        this.cvv = cvv;
    }
    public PaymentChase(){

    }
    public String getBusiness() {
        return business;
    }
    public void setBusiness(String business) {
        this.business = business;
    }
    public String getAccountNum() {
        return accountNum;
    }
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    public String getCardHolder() {
        return cardHolder;
    }
    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    
}
