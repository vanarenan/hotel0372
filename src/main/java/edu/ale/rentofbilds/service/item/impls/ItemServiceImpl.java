package edu.ale.rentofbilds.service.item.impls;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.interfaces.ICRUDItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ICRUDItem {
    @Autowired
    FakeData data;

    @Override



    public Item create(Item item) {
        System.out.println(item);
        if (item.getId() != null) {

            this.getAll().add(item);
        }else {//берем список всех айтемов и превращаем в стринг
            Integer id = this.getAll().stream().map(element-> element.getId())
                    .mapToInt(element -> Integer.valueOf(element)).max().orElse(0);

            item.setId(String.valueOf(++id));// и опять превращаем в стринг
            //єтот функционал проверяем список на предмет АЙДИ - тотом конвертировали в ИНТ и проверили есть ли у нас максимальній? если да - то новій сетАйди получает +1!
            //если список пуст то предаем значение 0 - а потом +1
            item.setCreated_at(LocalDateTime.now());
            item.setModified_at(LocalDateTime.now());
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
        Item itemToUpdate = this.getAll().stream().filter(el -> el.getId().equals(id))
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