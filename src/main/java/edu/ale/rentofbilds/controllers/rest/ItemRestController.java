package edu.ale.rentofbilds.controllers.rest;

import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.impls.CRUDItemIMongoImpl;
import edu.ale.rentofbilds.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {
    @Autowired
    CRUDItemIMongoImpl service;

    @RequestMapping("/all")
    List<Item> getAll() {
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Item deleteById(@PathVariable("id") String id) {
        return service.delete(id); }
}