import React from "react";
import CustomNavBar from "../NavigationBar/CustomNavBar";
import "./Home.css";
import Footer from "../Footer/Footer";
import GraphemeSplitter from "grapheme-splitter"; //
import { TypeAnimation } from "react-type-animation";

const Home = () => {
  const splitter = new GraphemeSplitter(); // Library to give the animation of writing and deleting text.
  // console.info("LandingPage: Home : Going To Render Home Component !")

  return (
    <div className="main-container-home">
      <CustomNavBar />
      <div className="container center-container">
        <TypeAnimation
          splitter={(str) => splitter.splitGraphemes(str)}
          sequence={[
            "Hello 👋 Welcome To NewsWave 😇",
            "नमस्ते 🙏 Welcome To NewsWave 😇",
            2000, // Time for which one element is going to be shown.
          ]}
          style={{ fontSize: "1.75em" }}
          // We can set The number of times this thing is going to repeat itself
          repeat={Infinity}
        />
      </div>
      <Footer />
    </div>
  );
};
export default Home;
