import React from "react";
import { render, screen } from "@testing-library/react";
import "@testing-library/jest-dom/extend-expect";
import { BrowserRouter } from "react-router-dom";
import CustomNavBar from "../components/NavigationBar/CustomNavBar";
import {
  getCurrentUserDetail,
  isLoggedIn,
} from "../authentication/CheckAuthentication";

test("UI Testing For The Login Form Logo Alt", () => {
  render(
    <BrowserRouter>
      <CustomNavBar />
    </BrowserRouter>
  );
  const logoHeader = screen.getByText(/NewsWave/i);
  expect(logoHeader).toBeInTheDocument();
});
test("UI Testing For The Login Form : Login ", () => {
  render(
    <BrowserRouter>
      <CustomNavBar />
    </BrowserRouter>
  );

  const login = screen.getByText(/Login/i);
  expect(login).toBeInTheDocument();
});
test("UI Testing For The Login Form : Signup ", () => {
  render(
    <BrowserRouter>
      <CustomNavBar />
    </BrowserRouter>
  );

  const signup = screen.getByText(/Signup/i);
  expect(signup).toBeInTheDocument();
});

// Write Test Case For The Nav Bar When User Is Logged In
