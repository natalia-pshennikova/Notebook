package Pshennikova;

import asg.cliche.Command;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Record> records = new ArrayList<>();

    @Command
    public void createPerson(String firstName, String lastName, String email, String address, String text, String... phones) {
        Person r = new Person();
        r.setFirstName(firstName);
        r.setLastName(lastName);
        r.setEmail(email);
        r.setAddress(address);
        r.setText(text);
        r.addPhones(phones);
        records.add(r);
    }
    @Command
    public void createNote(String text) {
        Note n = new Note();
        n.setText(text);
        records.add(n);
}

    @Command
    public void createReminder(String text, String time) {
        Reminder rm = new Reminder();
        rm.setText(text);
        rm.setTime(time);
        records.add(rm);
    }

    @Command
    public List<Record> list(){
        return records;
    }

    @Command
    public void remove(int id) {
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);
            if (r.getId() == id) {
                records.remove(i);
                break;
            }
        }

    }
}
