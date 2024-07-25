package com.codiub.hr_worker.resource;

import com.codiub.hr_worker.entity.Worker;
import com.codiub.hr_worker.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;


    @GetMapping(value = "/configs")
    public ResponseEntity<Void> configs() {
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Worker>> findById(@PathVariable Long id) {

        logger.info("PORT = " + env.getProperty("local.server.port"));

        return ResponseEntity.ok(repository.findById(id));

    }
}

