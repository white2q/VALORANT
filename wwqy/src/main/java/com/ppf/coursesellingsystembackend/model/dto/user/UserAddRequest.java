package com.ppf.coursesellingsystembackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class UserAddRequest implements Serializable {
    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 余额
     */
    private Double money;

    /**
     * 已购课程id列表
     */
    private List<String> courseList;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;
}