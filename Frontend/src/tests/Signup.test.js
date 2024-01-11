import { render, screen } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import Signup from "../components/Signup/Signup";
import React from "react";

test("UI Testing For The Signup : Register", () => {
    render(
      <BrowserRouter>
        <Signup/>
      </BrowserRouter>
    );
    const register = screen.getByText(/Register Here !/i);
    expect(register).toBeInTheDocument();
  });
  test("UI Testing For The The Signup : Name", () => {
    render(
      <BrowserRouter>
        <Signup/>
      </BrowserRouter>
    );
    const name = screen.getByText(/Name/i);
    expect(name).toBeInTheDocument();
  });
  test("UI Testing For The Signup : Email", () => {
    render(
      <BrowserRouter>
        <Signup/>
      </BrowserRouter>
    );
    const email = screen.getByText(/Email/i);
    expect(email).toBeInTheDocument();
  });
  test("UI Testing For The Signup : Password", () => {
    render(
      <BrowserRouter>
        <Signup/>
      </BrowserRouter>
    );
    const password = screen.getByText(/Password/i);
    expect(password).toBeInTheDocument();
  });
  test("UI Testing For The Signup : Register Button", () => {
    render(
      <BrowserRouter>
        <Signup/>
      </BrowserRouter>
    );
    const registerbtn = screen.getByText(/Click Here To Register/i);
    expect(registerbtn).toBeInTheDocument();
  });
  test("UI Testing For The Signup : Reset", () => {
    render(
      <BrowserRouter>
        <Signup/>
      </BrowserRouter>
    );
    const reset = screen.getByText(/Click Here To Reset/i);
    expect(reset).toBeInTheDocument();
  });