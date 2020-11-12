package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.forms.ItemForm;
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
        // rest возращает JASON
    String getAll(Model model) {
        model.addAttribute("items", service.getAll());
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
        item.setDescription(form.getDescription());
        service.create(item);
        return "redirect:/web/item/all";

    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Item item = service.get(id);
        ItemForm itemForm = new ItemForm();
        itemForm.setId(item.getId());
        itemForm.setName(item.getName());
        itemForm.setDescription(item.getDescription());
        itemForm.setCreated_at(item.getCreated_at().toString());
        itemForm.setModified_at(item.getModified_at().toString());
        model.addAttribute("form", itemForm);
        return "updateItem";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @PathVariable("id") String id, @ModelAttribute("form") ItemForm form) {
        Item item = service.get(id);
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.update(item);
        return "redirect:/web/item/all";
    }
    @RequestMapping(value = "/all/sort/name", method = RequestMethod.GET)
    public String sortedByName(Model model) {
        model.addAttribute("items", service.getAllSortedByName());
        return "itemsTable";
    }
    @RequestMapping(value = "/all/sort/description", method = RequestMethod.GET)
    public String sortedByDescription(Model model) {
        model.addAttribute("items", service.getAllSortedByDescription());
        return "itemsTable";
    }
    @RequestMapping(value = "/all/sort/created", method = RequestMethod.GET)
    public String sortedByCreated(Model model) {
        model.addAttribute("items", service.getAllSortedByCreated());
        return "itemsTable";
    }
    @RequestMapping(value = "/all/sort/modified", method = RequestMethod.GET)
    public String sortedByModified(Model model) {
        model.addAttribute("items", service.getAllSortedByModified());
        return "itemsTable";
    }
}
