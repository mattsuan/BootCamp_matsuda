package jp.co.netprotections.dto;

public class ResponseDto {

  private String responseMemberName;
  private boolean enlistedPropriety;


  public String getResponseMemberName() {
    return responseMemberName;
  }

  public void setResponseMemberName(String responseMemberName) {
    this.responseMemberName = responseMemberName;
  }

  public boolean isEnlistedPropriety() {
    return enlistedPropriety;
  }

  public void setEnlistedPropriety(boolean enlistedPropriety) {
    this.enlistedPropriety = enlistedPropriety;
  }

}
