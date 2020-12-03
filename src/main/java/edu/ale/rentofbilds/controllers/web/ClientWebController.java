package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.forms.ClientForm;
import edu.ale.rentofbilds.forms.SearchForm;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.service.client.impls.CRUDClientServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("web/client")
public class ClientWebController {
    @Autowired
    CRUDClientServiceMongoImpl service;
/*    List<Client> clients = Stream.of(
            new Client("0", "Alexandr Botezat", "0507072384",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("1", "Alexandr NeBotezat", "1507072384",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Client("2", "Alexandr Gotezat", "2507072384",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());*/
    @RequestMapping("/list")
    String getList(Model model){
        model.addAttribute("clients", service.getAll());
        return "clientsTable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id){
        service.delete(id);
        /*Client client = clients.stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);*/
/*        clients.remove(client);*/
        return "redirect:/web/client/list";
    }
    @RequestMapping("/edit/{id}")
    String editById(@PathVariable("id") String id, Model model){
        Client client = service.get(id);
        ClientForm form = new ClientForm();
        form.setName(client.getName());
        form.setDescription(client.getDescription());
        model.addAttribute("form", form);
        return "clientAddForm";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String editById(@ModelAttribute("form") ClientForm form,@PathVariable("id") String id, Model model){
        Client client = service.get(id);
        client.setName(form.getName());
        client.setDescription(form.getDescription());
        service.update(client);
        return "redirect:/web/client/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        ClientForm clientForm = new ClientForm();
        model.addAttribute("form", clientForm);
        return "clientAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") ClientForm form, Model model) {
       Client client = new Client();
       client.setName(form.getName());
       client.setPassport(form.getPassport());
       client.setDescription(form.getDescription());
       service.create(client);
        return "redirect:/web/client/list";
    }
    @RequestMapping(value = "/list/sort/name", method = RequestMethod.GET)
    public String sortedByName(Model model) {
        model.addAttribute("clients", service.getAllSortedByName());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "clientsTable";
    }
 @RequestMapping(value = "/list/sort/passport", method = RequestMethod.GET)
    public String sortedByPassport(Model model) {
        model.addAttribute("clients", service.getAllSortedByPassport());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "clientsTable";
    }
    @RequestMapping(value = "/list/sort/description", method = RequestMethod.GET)
    public String sortedByDescription(Model model) {
        model.addAttribute("clients", service.getAllSortedByDescription());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "clientsTable";
    }
    @RequestMapping(value = "/list/sort/created", method = RequestMethod.GET)
    public String sortedByCreated(Model model) {
        model.addAttribute("clients", service.getAllSortedByCreated());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "clientsTable";
    }
    @RequestMapping(value = "/list/sort/modified", method = RequestMethod.GET)
    public String sortedByModified(Model model) {
        model.addAttribute("clients", service.getAllSortedByModified());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "clientsTable";
    }
}
