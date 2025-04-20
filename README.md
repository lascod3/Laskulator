Laskulator
Laskulator is a simple desktop calculator application built using Java.
It performs basic arithmetic operations through a clean and intuitive graphical interface.

How It Works
The app uses an object-oriented approach with two main components:

Operation.java (Model Class):
This class contains the core methods for performing arithmetic operations.

Laskulator.java (Main Class):
This is the entry point of the application, responsible for the UI and handling user interactions.

Key Features
Basic operations: addition, subtraction, multiplication, and division

Responsive GUI

Simple and readable Java codebase

Modular design using OOP principles

Logic Flow
When an operator button is clicked, the operator (sign) is set using the setSign() method.

The getSign() method retrieves the stored operator.

The equalOps(String sign) method then performs the correct operation based on the sign passed to it.

A switch statement is used inside equalOps() to call the appropriate method in the Operation class.

![Screenshot 2023-01-22 at 10 35 46](https://user-images.githubusercontent.com/57866950/213920484-eda18fa3-77d5-4bfb-ac93-6e0cd6a2da4e.png)


