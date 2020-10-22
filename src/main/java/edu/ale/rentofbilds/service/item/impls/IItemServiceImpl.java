package edu.ale.rentofbilds.service.item.impls;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.interfaces.ICRUDItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class IItemServiceImpl implements ICRUDItem {
    @Autowired
    FakeData data;



    @Override
    public Item create(Item item) {
        if (item.getId() != null) {
            this.getAll().add(item);
        } else {

            Integer id =
                    this.getAll().stream()
                            .map(el -> el.getId())
                            //Айдишники превращаем со Стринга в Интеджер
                            .mapToInt(el -> Integer.valueOf(el))
                            //Находим максимальный !!!
                            .max().orElse(0);

            item.setId(String.valueOf(id+1));
            LocalDateTime now = LocalDateTime.now();
            item.setCreated_at(now);
            item.setModified_at(now);
            this.getAll().add(item);
        }
        return item;
    }

    @Override
    public Item get(String id) {
        return this.getAll().stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Item update(Item item) {
        String id = item.getId();
        Item itemToUpdate = this.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(itemToUpdate);
        item.setModified_at(LocalDateTime.now());
        this.getAll().set(index, item);
        return item;
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        this.getAll().remove(item);
        return item;
    }


    @Override
    public List<Item> getAll() {
        return data.getItems();
    }
}
