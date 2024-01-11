import React from "react";
import github from "../resources/github.png";
import linkedin from "../resources/linkedin.png";
import "./Footer.css";
const Footer = () => {
  return (
    <footer className="footer">
      <div className="container">
        <div className="footer-content">
          <div className="footer-text">
          {/* Footer Text */}
            <p>CopyRight &copy; 2023 @NewsWave. All rights reserved. Contact Owner ➡️</p>  
          </div>
          <div className="social-icons">
          {/* GITHUB LOGO AND LINK */}
            <span className="media-handles" title="github-link">
              <a
                href="https://github.com/pratyushvatsalshukla"
                target="_blank"
                rel="noopener noreferrer"
              >
                
                <img src={github} alt="Github" className="footer-logo" />
              </a>
            </span>
            {/* LinkedIn Logo and Link */}
            <span className="media-handles" title="linkedin-link">
              <a
                href="https://www.linkedin.com/in/pratyushvatsalshukla/"
                target="_blank"
                rel="noopener noreferrer"
              >
                <img src={linkedin} alt="LinkedIn" className="footer-logo" />
              </a>
            </span>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
