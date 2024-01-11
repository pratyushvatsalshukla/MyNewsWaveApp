package newsWave.authentication.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class UserCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "EmailId is required")
    @Size(min=3, max=30, message = "emailId must be between 3 and 30 characters")
    @Email
    private String emailId;

    @NotBlank(message = "Password is required")
    @Size(min=3, max=30, message = "Password must be between 3 and 30 characters")
    private String password;

    // @Transient to tell it that we do not need to save it in database
    @Transient
    private List<Wishlist> wishlist;

    public UserCredential(int id, String emailId, String password, List<Wishlist> wishlist) {
        this.id = id;
        this.emailId = emailId;
        this.password = password;
        this.wishlist = wishlist;
    }

    public UserCredential() {
    }

    public UserCredential(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Wishlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Wishlist> wishlist) {
        this.wishlist = wishlist;
    }
}

