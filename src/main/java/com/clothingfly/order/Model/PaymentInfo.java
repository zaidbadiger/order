package com.clothingfly.order.Model;

import javax.persistence.*;
@Entity
@Table(name = "payments")
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

  @Column(name = "cardHolder")
  private String cardHolder;

  @Column(name = "cardNumber")
  private String cardNumber;

  @Column(name = "expirationDate")
  private String expirationDate;

  @Column(name = "cvv")
  private String cvv;

  public PaymentInfo() {
  
  }

  public PaymentInfo(String cardHolder, String cardNumber, String expirationDate, String cvv) {
    this.cardHolder = cardHolder;
    this.cardNumber = cardNumber;
    this.expirationDate = expirationDate;
    this.cvv = cvv;
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
