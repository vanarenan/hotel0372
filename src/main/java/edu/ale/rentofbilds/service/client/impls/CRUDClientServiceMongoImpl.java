package edu.ale.rentofbilds.service.client.impls;

import edu.ale.rentofbilds.Repository.ClientRepository;
import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.client.interfaces.ICRUDClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CRUDClientServiceMongoImpl implements ICRUDClientService {

    @Autowired
    ClientRepository repository;

    @Autowired
    FakeData trash;

    List <Client> list = new ArrayList<>();

    @PostConstruct
    void init(){
        list = trash.getClients();
        repository.saveAll(list);
    }

    @Override
    public Client create(Client client) {
        /*UUID id = UUID.randomUUID();
        Client.setId(id.toString());*/
        client.setCreated_at(LocalDateTime.now());
        client.setModified_at(LocalDateTime.now());
        /*trash.getClients().add(Client);*/
        return repository.save(client);
    }

    @Override
    public Client get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Client update(Client client) {
        /*Client ClientToUpdate = this.getAll().stream().filter(el -> el.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(ClientToUpdate);*/
        client.setModified_at(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client delete(String id) {
        Client client = this.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        repository.deleteById(id);
        return client;
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    public List<Client> getAllSortedByName(){
        List<Client> list = repository.findAll();
        List<Client> sorted = list.stream()
                .sorted(Comparator.comparing(Client::getName))
                .collect(Collectors.toList());
        return sorted;
    }
  public List<Client> getAllSortedByPassport(){
        List<Client> list = repository.findAll();
        List<Client> sorted = list.stream()
                .sorted(Comparator.comparing(Client::getPassport))
                .collect(Collectors.toList());
        return sorted;
    }
    public List<Client> getAllSortedByDescription(){
        List<Client> list = repository.findAll();
        List<Client> sorted = list.stream()
                .sorted(Comparator.comparing(Client::getDescription))
                .collect(Collectors.toList());
        return sorted;
    }
    public List<Client> getAllSortedByCreated(){
        List<Client> list = repository.findAll();
        List<Client> sorted = list.stream()
                .sorted(Comparator.comparing(Client::getCreated_at))
                .collect(Collectors.toList());
        return sorted;
    }
    public List<Client> getAllSortedByModified(){
        List<Client> list = repository.findAll();
        List<Client> sorted = list.stream()
                .sorted(Comparator.comparing(Client::getModified_at))
                .collect(Collectors.toList());
        return sorted;
    }
}
