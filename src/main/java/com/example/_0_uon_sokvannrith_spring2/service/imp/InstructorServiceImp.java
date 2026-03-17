package com.example._0_uon_sokvannrith_spring2.service.imp;

import com.example._0_uon_sokvannrith_spring2.model.entiity.Instructor;
import com.example._0_uon_sokvannrith_spring2.repository.InstructorRepository;
import com.example._0_uon_sokvannrith_spring2.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImp implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImp(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.getAllInstructors();
    }
}
