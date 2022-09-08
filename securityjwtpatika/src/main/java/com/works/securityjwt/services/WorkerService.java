package com.works.securityjwt.services;

;
import com.works.securityjwt.entities.Job;
import com.works.securityjwt.entities.Worker;
import com.works.securityjwt.repositories.JobRepository;
import com.works.securityjwt.repositories.WorkerJobRepository;
import com.works.securityjwt.repositories.WorkerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class WorkerService {

    private WorkerRepository workerRepository;
    private JobRepository jobRepository;

    private WorkerJobRepository workerJobRepository;

    public WorkerService(WorkerRepository workerRepository, JobRepository jobRepository, WorkerJobRepository workerJobRepository) {
        this.workerRepository = workerRepository;
        this.jobRepository = jobRepository;
        this.workerJobRepository = workerJobRepository;
    }

    public ResponseEntity post(Worker workers) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Optional<Worker> opWorker=workerRepository.findByNameContains(workers.getName());
        if (opWorker.isPresent()){
            hm.put("status", false);
            hm.put("result", "kulanıcı var");
        }else {
            workerRepository.save(workers);
            hm.put("status", true);
            hm.put("result", workers);
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity job(Job job) {
        Map<String, Object> hm = new LinkedHashMap<>();
        jobRepository.save(job);
        hm.put("status", true);
        hm.put("result", job);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getList(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", workerJobRepository.workerList(id));
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
