package com.sprk.one_to_one.repository;

import com.sprk.one_to_one.entity.Instructor;
import com.sprk.one_to_one.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class AppDao {


    private final EntityManager entityManager;

    @Transactional
    public Instructor saveInstructor(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Transactional
    public InstructorDetail saveInstructorDetail(InstructorDetail instructorDetail) {
        return  entityManager.merge(instructorDetail);
    }

    public Instructor getInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Transactional
    public String deleteInstructorById(int instructorId) {
        Instructor instructor = getInstructorById(instructorId);
        if(instructor != null) {
            entityManager.remove(instructor);
            entityManager.remove(instructor.getInstructorDetail());
            return "Deleted successfully";
        }else{
            return "Not Found!!";
        }

    }

//    @Transactional
//    public Instructor updateInstructorById(int instructorId, Instructor instructor) {
//
//        Instructor instructor1 = getInstructorById(instructorId);
//        InstructorDetail instructorDetail = instructor.getInstructorDetail();
//        instructorDetail.setInstructorDetailId(instructor1.getInstructorDetail().getInstructorDetailId());
//        if(instructor1 != null) {
//            InstructorDetail updaInstructorDetail =  entityManager.merge(instructorDetail);
//
//            instructor.setInstructorDetail(updaInstructorDetail);
//            Instructor updatedInstructor = entityManager.merge(instructor);
//
//            updatedInstructor.setInstructorDetail(updaInstructorDetail);
//
//            return updatedInstructor;
//
//        }else{
//            return null;
//        }
//
//    }
}
