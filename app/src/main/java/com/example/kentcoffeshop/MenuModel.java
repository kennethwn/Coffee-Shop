package com.example.kentcoffeshop;

public class MenuModel {
  private String coffeeTitle;
  private String coffeeNotes;
  private Double coffeePrice;

  public MenuModel(String coffeeTitle, String coffeeNotes, Double coffeePrice) {
    setCoffeeTitle(coffeeTitle);
    setCoffeeNotes(coffeeNotes);
    setCoffeePrice(coffeePrice);
  }


  public String getCoffeeTitle() {
    return coffeeTitle;
  }

  public void setCoffeeTitle(String coffeeTitle) {
    this.coffeeTitle = coffeeTitle;
  }

  public String getCoffeeNotes() {
    return coffeeNotes;
  }

  public void setCoffeeNotes(String coffeeNotes) {
    this.coffeeNotes = coffeeNotes;
  }

  public Double getCoffeePrice() {
    return coffeePrice;
  }

  public void setCoffeePrice(Double coffeePrice) {
    this.coffeePrice = coffeePrice;
  }
}
