package com.fgchain.main.module.front.login.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userNickName;

    private Integer userAge;

    private Integer userGender;

    private Date userBirth;

    private String userEmail;

    private String userQqNumber;

    private String userWechatAccountName;

    private String userHeadIconUrl;

    private String userIntroduce;

    private Integer userAccountState;

    private Date userRegistDate;

    private Date userUpdateDate;

    private Date userLastLoginDate;

    private Date userLastLogoutDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName == null ? null : userNickName.trim();
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserQqNumber() {
        return userQqNumber;
    }

    public void setUserQqNumber(String userQqNumber) {
        this.userQqNumber = userQqNumber == null ? null : userQqNumber.trim();
    }

    public String getUserWechatAccountName() {
        return userWechatAccountName;
    }

    public void setUserWechatAccountName(String userWechatAccountName) {
        this.userWechatAccountName = userWechatAccountName == null ? null : userWechatAccountName.trim();
    }

    public String getUserHeadIconUrl() {
        return userHeadIconUrl;
    }

    public void setUserHeadIconUrl(String userHeadIconUrl) {
        this.userHeadIconUrl = userHeadIconUrl == null ? null : userHeadIconUrl.trim();
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce == null ? null : userIntroduce.trim();
    }

    public Integer getUserAccountState() {
        return userAccountState;
    }

    public void setUserAccountState(Integer userAccountState) {
        this.userAccountState = userAccountState;
    }

    public Date getUserRegistDate() {
        return userRegistDate;
    }

    public void setUserRegistDate(Date userRegistDate) {
        this.userRegistDate = userRegistDate;
    }

    public Date getUserUpdateDate() {
        return userUpdateDate;
    }

    public void setUserUpdateDate(Date userUpdateDate) {
        this.userUpdateDate = userUpdateDate;
    }

    public Date getUserLastLoginDate() {
        return userLastLoginDate;
    }

    public void setUserLastLoginDate(Date userLastLoginDate) {
        this.userLastLoginDate = userLastLoginDate;
    }

    public Date getUserLastLogoutDate() {
        return userLastLogoutDate;
    }

    public void setUserLastLogoutDate(Date userLastLogoutDate) {
        this.userLastLogoutDate = userLastLogoutDate;
    }
}