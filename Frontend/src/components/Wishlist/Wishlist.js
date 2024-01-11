import React, { useState, useEffect } from "react";
import CustomNavBar from "../NavigationBar/CustomNavBar";
import { getCurrentUserDetail } from "../../authentication/CheckAuthentication";
import { getUserWishlist } from "../../services/getUserWishlist";
import "./Wishlist.css";
import Footer from "../Footer/Footer";
import { toast } from "react-toastify";
import { Button } from "reactstrap";
import { deleteArticleFromWishlist } from "../../services/deleteArticleFromWishlist";

const Wishlist = (props) => {
  const [userWishlist, setUserWishlist] = useState({
    wishlist: undefined,
  });

  const [deleteStatus, setDeleteStatus] = useState(false);

  useEffect(() => {
    const emailId = getCurrentUserDetail().emailId;
    getUserByEmailId(emailId);
    setDeleteStatus(false); // Reset delete status after re-render
  }, [deleteStatus]);

  useEffect(() => {
    const emailId = getCurrentUserDetail().emailId;
    // console.log("WISHLIST EMAIL ", emailId);
    getUserByEmailId(emailId);
  }, []);

  // const [deleteStatus, setdeleteStatus] = useState(undefined)

  const getUserByEmailId = (emailId) => {
    getUserWishlist(emailId)
      .then((response) => {
        // console.log(response)
        setUserWishlist(response);
      })
      .catch((error) => {
        // console.log("ERROR IN WISHLIST FETCHING", error);
        toast.error("Error Fetching Wishlist");
      });
  };

  const deleteFromWishlist = (event, article) => {
    event.preventDefault();

    let jsonObject = JSON.parse(article);
    // console.log("JSON OBJECT ", jsonObject);
    deleteArticleFromWishlist(jsonObject)
      .then((response) => {
        setDeleteStatus(true); // Update the delete status to trigger re-render

        toast.info("Article Deleted From Wishlist !!");
        // navigate("/user/wishlist");
        // console.log("Response FROM DELETE WISHLSIT :", response);

        // navigate("/user/wishlist");
      })
      .catch((error) => {
        // console.log("Error :", error);
        toast.error("Error Deleting Article From Wishlist");
      });
  };

  return (
    <>
      <div className="main-container-wishlist">
        <CustomNavBar />
        <div className="wishlist-container-div">
          <marquee className="marquee">
            Find Your All Wishlisted Articles Here !!
          </marquee>
          <div className="mx-auto card-div container">
            {userWishlist.wishlist &&
              userWishlist.wishlist.map((wishlistItem, index) => {
                return (
                  <div
                    key={index}
                    className="cards-main card-container"
                    style={{ width: "18rem" }}
                  >
                    <img
                      className="card-img-top"
                      src={wishlistItem.media}
                      alt={wishlistItem.title}
                    />
                    <div className="card-body">
                      <h5 className="card-title">{wishlistItem.title}</h5>
                      <p className="card-text">
                        {wishlistItem.summary.substring(0, 100)}...
                      </p>
                    </div>
                    <ul className="list-group list-group-flush">
                      {/* <li className="list-group-item">Cras justo odio</li>
                  <li className="list-group-item">Dapibus ac facilisis in</li> */}
                      <li className="list-group-item">{wishlistItem.author}</li>
                    </ul>
                    <div className="card-body">
                      <a href={wishlistItem.link} className="card-link">
                        Click To Read more...
                      </a>
                      <a href="#" className="card-link">
                        <Button
                          className="btn btn-danger"
                          onClick={(event) =>
                            deleteFromWishlist(
                              event,
                              JSON.stringify(wishlistItem)
                            )
                          }
                        >
                          Delete 🚮
                        </Button>
                      </a>
                    </div>
                  </div>
                );
              })}
          </div>
        </div>
        <Footer />
      </div>
    </>
  );
};

export default Wishlist;
