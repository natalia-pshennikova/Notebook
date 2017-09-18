package Pshennikova;

import asg.cliche.Command;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Record> records = new ArrayList<>();

    @Command
    public void create(String firstName, String lastName, String email, String address, String... phones) {
        Record r = new Record();
        r.setFirstName(firstName);
        r.setLastName(lastName);
        r.setEmail(email);
        r.setAddress(address);
        r.setPhones(phones);
        records.add(r);
    }

    @Command
    public List<Record> list(){
        return records;
    }

    @Command
    public void remove(int id) {
        for (int i = 0; i < records.size(); i++) { // цикл по всем индексам
            Record r = records.get(i);     // берем запись по текущему индексу
            if (r.getId() == id) {         // если у записи айдишка совпадает с искомой
                records.remove(i);         // удаляем по индексу
                break;                     // заканчиваем цикл досрочно
            }
        }

    }
}
