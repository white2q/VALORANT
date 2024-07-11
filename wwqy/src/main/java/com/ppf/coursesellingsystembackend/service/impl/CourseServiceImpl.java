package com.ppf.coursesellingsystembackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ppf.coursesellingsystembackend.constant.CommonConstant;
import com.ppf.coursesellingsystembackend.mapper.CourseMapper;
import com.ppf.coursesellingsystembackend.model.dto.course.CourseQueryRequest;
import com.ppf.coursesellingsystembackend.model.entity.Course;
import com.ppf.coursesellingsystembackend.service.CourseService;
import com.ppf.coursesellingsystembackend.utils.SqlUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


/**
* @author 25137
* @description 针对表【course(课程)】的数据库操作Service实现
* @createDate 2024-07-03 10:14:57
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{
    /**
     * 获取查询包装类
     *
     * @param course
     * @return
     */
    @Override
    public QueryWrapper<Course> getQueryWrapper(CourseQueryRequest course) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        if (course == null) {
            return queryWrapper;
        }
        String courseName = course.getCourseName();
        Integer type = course.getType();
        String profile = course.getProfile();
        String founder = course.getFounder();
        String sortField = course.getSortField();
        String sortOrder = course.getSortOrder();

        // 拼接查询条件
        queryWrapper.like(StringUtils.isNotBlank(courseName), "courseName", courseName);
        queryWrapper.like(StringUtils.isNotBlank(profile), "profile", profile);
        queryWrapper.like(ObjectUtils.isNotEmpty(type), "type", type);
        queryWrapper.like(StringUtils.isNotBlank(founder), "founder", founder);
        queryWrapper.eq("isDelete", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }
}




