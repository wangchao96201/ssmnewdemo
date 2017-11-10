package com.pojo;

/**
 * Author:   wangchao
 * Version：
 * Date:     2017/11/9
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * --------------------------------------------------------------
 * Why & What is modified:
 */
public class User {
    private Long id;
    private String userName;
    private String userPhone;
    private String userEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
