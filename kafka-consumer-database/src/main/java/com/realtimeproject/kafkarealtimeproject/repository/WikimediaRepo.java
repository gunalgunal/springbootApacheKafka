package com.realtimeproject.kafkarealtimeproject.repository;

import com.realtimeproject.kafkarealtimeproject.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepo extends JpaRepository<WikimediaData,Long> {
}
