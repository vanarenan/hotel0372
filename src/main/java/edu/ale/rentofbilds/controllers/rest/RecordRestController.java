package edu.ale.rentofbilds.controllers.rest;

import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.service.record.impls.ServiceRecordMongoImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/record")
public class RecordRestController {
    @Autowired
    ServiceRecordMongoImpls service;

    @RequestMapping("/all")
    List<Record> getAll() {
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Record deleteById(@PathVariable("id") String id) {
        return service.delete(id); }
}