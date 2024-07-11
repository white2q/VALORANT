package com.ppf.coursesellingsystembackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ppf.coursesellingsystembackend.common.BaseResponse;
import com.ppf.coursesellingsystembackend.common.DeleteRequest;
import com.ppf.coursesellingsystembackend.common.ErrorCode;
import com.ppf.coursesellingsystembackend.common.ResultUtils;
import com.ppf.coursesellingsystembackend.exception.BusinessException;
import com.ppf.coursesellingsystembackend.exception.ThrowUtils;
import com.ppf.coursesellingsystembackend.model.dto.course.CourseAddRequest;
import com.ppf.coursesellingsystembackend.model.dto.course.CourseQueryRequest;
import com.ppf.coursesellingsystembackend.model.dto.course.CourseUpdateRequest;
import com.ppf.coursesellingsystembackend.model.entity.Course;
import com.ppf.coursesellingsystembackend.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    /**
     * 创建课程
     *
     * @param courseAddRequest
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Long> addCourse(@RequestBody CourseAddRequest courseAddRequest) {
        if (courseAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Course course = new Course();
        BeanUtils.copyProperties(courseAddRequest, course);
        boolean result = courseService.save(course);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newCourseId = course.getId();
        return ResultUtils.success(newCourseId);
    }

    /**
     * 删除课程
     *
     * @param deleteRequest
     * @return
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteCourse(@RequestBody DeleteRequest deleteRequest) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long id = deleteRequest.getId();
        // 判断是否存在
        Course oldCourse = courseService.getById(id);
        ThrowUtils.throwIf(oldCourse == null, ErrorCode.NOT_FOUND_ERROR);
        boolean b = courseService.removeById(id);
        return ResultUtils.success(b);
    }

    /**
     * 更新课程信息
     *
     * @param courseUpdateRequest
     * @return
     */
    @PostMapping("/update")
    public BaseResponse<Boolean> updateCourse(@RequestBody CourseUpdateRequest courseUpdateRequest) {
        if (courseUpdateRequest == null || courseUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Course course = new Course();
        BeanUtils.copyProperties(courseUpdateRequest, course);
        // 参数校验
        long id = courseUpdateRequest.getId();
        // 判断是否存在
        Course oldCourse = courseService.getById(id);
        ThrowUtils.throwIf(oldCourse == null, ErrorCode.NOT_FOUND_ERROR);
        boolean result = courseService.updateById(course);
        return ResultUtils.success(result);
    }

    /**
     * 根据 id 获取
     *
     * @param id
     * @return
     */
    @GetMapping("/get")
    public BaseResponse<Course> getCourseById(long id, HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Course course = courseService.getById(id);
        if (course == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(course);
    }

    /**
     * 分页获取列表（封装类）
     *
     * @param courseQueryRequest
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<Course>> listCourseByPage(@RequestBody CourseQueryRequest courseQueryRequest) {
        long current = courseQueryRequest.getCurrent();
        long size = courseQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<Course> CoursePage = courseService.page(new Page<>(current, size),
                courseService.getQueryWrapper(courseQueryRequest));
        return ResultUtils.success(CoursePage);
    }
}
