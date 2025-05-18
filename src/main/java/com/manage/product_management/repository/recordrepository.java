package com.manage.product_management.repository;

import com.manage.product_management.model.RecordTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
//@Component
public interface recordrepository extends JpaRepository<RecordTable, Long> {
    RecordTable findByTrackId(String trackId);
    RecordTable findByCompNameAndTrackId(String compName, String trackId);
}
