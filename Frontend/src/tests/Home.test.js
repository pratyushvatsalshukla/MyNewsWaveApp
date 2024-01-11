import { render, screen } from "@testing-library/react";
import React from "react";
import Home from "../components/LandingPage/Home";
import { MemoryRouter } from "react-router-dom";
import { ReactDOM } from "react";

test("Testing Landing Page : Main Content Loading Or Not !", () => {
 const {container}= render(
    <MemoryRouter>
      <Home />
    </MemoryRouter>
  );
  const containerDiv = container.querySelector('.container');
  expect(containerDiv).toBeInTheDocument();

 });
