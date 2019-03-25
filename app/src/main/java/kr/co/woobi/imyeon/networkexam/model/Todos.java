package kr.co.woobi.imyeon.networkexam.model;

public class Todos {
    int id;
    String title;
    boolean completed;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Todos{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", completed=").append(completed);
        sb.append('}');
        return sb.toString();
    }

    public Todos(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
