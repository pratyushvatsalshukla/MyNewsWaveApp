import React from "react";
import { render, screen } from "@testing-library/react";
import Footer from '../components/Footer/Footer'

test("Testing Footer Component Copyright Text", ()=>{
    render(<Footer/>) ;
    const footerText = screen.getByText(/All rights reserved. Contact Owner/i) // "/i" is for case insensitive
    expect(footerText).toBeInTheDocument() ;

})

test("Testing Footer Component Media Content ", ()=>{
    render(<Footer/>) ;
    const footerGithub = screen.getByTitle("github-link") ;
    const footerLinkedin = screen.getByTitle("linkedin-link") ;
    expect(footerGithub).toBeInTheDocument() ;
    expect(footerLinkedin).toBeInTheDocument() ;
})

test("Testing Footer Component Media Image ", ()=>{
    render(<Footer/>) ;
    const footerImgGithub = screen.getByAltText("Github")
    const footerImgLinkedin = screen.getByAltText("LinkedIn") ;
    expect(footerImgGithub).toBeInTheDocument() ;
    expect(footerImgLinkedin).toBeInTheDocument() ;
})