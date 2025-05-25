package com.manage.product_management.controller;

import com.manage.product_management.model.RecordTable;
import com.manage.product_management.repository.recordrepository;
import com.manage.product_management.service.EmailService; // <-- 1. IMPORT ADD KIYA
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RecordController {

    private static final Logger logger = LogManager.getLogger(AdminController.class);

    @Autowired
    private recordrepository recordrep;

    @Autowired
    private EmailService emailService; // <-- 2. EMAIL SERVICE ADD KIYA

    @GetMapping("/record")
    public ResponseEntity<RecordTable> getRecordData(@RequestParam String trackId) {

        System.out.println(trackId);
        RecordTable record = recordrep.findByTrackId(trackId);

        if (record == null) {
            logger.error("Record does not exist");
            return ResponseEntity.badRequest().body(null);
        }
        String cmp = record.getCompName();
        System.out.println(cmp);
        logger.info("Record Found");
        return ResponseEntity.ok().body(record);
    }

    @DeleteMapping("/deleterecord/{trackId}") // Changed {track_id} to {trackId} to match variable name
    public Boolean deleteRecord(@PathVariable String trackId) {
        System.out.println(trackId);
        RecordTable record = recordrep.findByTrackId(trackId);
        if (record == null) {
            logger.error("Record does not exist");
            return false;
        } else {
            logger.info("Record Found and successfully deleted");
            recordrep.delete(record);
            return true;
        }
    }

    @PostMapping("/addrecord")
    public RecordTable addrecord(@RequestBody RecordTable record) {
        if (record == null) {
            logger.error("null input...");
        }
        logger.info("Record added to the database successfully " + record);
        recordrep.saveAndFlush(record);

        // --- 3. EMAIL BHEJNE KA LOGIC YAHAN ADD KIYA ---
        this.emailService.sendNewParcelNotification(record);

        return record;
    }

    @GetMapping("/viewrecords")
    public List<RecordTable> getAllRecords() { // Renamed method for clarity
        logger.info("Getting the list and sending to the frontend");
        return recordrep.findAll();
    }
}