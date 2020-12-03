package edu.ale.rentofbilds.service.record.impls;

import edu.ale.rentofbilds.Repository.RecordRepository;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.service.record.interfaces.ICRUDRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceRecordMongoImpls implements ICRUDRecord {

    @Autowired
    RecordRepository repository;

    @Override
    public Record create(Record record) {
        record.setCreated_at(LocalDateTime.now());
        record.setModified_at(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public Record get(String id) {
        return null;
    }

    @Override
    public Record update(Record record) {
        return null;
    }

    @Override
    public Record delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Record> getAll() {
        return repository.findAll();
    }

    public List<Record> getAllSortedByName(){
        List<Record> list = repository.findAll();
        List<Record> sorted = list.stream()
                .sorted(Comparator.comparing(Record::getName))
                .collect(Collectors.toList());
        return sorted;
    }
}