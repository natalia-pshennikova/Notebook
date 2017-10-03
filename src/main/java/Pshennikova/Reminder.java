package Pshennikova;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reminder extends Note implements Expirable {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

    private LocalDateTime time;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setTimeAsString(String str) {
        LocalDateTime dt = LocalDateTime.parse(str, formatter);
        setTime(dt);
    }

    public String getTimeAsString() {
        LocalDateTime dt = getTime();
        return dt.format(formatter);
    }
    @Override
    public boolean contains(String str) {
        String strLower = str.toLowerCase();
        return super.contains(strLower) || getTimeAsString().toLowerCase().contains(strLower);
        /*if (super.contains(str)) {
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
        return "Reminder{" +
                "id=" + getId() +
                "text='" + getText() + '\'' +
                "time='" + getTimeAsString() + '\'' +
                '}';
    }

    @Override
    public boolean isExpired() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(time);
    }
}
