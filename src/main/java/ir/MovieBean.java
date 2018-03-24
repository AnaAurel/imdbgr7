package ir;

public class MovieBean {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getUrlyoutube() {
        return urlyoutube;
    }

    public void setUrlyoutube(String urlyoutube) {
        this.urlyoutube = urlyoutube;
    }

    private int id;
    private String name;
    private String poster;
    private String urlyoutube;
}
