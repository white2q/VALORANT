package com.ppf.coursesellingsystembackend.model.dto.course;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ppf.coursesellingsystembackend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Data
public class CourseQueryRequest extends PageRequest implements Serializable {
    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程类型 0-其他 1-计算机 2-数学 3-语文 4-英语 5-物理 6-艺术
     */
    private Integer type;

    /**
     * 课程介绍
     */
    private String profile;

    /**
     * 课程主讲人
     */
    private String founder;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}