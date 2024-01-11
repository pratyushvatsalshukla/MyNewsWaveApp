package newsWave.wishlist.controller;

import newsWave.wishlist.entity.Wishlist;
import newsWave.wishlist.service.WishlistServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist/")
public class WishlistController {

    @Autowired
    WishlistServiceImpl wishlistImpl;
    Logger logger = LoggerFactory.getLogger(WishlistController.class);

    @PostMapping("/save")
    public ResponseEntity<?> saveArticleToWishlist(@RequestBody Wishlist article) {

        boolean result = wishlistImpl.saveArticleToWishlist(article);
        if(result){
            return new ResponseEntity<>("Article Saved Successfully", HttpStatus.CREATED) ;
        }
        else{
            return new ResponseEntity<>("Article Already Exists In Wishlist !", HttpStatus.CONFLICT) ;
        }
    }

    @GetMapping("/viewWishlist/{emailId}")
    public ResponseEntity<?> getArticlesFromWishlist(@PathVariable String emailId) {
        logger.info("Inside getArticlesFromWishlist method");

        return new ResponseEntity<>(wishlistImpl.findAllArticlesFromWishlist(emailId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteWishlist")
    public ResponseEntity<?> deleteArticleFromWishlist(@RequestBody Wishlist wishlist) {
        logger.info("Inside deleteArticleFromWishlist method");

        boolean res = wishlistImpl.deleteArticleFromWishlist(wishlist.getEmailId(), wishlist.get_id());
        logger.info("Response For Delete Article From Wishlist : "+res);
        if(res){
            logger.info("Article deleted successfully");
            return new ResponseEntity<>("Article deleted successfully", HttpStatus.OK) ;
        }
        else{
            logger.error("Item Not Found, So Can Not Delete !!") ;
            return new ResponseEntity<>("Article not found", HttpStatus.NOT_FOUND) ;
        }
    }
}