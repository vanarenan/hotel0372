package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.forms.ItemForm;
import edu.ale.rentofbilds.forms.SearchForm;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.impls.CRUDItemIMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/item")
public class ItemWebController {
    @Autowired
    CRUDItemIMongoImpl service;

    @RequestMapping("/all")
    String getAll(Model model) {
        model.addAttribute("items", service.getAll());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
    @PostMapping("/all")
    String getAll(@ModelAttribute("form") SearchForm form, Model model) {
        String name = form.getName();
        System.out.println(name);
        model.addAttribute("items", service.getByName(name));
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
       /* Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        service.getAll().remove(item);*/
        service.delete(id);
        return "redirect:/web/item/all";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        ItemForm itemForm = new ItemForm();
        model.addAttribute("form", itemForm);
        return "itemAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") ItemForm form, Model model) {
        System.out.println(form);
        Item item = new Item();
        item.setName(form.getName());
        item.setType(form.getType());
        item.setPrice(form.getPrice());
        item.setCapacity(form.getCapacity());
        item.setReservation(form.getReservation());
        service.create(item);
        return "redirect:/web/item/all";

    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Item item = service.get(id);
        ItemForm itemForm = new ItemForm();
        itemForm.setId(item.getId());
        itemForm.setName(item.getName());
        itemForm.setReservation(item.getReservation());
        itemForm.setCreated_at(item.getCreated_at().toString());
        itemForm.setModified_at(item.getModified_at().toString());
        model.addAttribute("form", itemForm);
        return "updateItem";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @PathVariable("id") String id, @ModelAttribute("form") ItemForm form) {
        Item item = service.get(id);
        item.setName(form.getName());
        item.setReservation(form.getReservation());
        service.update(item);
        return "redirect:/web/item/all";
    }
    @RequestMapping(value = "/all/sort/name", method = RequestMethod.GET)
    public String sortedByName(Model model) {
        model.addAttribute("items", service.getAllSortedByName());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
    @RequestMapping(value = "/all/sort/price", method = RequestMethod.GET)
    public String sortedByPrice(Model model) {
        model.addAttribute("items", service.getAllSortedByPrice());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
    @RequestMapping(value = "/all/sort/capacity", method = RequestMethod.GET)
    public String sortedByСapacity(Model model) {
        model.addAttribute("items", service.getAllSortedByCapacity());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
 @RequestMapping(value = "/all/sort/type", method = RequestMethod.GET)
    public String sortedByType(Model model) {
        model.addAttribute("items", service.getAllSortedByType());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
    @RequestMapping(value = "/all/sort/reservation", method = RequestMethod.GET)
    public String sortedByReservation(Model model) {
        model.addAttribute("items", service.getAllSortedByReservation());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
    @RequestMapping(value = "/all/sort/created", method = RequestMethod.GET)
    public String sortedByCreated(Model model) {
        model.addAttribute("items", service.getAllSortedByCreated());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
    @RequestMapping(value = "/all/sort/modified", method = RequestMethod.GET)
    public String sortedByModified(Model model) {
        model.addAttribute("items", service.getAllSortedByModified());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
}
