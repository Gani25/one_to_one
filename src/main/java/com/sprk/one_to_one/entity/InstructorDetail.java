package com.sprk.one_to_one.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class InstructorDetail {

    /*
    * ALTER TABLE instructor_details AUTO_INCREMENT = 1001;
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instructorDetailId;

    private String hobby;

    private String qualification;
}
