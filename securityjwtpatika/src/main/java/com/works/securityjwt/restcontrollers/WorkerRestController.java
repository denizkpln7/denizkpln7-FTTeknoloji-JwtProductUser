package com.works.securityjwt.restcontrollers;


import com.works.securityjwt.entities.Job;
import com.works.securityjwt.entities.Worker;
import com.works.securityjwt.services.WorkerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/worker")
public class WorkerRestController {

    private WorkerService workerService;


    public WorkerRestController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("/post")
    public ResponseEntity post(@Valid @RequestBody Worker workers){
        return workerService.post(workers);
    }

    @PostMapping("/job")
    public ResponseEntity post(@RequestBody Job job){
        return  workerService.job(job);
    }

    @GetMapping("/workerList")
    public ResponseEntity getList(@RequestParam Long id){
        return  workerService.getList(id);
    }
}
