package com.babulilm.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babulilm.webapp.dao.SpeakerDao;

@Repository
public interface SpeakerRepository extends JpaRepository<SpeakerDao, Long> {

}
