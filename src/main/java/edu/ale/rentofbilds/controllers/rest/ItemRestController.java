package edu.ale.rentofbilds.controllers.rest;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.impls.IItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/item")

public class ItemRestController {
    @Autowired
    IItemServiceImpl service;

    @RequestMapping("/all")
    List<Item> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Item getById(@PathVariable("id") String id) {
        return service.get(id);
    }
    @RequestMapping("/delete/{id}")
    Item deleteById(@PathVariable("id") String id) {
        return service.delete(id);

    }
    @PostMapping("/create")
    Item create(@RequestBody Item item) {
        return service.create(item);
    }
    @PutMapping("/update")
       Item update(@RequestBody Item item) {
           return  service.update(item);
        }
    }



