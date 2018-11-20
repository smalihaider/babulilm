package com.babulilm.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babulilm.webapp.dao.EventDao;

@Repository
public interface EventRepository extends JpaRepository<EventDao, Long> {

}
