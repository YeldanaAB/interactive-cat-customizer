
# Interactive Cat Customizer 🐱

An interactive desktop application developed using Java Swing and Graphics2D. The program features a custom-drawn cat that users can personalize by changing its body and eye colors, adding or removing a hat, and toggling its eyes between open and closed.

## Features

- **Custom 2D Graphics:** Draws a cat using geometric shapes, including ellipses, polygons, and arcs.
- **Color Customization:** Randomly changes the cat's body and eye colors using buttons.
- **Interactive Expressions:** Clicking the cat toggles its eyes between open and closed.
- **Accessory Customization:** A checkbox allows users to show or hide a hat.
- **Real-Time Visual Updates:** Automatically redraws the illustration whenever a customization is applied.
- **Gradient Background:** Uses Java Graphics2D to render a pink-to-white gradient background.

## Technologies Used

- Java
- Java Swing
- Java AWT
- Graphics2D

## Programming Concepts

- **GUI Development:** Uses `JFrame`, `JPanel`, `JButton`, and `JCheckBox` to create an interactive desktop interface.
- **Event-Driven Programming:** Implements `ActionListener` and `MouseListener` functionality to handle user interactions.
- **Custom Rendering:** Overrides `paintComponent()` to draw the cat using Java Graphics2D.
- **Object-Oriented Programming:** Separates the application window and drawing logic into different classes.
- **State Management:** Uses instance variables to track the cat's appearance and `repaint()` to update the display.

## Project Structure

```text
interactive-cat-customizer/
├── Cat.java
├── Project.java
├── Project2Runner.java
└── README.md
```

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/YeldanaAB/interactive-cat-customizer.git
   ```

2. Navigate to the project directory:

   ```bash
   cd interactive-cat-customizer
   ```

3. Compile the Java files:

   ```bash
   javac *.java
   ```

4. Run the application:

   ```bash
   java Project2Runner
   ```

**Requirements:** Java Development Kit (JDK) installed and a desktop environment that supports graphical windows.

## How to Use

1. Click **Change Cat Color** to randomly change the cat's body color.
2. Click **Change Eye Color** to randomly change the cat's eye color.
3. Select the **Hat** checkbox to add a hat, or deselect it to remove the hat.
4. Click the cat illustration to toggle its eyes between open and closed.

The application uses event listeners to respond to user interactions and updates the illustration through `repaint()`.

## Project Purpose

This project was developed to practice Java GUI development, event-driven programming, object-oriented design, and custom 2D graphics rendering.
