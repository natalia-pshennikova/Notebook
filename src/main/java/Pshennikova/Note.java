package Pshennikova;

public class Note  extends Record  {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + getId() +
                "text='" + text + '\'' +
                '}';
    }
}
