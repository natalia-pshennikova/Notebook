package Pshennikova;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Alarm extends Note implements Expirable{
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setTimeAsString(String str) {
        LocalTime t = LocalTime.parse(str, formatter);
        setTime(t);
    }

    public String getTimeAsString() {
        LocalTime t = getTime();
        return t.format(formatter);
    }
    @Override
    public boolean contains(String str) {
        String strLower = str.toLowerCase();
        return super.contains(strLower) || getTimeAsString().toLowerCase().contains(strLower);
       /* if (super.contains(str)) {
            return true;
        } else {
            String timeLower = getTimeAsString().toLowerCase();
            if (timeLower.contains(strLower)) {
                return true;
            }
        }
        return false;*/
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + getId() +
                "text='" + getText() + '\'' +
                "time='" + getTimeAsString() + '\'' +
                '}';
    }

    @Override
    public boolean isExpired() {
        LocalTime now = LocalTime.now();
        return now.isAfter(time);
    }
}
