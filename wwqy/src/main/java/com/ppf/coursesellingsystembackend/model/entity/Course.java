package com.ppf.coursesellingsystembackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 课程
 * @TableName course
 */
@TableName(value ="course")
@Data
public class Course implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

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

    /**
     * 已购人数
     */
    private Integer num;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}