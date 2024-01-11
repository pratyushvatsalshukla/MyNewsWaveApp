import React, { useState } from "react";
import { toast } from "react-toastify";
import CustomNavBar from "../NavigationBar/CustomNavBar";
import "./UserDashboard.css";
import { fetchCustomNews } from "../../services/fetchCustomNews";
import logo from "../resources/logo.png";
import Footer from "../Footer/Footer";
import { Button, Container } from "reactstrap";
import { addArticleToWishlist } from "../../services/addWishlist";
import { getCurrentUserDetail } from "../../authentication/CheckAuthentication";
import { fetchTopHeadlines } from "../../services/fetchTopHeadlines";
import { useEffect } from "react";
import Spinner from "../Spinner/Spinner";

export const UserDashboard = () => {
  const [loading, setLoading] = useState(true); // Setting Loading true/false for spinner
  const [subject, setSubject] = useState(""); // User Searched data
  const [fetchedData, setFetchedData] = useState(undefined); // Data Fetched On User Search
  const [fetchDefaultData, setFetchDefaultData] = useState(undefined); // Data Fetched on The Dashboard Rendering

  // Pagination
  const [currentPage, setcurrentPage] = useState(1);
  const [itemsPerPage, setitemsPerPage] = useState(12);
  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentItemsSearched =
    fetchedData && fetchedData.slice(indexOfFirstItem, indexOfLastItem);
  const currentItemsDefault =
    fetchDefaultData &&
    fetchDefaultData.slice(indexOfFirstItem, indexOfLastItem);
  const pagination = (pageNumber) => {
    currentPage == pageNumber
      ? toast.info("You Are Already On This Page")
      : setcurrentPage(pageNumber);
  };

  useEffect(() => {
    fetchTopHeadlines() // CAlling the promise to interact with third party API
      .then((response) => {
        setFetchDefaultData(response.articles.slice(0, 48)); // Setting the default fetch data to fetchDefaultData State.
        setLoading(false); // Setting the loading false so that spinner gets unmounted.
        window.addEventListener("popstate", (e) => {
          // Disabling the back button so that user can not go to login page again after login.
          window.history.go(1);
        });
        // console.info("Fetching Top Headlines Successful !");
        toast.success("Fetching Top Headlines !");
      })
      .catch((error) => {
        // Promise returning error.
        // console.error(
        //   "Error in Fetching Top Headlines ! Promise Returned Error !"
        // );
        toast.error("Error Fetching Top Headlines !");
      });
  }, []);

  useEffect(() => {}, [fetchDefaultData]); // re-render the component each time when fetchDefaultData is called.

  const handleChange = (event) => {
    // Changing the subject state value
    // console.log("Data : ", event.target.value);
    setSubject(event.target.value);
  };

  const getNews = (event) => {
    // Callled when user wants to search news according to his/her need
    event.preventDefault();
    // console.info("Form Submitte Successfully !! User Searched Data :");

    fetchCustomNews(subject) // Calling service to fetch user searched data.
      .then((response) => {
        setFetchDefaultData(undefined);
        // console.info("Fetching News Successful !");
        toast.success("News Fetched Successfully");
        setFetchedData(response.articles.slice(0, 48));
        // setcurrentPage(1);
      })
      .catch((error) => {
        // console.error("Error in Fetching News ! Promise Returned Error !");
        toast.error("Error Fetching News", error);
      });
  };

  const addWishlist = (event, article) => {
    // Method to add the articles to the wishlist !!
    event.preventDefault();
    const jsonString = article;
    let jsonObject = JSON.parse(jsonString);
    // Reducing article.summary to save it to database. Because The summary size was above 5000 words and If not done, database will give error !!
    let articleSummary = jsonObject.summary.substring(0, 2500);
    jsonObject.summary = articleSummary;
    jsonObject.emailId = getCurrentUserDetail().emailId; // Setting json object a key value of emailId as the article from thirdparty API dont have user email.
    // By Email only we will be able to fetch data back from database.

    addArticleToWishlist(jsonObject) // Calling Service.
      .then((response) => {
        toast.success("Article Added To The Wishlist !!");
        // setwishlistStatus(true);
      })
      .catch((error) => {
        // console.error(
        //   "Error occured in Adding Article to wishlist. Promise returned Error"
        // );
        toast.error(error.response.data);
      });
  };

  return (
    <>
      {loading && <Spinner />}
      {!loading && (
        <div className="main-container-ud">
          <CustomNavBar />

          <form className="d-flex" role="search" onSubmit={getNews}>
            <span className="span-for-img">
              <img src={logo} alt="NewsWave" className="logo-ud" />
            </span>
            {/* <span><img src={'../resources/newswave.png'}/></span> */}
            <input
              className="form-control me-2 search-input"
              type="search"
              placeholder="Enter Any Keyword To Search News"
              aria-label="Search"
              onChange={(event) => handleChange(event)}
              value={subject}
            />
            <button
              className="btn btn-outline-success topic-search"
              type="submit"
            >
              Search
            </button>
          </form>

          {fetchDefaultData && (
            <div className="container card-div mx-auto">
              {fetchDefaultData &&
                currentItemsDefault.map((data, index) => {
                  return (
                    <div
                      key={index}
                      style={{ width: "18rem" }}
                      className="cards-main card-container"
                    >
                      <img
                        className="card-img-top"
                        src={data.media}
                        alt="Card image cap"
                      />
                      <div className="card-body">
                        <h5 className="card-title">{data.title}</h5>
                        <p className="card-text">
                          {data.summary.substring(0, 50)}...
                        </p>
                      </div>
                      <ul className="list-group list-group-flush">
                        {/* <li className="list-group-item">Cras justo odio</li>
                 <li className="list-group-item">Dapibus ac facilisis in</li> */}
                        <li className="list-group-item">{data.author}</li>
                      </ul>
                      <div className="card-body">
                        <a href={data.link} className="card-link">
                          Click To Read more...
                        </a>
                        <a href="#" className="card-link">
                          <Button
                            className="btn btn-light"
                            onClick={(event) =>
                              addWishlist(event, JSON.stringify(data))
                            }
                          >
                            ⭐
                          </Button>
                        </a>
                      </div>
                    </div>
                  );
                })}
            </div>
          )}
          <div className="container card-div mx-auto">
            {fetchedData &&
              currentItemsSearched.map((data, index) => {
                return (
                  <div
                    key={index}
                    style={{ width: "18rem" }}
                    className="cards-main card-container"
                  >
                    <img
                      className="card-img-top"
                      src={data.media}
                      alt="Card image cap"
                    />
                    <div className="card-body">
                      <h5 className="card-title">{data.title}</h5>
                      <p className="card-text">
                        {data.summary.substring(0, 50)}...
                      </p>
                    </div>
                    <ul className="list-group list-group-flush">
                      {/* <li className="list-group-item">Cras justo odio</li>
                  <li className="list-group-item">Dapibus ac facilisis in</li> */}
                      <li className="list-group-item">{data.author}</li>
                    </ul>
                    <div className="card-body">
                      <a href={data.link} className="card-link">
                        Click To Read more...
                      </a>
                      <a href="#" className="card-link">
                        <Button
                          className="btn btn-light"
                          onClick={(event) =>
                            addWishlist(event, JSON.stringify(data))
                          }
                        >
                          ⭐
                        </Button>
                      </a>
                    </div>
                  </div>
                );
              })}
          </div>
          <div className="pagination d-flex justify-content-center">
            {Array.from({
              length: Math.ceil(48 / itemsPerPage),
            }).map((_, index) => (
              <button
              key={index}
                className="btn btn-success pagination-btn"
                onClick={() => pagination(index + 1)}
              >
                {index + 1}
              </button>
            ))}
          </div>
          <Footer />
        </div>
      )}
    </>
  );
};
