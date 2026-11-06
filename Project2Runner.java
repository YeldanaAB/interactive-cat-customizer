public class Project2Runner {
    
    /*
     * Name: Yeldana Bolatzhan
     * Student ID: 501331154
     * 
     ******** Project Description ********
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
     * 
     * This program is an interactive cat drawing built with Java Swing and Graphics2D. The Cat panel 
     * displays a cat whose body and eye colors can be changed with two buttons. Clicking the cat toggles
     * the eyes open or closed, and a checkbox toggles a hat on or off. The Cat JPanel overrides paintComponent 
     * to draw the cat and hat using various shapes (ellipses, polygons, arcs) and a gradient background. 
     * The graphics are drawn using helper methods such as drawBody, drawHead, drawEyes, drawHat, etc. 
     * There is a MouseListener in the Cat panel that allows the user to toggle the cat’s 
     * eyes open or closed by clicking on the cat. Three ActionListeners are used in Project.java: 
     * two buttons let the user randomly change the cat's body and eye colors, and a checkbox toggles the hat on or off. 
     * Each listener updates the cat's appearance through setter methods and repaints the panel.
     * 
     * The program uses several Swing components. The Cat class extends JPanel and to implement custom graphics, it draws 
     * the cat using helper methods and also handles interactions like toggling the eyes from open to closed with a MouseListener. 
     * The Project class extends JFrame and is the main window. It has a buttonPanel JPanel which has two JButtons, 
     * (one to change the cat's body color and another to change the cat's eye color), and a JCheckbox to toggle the hat, 
     * so all the controls are grouped together. The buttonPanel and catPanel are organized using BorderLayout, 
     * with the catPanel in the center and the buttonPanel located south.
     *
     * Instructions:
     * Click the checkbox to toggle the hat on or off.
     * Click the "Change Cat Color" button to randomly change the cat's body color.
     * Click the "Change Eye Color" button to randomly change the cat's eye color.
     * Click on the cat to open or close its eyes.
     * 
     ******** Swing Requirement ********
     * 
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 3 unique components. Be clear to identify in what
     * files and the lines number (just the starting line is fine) that the
     * components are defined on.
     * 
     * This program satisfies the Swing component requirement with at least three unique components. 
     * In Cat.java, the Cat class extends JPanel at line 6.
     * The program also uses the following Swing components in Project.java: 
     * the Project class extends JFrame at line 5, a JButton for changing the cat's color at line 17, 
     * a JButton for changing eye color at line 18, a JCheckBox for toggling the hat at line 42, 
     * and buttonPanel JPanel at line 53.
     * 
     ******** 2D Graphics Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 1 JPanel used for drawing something. Be clear to
     * identify in what files and the line numbers that this panel is defined on.
     * 
     * This program satisfies the 2D graphics requirement through the Cat class which extends JPanel at line 6
     * and overrides the paintComponent method (starting at line 46) to draw the graphics using Java's 
     * Graphics2D, including the cat, the hat, and a gradient background, which are all organized into helper methods
     * starting from line 71.
     * 
     * 
     ******** Event Listener Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least one ActionListener, and there is additionally at least
     * one MouseListener or ActionListener. Be clear to identify in what file
     * and the line numbers that these listeners are defined in.
     * 
     * This program satisfies the event listener requirement by using a MouseListener and three ActionListeners. 
     * In Cat.java, there is a MouseListener at line 17 which toggles the cat's eyes open or closed when the user clicks on the cat panel. 
     * In Project.java, three ActionListeners are defined: one at line 26 for the "Change Cat Color" button, 
     * one at line 34 for the "Change Eye Color" button, and one at line 45 for hat toggle checkbox.
     *
     */

    public static void main(String[] args) {
        new Project();
    }
}