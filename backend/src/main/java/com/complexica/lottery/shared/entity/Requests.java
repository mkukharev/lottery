package com.complexica.lottery.shared.entity;

public class Requests {
  public static class NewNumberRequest {
    private Long userId;

    public Long getUserId() {
      return userId;
    }

    public void setUserId(Long userId) {
      this.userId = userId;
    }
  }

  public static class LoginRequest {
    private String userName;

    public String getUserName() {
      return userName;
    }

    public void setUserName(String userName) {
      this.userName = userName;
    }
  }
}
