package com.fgchain.main.module.background.zone.system.dto;

import com.fgchain.main.common.BaseDto;

import java.util.Date;

/**
 * @ClassName UserDto
 * @Description
 * @Author jiangxy
 * @Date 2018\11\16 0016 15:38
 * @Version 1.0.0
 */
public class UserDto extends BaseDto {

    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
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
        this.userEmail = userEmail;
    }

    public String getUserQqNumber() {
        return userQqNumber;
    }

    public void setUserQqNumber(String userQqNumber) {
        this.userQqNumber = userQqNumber;
    }

    public String getUserWechatAccountName() {
        return userWechatAccountName;
    }

    public void setUserWechatAccountName(String userWechatAccountName) {
        this.userWechatAccountName = userWechatAccountName;
    }

    public String getUserHeadIconUrl() {
        return userHeadIconUrl;
    }

    public void setUserHeadIconUrl(String userHeadIconUrl) {
        this.userHeadIconUrl = userHeadIconUrl;
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
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

