package com.allyson.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allyson.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {}