package com.manage.product_management.controller;

import com.manage.product_management.model.LoginTable;
import com.manage.product_management.repository.recordrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.manage.product_management.model.RecordTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RecordController {

    private static final Logger logger = LogManager.getLogger(AdminController.class);

    @Autowired
    private recordrepository recordrep;

//    @GetMapping("/getrecords")
//    public List<RecordTable> getRecords(@RequestBody String track)
//    {
//
//        return ;
//    }

    @GetMapping("/record")
    public ResponseEntity<RecordTable> getRecordData(@RequestParam String track_id) {

        RecordTable record = recordrep.findByTrackId(track_id);

        if(record==null)
        {
            logger.error("Record does not exist");
            return ResponseEntity.badRequest().body(null);
        }
//Hello Rohan Sir
        String cmp = record.getCompName();
        System.out.println(cmp);
        logger.info("Record Found");
        return ResponseEntity.ok().body(record);
    }
    @DeleteMapping("/deleterecord/{track_id}")
    public Boolean deleteRecord(@PathVariable String  track_id)
    {
        RecordTable record=recordrep.findByTrackId(track_id);
        if(record==null)
        {
            logger.error("Record does not exist");
            return false;
        }
        else
        {
            logger.info("Record Found and successfully deleted");
            recordrep.delete(record);
            return true;
        }
    }

    @PostMapping("/addrecord")
    public RecordTable addrecord(@RequestBody RecordTable record)
    {
        if(record==null)
        {
            logger.error("null input...");
        }
        logger.info("Record added to the database successfully "+ record);
        recordrep.saveAndFlush(record);
        return record;
    }




//    @PostMapping("/updaterecord")
//    public RecordTable updateRecord(@RequestBody RecordTable record)
//    {
//        //recordrep.
//        return record;
//    }
    @GetMapping("/viewrecords")
    public List<RecordTable> getAllAdmins()
    {
        logger.info("Getting the list and sending to the frontend");
        return recordrep.findAll();
    }

}
