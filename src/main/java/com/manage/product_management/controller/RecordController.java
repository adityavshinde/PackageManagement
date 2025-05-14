package com.manage.product_management.controller;

import com.manage.product_management.model.LoginTable;
import com.manage.product_management.repository.recordrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.manage.product_management.model.RecordTable;

import java.awt.*;
import java.util.List;

@RequestMapping
public class RecordController {
    @Autowired
    private recordrepository recordrep;

//    @GetMapping("/getrecords")
//    public List<RecordTable> getRecords(@RequestBody String track)
//    {
//
//        return ;
//    }

    @GetMapping("/record/{track_id}")
    public ResponseEntity<RecordTable> getRecordData(@PathVariable String track_id) {

        RecordTable record = recordrep.findByTrack_id(track_id);

        String cmp = record.getComp_name();
        System.out.println(cmp);

        return ResponseEntity.ok().body(record);
    }
    @PostMapping("/deleterecord")
    public Boolean deleteRecord(@PathVariable String  track_id)
    {
        RecordTable record=recordrep.findByTrack_id(track_id);
        if(record==null)
        {
            return false;
        }
        else
        {
            recordrep.delete(record);
            return true;
        }

    }

    @PostMapping("/addrecord")
    public RecordTable addrecord(@RequestBody RecordTable record)
    {
        recordrep.saveAndFlush(record);
        return record;
    }
//
//    @PostMapping("/updaterecord")
//    public RecordTable updateRecord(@RequestBody RecordTable record)
//    {
//        //recordrep.
//        return record;
//    }
    @GetMapping("/viewrecords")
    public List<RecordTable> getAllAdmins()
    {
        return recordrep.findAll();
    }

}
