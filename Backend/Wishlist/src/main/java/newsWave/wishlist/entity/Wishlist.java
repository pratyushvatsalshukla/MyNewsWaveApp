package newsWave.wishlist.entity;
import jakarta.persistence.*;

@Entity
public class Wishlist {
//    @Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long wishlistId ;
    private String emailId ;

    private String title ;

    private String author ;

    private String link ;

    @Column(columnDefinition = "TEXT")
    private String summary ;

    private String media ;
    private String _id ;

    public Wishlist() {}

    public Wishlist(long wishlistId, String emailId, String title, String author, String link, String summary, String media, String _id) {
        this.wishlistId = wishlistId;
        this.emailId = emailId;
        this.title = title;
        this.author = author;
        this.link = link;
        this.summary = summary;
        this.media = media;
        this._id = _id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    public long getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(long wishlistId) {
        this.wishlistId = wishlistId;
    }
}