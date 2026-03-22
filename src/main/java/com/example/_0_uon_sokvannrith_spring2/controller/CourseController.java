package com.example._0_uon_sokvannrith_spring2.controller;
import com.example._0_uon_sokvannrith_spring2.model.entiity.Course;
import com.example._0_uon_sokvannrith_spring2.model.entiity.Instructor;
import com.example._0_uon_sokvannrith_spring2.model.request.CourseRequest;
import com.example._0_uon_sokvannrith_spring2.model.respoonse.ResponseApi;
import com.example._0_uon_sokvannrith_spring2.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {


    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
   @GetMapping
    public ResponseEntity<ResponseApi<List<Course>>> getAllCourse(){
        List<Course> course = courseService.getAllCourse();
        ResponseApi<List<Course>> getCourse= ResponseApi.<List<Course>>builder().payload(course).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(getCourse);
    }
    @GetMapping({"/{course-id}"})
    public ResponseEntity<?> getCourseById(@PathVariable("course-id") Long courseId ){
        Course course = courseService.getCourseById(courseId);
        ResponseApi<Course> responseApi=ResponseApi.<Course>builder()
                .success(true)
                .status(HttpStatus.OK)
                .message("Successfully")
                .payload(courseService.getCourseById(courseId))
                .timestamp(Instant.now())
                .build();
        if (course==null){
            ResponseApi<Course> getId=ResponseApi.<Course>builder().
                    status(HttpStatus.NOT_FOUND).
                    success(false).
                    message("Don't have data").
                    payload(course).timestamp(Instant.now()).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getId);
        }
        return ResponseEntity.ok(responseApi);
    }
    @PutMapping("/{course-id}")
    public ResponseEntity<ResponseApi<Course>> updateById(@PathVariable("course-id") Long courseId, @RequestBody CourseRequest request){
        Course course = courseService.updateById(courseId,request);
        ResponseApi<Course> update=ResponseApi.<Course>builder().
                success(true).
                status(HttpStatus.OK).
                message("update successfully ").
                payload(course).
                timestamp(Instant.now()).
                build();
        return ResponseEntity.ok(update);
    }
    @PostMapping
    public ResponseEntity<ResponseApi<List<Course>>> createCourse(@RequestBody CourseRequest request){
        Course course = courseService.createCourse(request);
        ResponseApi<List<Course>> createNewData = ResponseApi.<List<Course>>builder().build();
        return ResponseEntity.ok(createNewData);
    }
    @DeleteMapping("/{course_id}")
    public ResponseEntity<ResponseApi<Course>> DeleteCourseById(@PathVariable("course_id") Long courseId) {
        Course delCourse = courseService.deleteCourseById(courseId);
        if (delCourse == null) {
            ResponseApi<Course> responseApi = ResponseApi.<Course>builder().success(false).status(HttpStatus.NOT_FOUND).message("Don't has data ").payload(delCourse).timestamp(Instant.now()).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseApi);
        }
        ResponseApi<Course> responseApi = ResponseApi.<Course>builder().success(true).status(HttpStatus.OK).message("SuccessFully").payload(delCourse).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }
}
