package com.ppf.coursesellingsystembackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ppf.coursesellingsystembackend.model.dto.course.CourseQueryRequest;
import com.ppf.coursesellingsystembackend.model.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author 25137
* @description 针对表【course(课程)】的数据库操作Service
* @createDate 2024-07-03 10:14:57
*/
public interface CourseService extends IService<Course> {

    /**
     * 获取查询条件
     *
     * @param course
     * @return
     */
    QueryWrapper<Course> getQueryWrapper(CourseQueryRequest course);
}
