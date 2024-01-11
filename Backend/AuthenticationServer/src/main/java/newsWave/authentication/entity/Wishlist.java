package newsWave.authentication.entity;

public class Wishlist {

    String emailId ;

    String url ;

    public Wishlist(String emailId, String url) {
        this.emailId = emailId;
        this.url = url;
    }

    public Wishlist() {
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
