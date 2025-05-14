package com.manage.product_management.repository;

import com.manage.product_management.model.RecordTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface recordrepository extends JpaRepository<RecordTable, Long> {
    RecordTable findByTrack_id(String track_id);
}
