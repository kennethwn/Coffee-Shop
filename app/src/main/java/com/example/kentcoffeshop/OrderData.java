package com.example.kentcoffeshop;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderData implements Serializable {
  private String name;
  private String order;
  private String sugarLevel;
  private String iceLevel;
  private String payment;

  public static ArrayList<OrderData> orderDataList = new ArrayList<OrderData>();


  public OrderData(String name, String order, String sugarLevel, String iceLevel) {
    this.name = name;
    this.order = order;
    this.sugarLevel = sugarLevel;
    this.iceLevel = iceLevel;
    this.payment = "Belum Lunas";
  }

  public static ArrayList<OrderData> getOrderDataList() {
    return orderDataList;
  }

  public static void setData(OrderData orderData) {
    orderDataList.add(orderData);
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public String getSugarLevel() {
    return sugarLevel;
  }

  public void setSugarLevel(String sugarLevel) {
    this.sugarLevel = sugarLevel;
  }

  public String getIceLevel() {
    return iceLevel;
  }

  public void setIceLevel(String iceLevel) {
    this.iceLevel = iceLevel;
  }

  public String getPayment() {
    return payment;
  }

  public void setPayment(String payment) {
    this.payment = payment;
  }
}
