package Pshennikova;

public class Alarm extends Note implements Expirable{
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean contains(String str) {
        String strLower = str.toLowerCase();
        if (super.contains(str)) {
            return true;
        } else {
            String timeLower = time.toLowerCase();
            if (timeLower.contains(strLower)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + getId() +
                "text='" + getText() + '\'' +
                "time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
