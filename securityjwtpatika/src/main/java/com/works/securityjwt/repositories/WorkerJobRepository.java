package com.works.securityjwt.repositories;

import com.works.securityjwt.entities.WorkerJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerJobRepository extends JpaRepository<WorkerJob,Integer> {
    @Query(value ="SELECT w.id,w.name,w.surname,w.age,j.job FROM JOB as j INNER JOIN WORKER as w on j.jid=w.jid WHERE w.jid=1" ,  nativeQuery = true)
    List<WorkerJob> workerList(Long id);

}
