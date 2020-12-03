package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.Repository.RecordRepository;
import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.forms.RecordForm;
import edu.ale.rentofbilds.forms.SearchForm;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.model.Room;
import edu.ale.rentofbilds.service.client.impls.CRUDClientServiceMongoImpl;
import edu.ale.rentofbilds.service.record.impls.ServiceRecordMongoImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/record")
public class RecordWebController {
    @Autowired
    ServiceRecordMongoImpls service;

    @Autowired
    CRUDClientServiceMongoImpl clientServiceMongo;

    @Autowired
    FakeData fakeData;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("records", service.getAll());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        model.addAttribute("clients", clientServiceMongo.getAll());
        return "recordsTable";
    }
    @PostMapping("/list")
    String getAll(@ModelAttribute("form") SearchForm form, Model model) {
        String name = form.getName();
        System.out.println(name);
       // model.addAttribute("Records", service.getByName(name));
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "recordsTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/record/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        List<String> clients = clientServiceMongo.getAll().stream()
                .map(Client::getName).collect(Collectors.toList());
        RecordForm recordForm = new RecordForm();
        model.addAttribute("form", recordForm);
        model.addAttribute("clients", clients);
        List<String> rooms = fakeData.getRooms().stream()
                .map(Room::getName).collect(Collectors.toList());
        model.addAttribute("rooms", rooms);
        return "recordAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") RecordForm form, Model model) {
        System.out.println(form);
        Record record = new Record();
        record.setName(form.getName());
        Room room = fakeData.getRooms().stream()
                .filter(el -> el.getName().equals(form.getRoom())).findFirst().orElse(null);
        record.setRoom(room);
        record.setStart(LocalDate.parse(form.getStart()).atTime(0,0,0));
        record.setFinish(LocalDate.parse(form.getFinish()).atTime(0,0,0));
        record.setDescription(form.getDescription());
        Client client = clientServiceMongo.getAll().stream().filter(el -> el.getName()
                .equals(form.getClient())).findFirst().orElse(null);
        record.setClient(client);
        service.create(record);
        return "redirect:/web/record/list";

    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Record record = service.get(id);
        RecordForm recordForm = new RecordForm();
        recordForm.setId(record.getId());
        recordForm.setName(record.getName());
        recordForm.setDescription(record.getDescription());
       /* recordForm.setCreated_at(record.getCreated_at().toString());
        recordForm.setModified_at(record.getModified_at().toString());*/
        model.addAttribute("form", recordForm);
        return "updateRecord";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @PathVariable("id") String id, @ModelAttribute("form") RecordForm form) {
        Record record = service.get(id);
        record.setName(form.getName());
        record.setDescription(form.getDescription());
        service.update(record);
        return "redirect:/web/record/list";
    }
    @RequestMapping(value = "/list/sort/name", method = RequestMethod.GET)
    public String sortedByName(Model model) {
        model.addAttribute("records", service.getAllSortedByName());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "recordsTable";
    }

}
