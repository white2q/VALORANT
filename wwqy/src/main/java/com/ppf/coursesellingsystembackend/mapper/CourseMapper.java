package com.ppf.coursesellingsystembackend.mapper;

import com.ppf.coursesellingsystembackend.model.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 25137
* @description 针对表【course(课程)】的数据库操作Mapper
* @createDate 2024-07-03 10:14:57
* @Entity com.ppf.coursesellingsystembackend.model.entity.Course
*/
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

}




