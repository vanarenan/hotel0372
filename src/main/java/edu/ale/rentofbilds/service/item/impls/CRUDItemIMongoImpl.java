package edu.ale.rentofbilds.service.item.impls;

import edu.ale.rentofbilds.Repository.ItemRepository;
import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.interfaces.ICRUDItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CRUDItemIMongoImpl implements ICRUDItem {

    @Autowired
    FakeData data;

    @Autowired
    ItemRepository repository;

    private List<Item> list = new ArrayList<>();


   @PostConstruct
    void init(){
        list = data.getItems();
    repository.saveAll(list);
    }

    @Override
    public Item create(Item item) {
        item.setCreated_at(LocalDateTime.now());
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Item get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Item update(Item item) {
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        repository.deleteById(id);
        return item;
    }

    @Override
    public List<Item> getAll() {

        return repository.findAll();
    }
    public List<Item> getAllSortedByName(){
        List<Item> list = repository.findAll();
        List<Item> sorted = list.stream()
                .sorted(Comparator.comparing(Item::getName))
                .collect(Collectors.toList());
        return sorted;
    }
   public List<Item> getAllSortedByPrice(){
        List<Item> list = repository.findAll();
        List<Item> sorted = list.stream()
                .sorted(Comparator.comparing(Item::getPrice))
                .collect(Collectors.toList());
        return sorted;
    }
   public List<Item> getAllSortedByCapacity(){
        List<Item> list = repository.findAll();
        List<Item> sorted = list.stream()
                .sorted(Comparator.comparing(Item::getCapacity))
                .collect(Collectors.toList());
        return sorted;
    }
   public List<Item> getAllSortedByType(){
        List<Item> list = repository.findAll();
        List<Item> sorted = list.stream()
                .sorted(Comparator.comparing(Item::getType))
                .collect(Collectors.toList());
        return sorted;
    }
    public List<Item> getAllSortedByReservation(){
        List<Item> list = repository.findAll();
        List<Item> sorted = list.stream()
                .sorted(Comparator.comparing(Item::getReservation))
                .collect(Collectors.toList());
        return sorted;
    }
    public List<Item> getAllSortedByCreated(){
        List<Item> list = repository.findAll();
        List<Item> sorted = list.stream()
                .sorted(Comparator.comparing(Item::getCreated_at))
                .collect(Collectors.toList());
        return sorted;
    }
    public List<Item> getAllSortedByModified(){
        List<Item> list = repository.findAll();
        List<Item> sorted = list.stream()
                .sorted(Comparator.comparing(Item::getModified_at))
                .collect(Collectors.toList());
        return sorted;
    }

    public List<Item> getByName(String name) {
        if (name.equals(""))return  this.getAll();
        return this.getAll().stream().filter(item -> item.getName().contains(name)).collect(Collectors.toList());
    }
}
