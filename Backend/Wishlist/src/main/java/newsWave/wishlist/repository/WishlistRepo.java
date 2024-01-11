package newsWave.wishlist.repository;

import newsWave.wishlist.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist,String> {
    @Query("select w from Wishlist w where w.emailId = ?1")
    List<Wishlist> findAllWishlistByEmailId(String email) ;

    void deleteBy_id(String id);

    @Query("SELECT w FROM Wishlist w WHERE w.emailId = :emailId AND w._id = :wishlistId")
    Wishlist findByEmailIdAndId(@Param("emailId") String emailId, @Param("wishlistId") String wishlistId);

    @Modifying
    @Query(value = "DELETE FROM Wishlist w WHERE w.emailId = :emailId AND w._id = :id")
    void deleteByEmailIdAndId(@Param("emailId") String emailId, @Param("id") String id);
}