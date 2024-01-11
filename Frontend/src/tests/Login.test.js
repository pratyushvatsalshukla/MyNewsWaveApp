import React from "react";
import { render, fireEvent, waitFor } from "@testing-library/react";
import "@testing-library/jest-dom/extend-expect";
import Login from "../components/Login/Login";
import { BrowserRouter } from "react-router-dom";
// import { queryByText } from "@testing-library/react/types";

describe("Login Component UI Testing", () => {
  test("UI Testing For The Login Form ", () => {
    const { getByText, getByLabelText } = render(
        <BrowserRouter>
          <Login />
        </BrowserRouter>
      );

    expect(getByText(/Login Here !/i)).toBeInTheDocument();
    expect(getByLabelText(/Email/i)).toBeInTheDocument();
    expect(getByLabelText(/password/i)).toBeInTheDocument();
    expect(getByText("Login")).toBeInTheDocument();
    expect(getByText("Reset Data")).toBeInTheDocument();

  });
});
//
//
// describe('Login Component', () => {
//   test('renders login form', () => {
//     render(<Login />);
//
//     expect(screen.getByLabelText(/Email/i)).toBeInTheDocument();
//     expect(screen.getByLabelText(/Password/i)).toBeInTheDocument();
//     expect(screen.getByRole('button', { name: /Login/i })).toBeInTheDocument();
//     expect(screen.getByRole('button', { name: /Reset Data/i })).toBeInTheDocument();
//   });
//
//   test('submits form with valid credentials and redirects to dashboard', async () => {
//     render(<Login />);
//
//     jest.spyOn(global, 'fetch').mockResolvedValueOnce({
//       json: jest.fn().mockResolvedValue({ /* your mock response here */ }),
//     });
//
//     fireEvent.change(screen.getByLabelText(/Email/i), { target: { value: 'valid@example.com' } });
//     fireEvent.change(screen.getByLabelText(/Password/i), { target: { value: 'validpassword' } });
//
//     fireEvent.click(screen.getByRole('button', { name: /Login/i }));
//
//     await waitFor(() => {
//       expect(screen.getByText(/Redirecting To Dashboard Page/i)).toBeInTheDocument();
//     });
//
//     expect(screen.getByText(/Login Successful/i)).toBeInTheDocument();
//   });
//
//   test('submits form with invalid credentials and displays error message', async () => {
//     render(<Login />);
//
//     jest.spyOn(global, 'fetch').mockRejectedValueOnce(new Error('Invalid credentials'));
//
//     fireEvent.change(screen.getByLabelText(/Email/i), { target: { value: 'invalid@example.com' } });
//     fireEvent.change(screen.getByLabelText(/Password/i), { target: { value: 'invalidpassword' } });
//
//     fireEvent.click(screen.getByRole('button', { name: /Login/i }));
//
//     await waitFor(() => {
//       expect(screen.getByText(/Incorrect EmailId or Password/i)).toBeInTheDocument();
//     });
//
//     expect(screen.queryByText(/Redirecting To Dashboard Page/i)).not.toBeInTheDocument();
//   });
//
//   test('renders error message if email is not provided', async () => {
//     render(<Login />);
//
//     fireEvent.change(screen.getByLabelText(/Password/i), { target: { value: 'password123' } });
//
//     fireEvent.click(screen.getByRole('button', { name: /Login/i }));
//
//     await waitFor(() => {
//       expect(screen.getByText(/Please Enter Email ID/i)).toBeInTheDocument();
//     });
//
//     expect(screen.queryByText(/Redirecting To Dashboard Page/i)).not.toBeInTheDocument();
//   });
//
//   test('renders error message if password is not provided', async () => {
//     render(<Login />);
//
//     fireEvent.change(screen.getByLabelText(/Email/i), { target: { value: 'test@example.com' } });
//
//     fireEvent.click(screen.getByRole('button', { name: /Login/i }));
//
//     await waitFor(() => {
//       expect(screen.getByText(/Please Enter Your Password/i)).toBeInTheDocument();
//     });
//
//     expect(screen.queryByText(/Redirecting To Dashboard Page/i)).not.toBeInTheDocument();
//   });
// });
