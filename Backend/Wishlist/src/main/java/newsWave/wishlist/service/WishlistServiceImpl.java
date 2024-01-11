package newsWave.wishlist.service;

import jakarta.transaction.Transactional;
import newsWave.wishlist.entity.Wishlist;
import newsWave.wishlist.repository.WishlistRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WishlistServiceImpl implements WishlistService{


    @Autowired
    WishlistRepo wishlistRepo ;

    Logger logger = LoggerFactory.getLogger(WishlistServiceImpl.class);


    @Override
    public List<Wishlist> findAllArticlesFromWishlist(String emailId) {
        logger.info("Inside findAllArticlesFromWishlist method");
        List<Wishlist> items = wishlistRepo.findAllWishlistByEmailId(emailId) ;
        if (Objects.isNull(items)) {
            logger.error("No Items Found in the wishlist");
            throw new NullPointerException() ;
        }
        else{
            logger.info("Wishlist Items Fetching...") ;
            return items ;
        }
    }

    @Override
    @Transactional
    public boolean deleteArticleFromWishlist(String emailId, String id) {
        logger.info("Inside deleteArticleFromWishlist") ;

        Wishlist wishlistById = wishlistRepo.findByEmailIdAndId(emailId, id) ;

        if(Objects.nonNull(wishlistById)){
            logger.warn("Item Found, So Deleting...") ;
            wishlistRepo.deleteByEmailIdAndId(emailId, id);
            return true ;
        }
        else {
            logger.error("Item Not Found, So Can Not Delete !!");
            return false;
        }
    }

    @Override
    public boolean saveArticleToWishlist(Wishlist wishlist) {
        logger.info("Entered SaveArticleToWishlist");
//        Wishlist wishlistById = wishlistRepo.findWishlistBy_idAn(wishlist.get_id());
        Wishlist saved=null ;
        Wishlist byEmailId = wishlistRepo.findByEmailIdAndId(wishlist.getEmailId(), wishlist.get_id());

        if(byEmailId==null ){
            saved = wishlistRepo.save(wishlist) ;
            logger.info("Saved Article To Wishlist"+saved);
            return true ;
        }
        else
        {
            logger.info("Article Is Already Wishlisted !!") ;
        }
        return false ;
    }
}