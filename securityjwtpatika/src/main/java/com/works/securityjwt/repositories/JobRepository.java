package com.works.securityjwt.repositories;

import com.works.securityjwt.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
