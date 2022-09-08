package com.works.securityjwt.repositories;

import com.works.securityjwt.entities.Worker;
import com.works.securityjwt.entities.WorkerJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    Optional<Worker> findByNameContains(String name);



}
