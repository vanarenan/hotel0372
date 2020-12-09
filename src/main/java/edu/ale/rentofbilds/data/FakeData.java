package edu.ale.rentofbilds.data;

import edu.ale.rentofbilds.Repository.RecordRepository;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class FakeData {

    @Autowired
    RecordRepository recordRepository;

    private List<Room> rooms = Stream.of(
            new Room("1", "Room 1", "Lucs", LocalDateTime.now(), LocalDateTime.now()),
            new Room("2", "Room 2", "Lucs", LocalDateTime.now(), LocalDateTime.now()),
            new Room("3", "Room 3", "Lucs", LocalDateTime.now(), LocalDateTime.now()),
            new Room("4", "Room 4", "Lucs", LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    private List<Item> items = Stream.of(
            new Item("1", "1", "600", "1", "regular", "01.12.20 - 03.12.20",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("2", "2", "1500", "2", "Lux", "02.12.20 - 03.12.20",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("3", "3", "900", "2", "regular", "30.12.20 - 03.01.21",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    public RecordRepository getRecordRepository() {
        return recordRepository;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Record> getRecords() {
        return records;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    List<Client> clients = Stream.of(
            new Client("0", "Alexandr Botezat", "KT198909CE", "0507072384",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("1", "George Light", "KT905203CE","0505072584",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("2", "Viktor Crawez", "KT2004913CE","066838473",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    private List<Record> records = Stream.of(
            new Record("1", "rec1", "desc1", LocalDate.now(), LocalDate.now(), clients.get(0), rooms.get(0), LocalDateTime.now(), LocalDateTime.now()),
            new Record("2", "rec1", "desc1", LocalDate.now(), LocalDate.now(), clients.get(0), rooms.get(0), LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    public List<Client> getClients() {
        return clients;
    }

  //  @PostConstruct
    void init(){
        recordRepository.saveAll(records);
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }


}
