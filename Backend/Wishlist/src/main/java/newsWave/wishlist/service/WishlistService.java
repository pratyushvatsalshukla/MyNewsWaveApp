package newsWave.wishlist.service;

import newsWave.wishlist.entity.Wishlist;

import java.util.List;

public interface WishlistService {

    boolean saveArticleToWishlist(Wishlist article);
    List<Wishlist> findAllArticlesFromWishlist(String email);

    boolean deleteArticleFromWishlist(String email, String id) ;
}