package com.example.model;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

@Alias("Country")
public class Country implements Serializable {

  private Long id;
  private String countryName;
  private String countryCode;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  @Override
  public String toString() {
    return "Country{" +
        "id=" + id +
        ", countryName='" + countryName + '\'' +
        ", countryCode='" + countryCode + '\'' +
        '}';
  }
}
