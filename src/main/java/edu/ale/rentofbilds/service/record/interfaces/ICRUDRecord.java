package edu.ale.rentofbilds.service.record.interfaces;

import edu.ale.rentofbilds.model.Record;

import java.util.List;

public interface ICRUDRecord {
    Record create(Record record);
    Record get(String id);
    Record update(Record record);
    Record delete(String id);

    List<Record> getAll();
}
