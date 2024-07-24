package com.codiub.hr_worker.repository;

import com.codiub.hr_worker.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
