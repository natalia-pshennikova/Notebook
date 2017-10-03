package Pshennikova;

import asg.cliche.Command;
import asg.cliche.Param;
import java.util.*;

public class Notebook {
    private final NavigableMap<Integer, Record> records = new TreeMap<>();

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
        records.put(r.getId(), r);
    }

    @Command
    public void createNote(@Param(name = "text") String text) {
        Note n = new Note();
        n.setText(text);
        records.put(n.getId(), n);
    }

    @Command
    public void createAlarm(@Param(name = "text") String text,
                            @Param(name = "time") String time) {
        Alarm a = new Alarm();
        a.setText(text);
        a.setTimeAsString(time);
        records.put(a.getId(), a);
    }

    @Command
    public void createReminder(@Param(name = "text") String text,
                               @Param(name = "time", description = "format yyyy.mm.dd") String time) {
        Reminder rm = new Reminder();
        rm.setText(text);
        rm.setTimeAsString(time);
        records.put(rm.getId(), rm);
    }

    @Command
    public Collection<Record> list() {
        return records.values();
    }

    @Command
    public List<Record> listExpired() {
        List<Record> result = new ArrayList<>();
        for (Record r: records.values()) {
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
        for (Record r : records.values()) {
            if (r.contains(str)) {
                result.add(r);
            }
        }
        return result;
    }

    @Command
    public Collection<Record> range(int start, int end) {
       return records.subMap(start, end).values();
    }

    @Command
    public void remove(@Param(name = "id") int id) {
      records.remove(id);
    }
}
