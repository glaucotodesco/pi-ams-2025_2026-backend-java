package com.fatec.horario.mappers;

import com.fatec.horario.dtos.CourseRequest;
import com.fatec.horario.dtos.CourseResponse;
import com.fatec.horario.entities.Course;

public class CourseMapper {
    
    public static Course toEntity(CourseRequest request){
        Course course = new Course();
        course.setName(request.name());
        course.setModality(request.modality());
        course.setTechnologicalAxis(request.technologicalAxis());
        course.setNumberOfComponentes(request.numberOfComponents());
        return course;
    }
    
    public static CourseResponse toResponse(Course course) {
       return new CourseResponse(
        course.getId(),
        course.getName(),
        course.getModality(),
        course.getTechnologicalAxis(),
        course.getNumberOfComponents()

       );
    }

}
