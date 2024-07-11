package com.ppf.coursesellingsystembackend.model.dto.course;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseAddRequest implements Serializable {
    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程链接地址
     */
    private String url;

    /**
     * 课程标价
     */
    private Double value;

    /**
     * 课程类型 0-其他 1-计算机 2-数学 3-语文 4-英语 5-物理 6-艺术
     */
    private Integer type;

    /**
     * 课程介绍
     */
    private String profile;

    /**
     * 课程封面地址
     */
    private String imgUrl;

    /**
     * 课程主讲人
     */
    private String founder;
}