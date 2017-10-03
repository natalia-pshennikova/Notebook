package Pshennikova;

import asg.cliche.Command;
import asg.cliche.Param;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private List<Record> records = new ArrayList<>();

    @Command
    public void createPerson(@Param(name = "firstName") String firstName,
                             @Param(name = "lastName") String lastName,
                             @Param(name = "email") String email,
                             @Param(name = "address") String address,
                             @Param(name = "note") String note,
                             @Param(name = "phones") String... phones) {
        Person r = new Person();
        r.setFirstName(firstName);
        r.setLastName(lastName);
        r.setEmail(email);
        r.setAddress(address);
        r.setText(note);
        r.addPhones(phones);
        records.add(r);
    }

    @Command
    public void createNote(@Param(name = "text") String text) {
        Note n = new Note();
        n.setText(text);
        records.add(n);
    }

    @Command
    public void createAlarm(@Param(name = "text") String text,
                            @Param(name = "time") String time) {
        Alarm a = new Alarm();
        a.setText(text);
        a.setTimeAsString(time);
        records.add(a);
    }

    @Command
    public void createReminder(@Param(name = "text") String text,
                               @Param(name = "time") String time) {
        Reminder rm = new Reminder();
        rm.setText(text);
        rm.setTimeAsString(time);
        records.add(rm);
    }

    @Command
    public List<Record> list() {
        return records;
    }

    @Command
    public List<Record> listExpired() {
        List<Record> result = new ArrayList<>();
        for (Record r: records) {
            if (r instanceof Expirable) {
                Expirable e = (Expirable) r;
                if (e.isExpired()) {
                    result.add(r);
                }
            }
        }
        return result;
    }

    @Command
    public List<Record> find(String str) {
        List<Record> result = new ArrayList<>();
        for (Record r : records) {
            if (r.contains(str)) {
                result.add(r);
            }
        }
        return result;
    }

    @Command
    public void remove(@Param(name = "id") int id) {
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);
            if (r.getId() == id) {
                records.remove(i);
                break;
            }
        }

    }
}
