package newswave.newsservice.newsservice.entity;

public class Articles {

    private String title ;

    private String author ;

    private String link ;

    private String media ;

    private String summary ;

    // Image

    private String _id ;

    public Articles(String title, String author, String link, String _id, String media, String summary) {
        this.title = title;
        this.author = author;
        this.link = link;
        this._id = _id;
        this.summary = summary ;
        this.media = media ;
    }

    public Articles() {
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
