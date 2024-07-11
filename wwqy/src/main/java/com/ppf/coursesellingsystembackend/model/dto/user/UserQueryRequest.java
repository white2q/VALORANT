package com.ppf.coursesellingsystembackend.model.dto.user;

import com.ppf.coursesellingsystembackend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 用户查询请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 已购课程id列表
     */
    private List<String> courseList;
}