package com.works.securityjwt.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class WorkerJob {

    @Id
    private Integer id;
    private String name;
    private String surname;
    private int age ;
    private String job;



}
