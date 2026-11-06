import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class Cat extends JPanel {
    private int centerX; // X-coordinate of panel center, used for drawing the cat
    private int centerY; // Y-coordinate of panel center, used for drawing the cat
    private Color catColor = new Color(0xf5b57d); // Default body color
    private Color eyeColor = new Color(0xf2df7e); // Default eye color
    private boolean showHat = false; // Keep track whether to draw hat.
    private boolean eyesClosed = false; // Keep track whether eyes closed or open.
  
    public Cat(){
        this.setPreferredSize(new Dimension(600, 600));
        // Toggles eyes
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eyesClosed =! eyesClosed;
                repaint();
            }
        });
    }

    // Setters
    public void setCatColor(Color newColor){ 
        catColor = newColor;  
        repaint();
    }

    public void setEyeColor(Color newColor){ 
        eyeColor = newColor;  
        repaint();
    }

    public void setHat(boolean show){ 
        showHat = show;  
        repaint();
    }

    /**
     * Draws the cat and background using helper methods in order.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // Calculate center
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;

        drawBackground(g2);
        drawBody(g2);
        drawBelly(g2);
        drawFrontLegs(g2);
        drawLegFill(g2);
        drawEars(g2);
        drawHead(g2);
        drawSnout(g2);
        drawEyes(g2);
        drawNose(g2);
        drawMouth(g2);
        drawHat(g2);
    }

    /**
     * Draws a gradient background.
     */
    private void drawBackground(Graphics2D g2) {
        GradientPaint gp = new GradientPaint(0, 0, Color.PINK, 0, getHeight(), Color.WHITE);
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * Draws the main body of the cat.
     */
    private void drawBody(Graphics2D g2) {
        g2.setStroke(new BasicStroke(7));
        
        int bodyW = 350;
        int bodyH = 260;
        int bodyX = centerX - bodyW / 2;
        int bodyY = centerY - bodyH / 2 + 100;
        int bodyYOffset = -10;
        
        Ellipse2D.Double body = new Ellipse2D.Double(bodyX, bodyY + bodyYOffset, bodyW, bodyH);
        g2.setColor(catColor);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.draw(body);
    }

    /**
     * Draws the belly of the cat.
     */
    private void drawBelly(Graphics2D g2) {
        int bellyW = 200;
        int bellyH = 200;
        int bellyX = centerX - bellyW / 2;
        int bellyY = centerY - bellyH / 2;
        int bellyYOffset = 110;
        
        Ellipse2D.Double belly = new Ellipse2D.Double(bellyX, bellyY + bellyYOffset, bellyW, bellyH);
        g2.setColor(catColor.brighter());
        g2.fill(belly);
        g2.setColor(Color.BLACK);
        g2.draw(belly);
    }

    /**
     * Draws the front legs.
     */
    private void drawFrontLegs(Graphics2D g2) {
        int legW = 150;
        int legH = 70;
        int legOffsetX = 40;
        int legY = (centerY - 260 / 2 + 100) + 260 - legH / 2 - 40;
        
        Ellipse2D.Double leftLeg = new Ellipse2D.Double(centerX - legOffsetX - legW / 2, legY, legW, legH);
        g2.setColor(catColor.darker());
        g2.fill(leftLeg);
        g2.setColor(Color.BLACK);
        g2.draw(leftLeg);
        
        Ellipse2D.Double rightLeg = new Ellipse2D.Double(centerX + legOffsetX - legW / 2, legY, legW, legH);
        g2.setColor(catColor);
        g2.fill(rightLeg);
        g2.setColor(Color.BLACK);
        g2.draw(rightLeg);
    }

    /**
     * Hides lineart between body and legs for aesthetics.
     */
    private void drawLegFill(Graphics2D g2) {
        int legFillW = 35;
        int legFillH = 40;
        int legFillOffsetX = 100;
        int legFillY = (centerY - 260 / 2 + 100) + 260 - legFillH / 2 - 55;
        
        Ellipse2D.Double leftLegFill = new Ellipse2D.Double(centerX - legFillOffsetX - legFillW / 2, legFillY, legFillW, legFillH);
        g2.setColor(catColor.darker());
        g2.fill(leftLegFill);
        
        Ellipse2D.Double rightLegFill = new Ellipse2D.Double(centerX + legFillOffsetX - legFillW / 2, legFillY, legFillW, legFillH);
        g2.setColor(catColor);
        g2.fill(rightLegFill);
    }

    /**
     * Draws the ears and inner ear outline.
     */
    private void drawEars(Graphics2D g2) {
        int earHeight = 150;
        int earWidth = 110;
        
        int leftEarCenterX = centerX - 90;
        int rightEarCenterX = centerX + 90;
        int earBaseY = centerY - 60;
        
        // Left ear
        int leftEarX1 = leftEarCenterX - earWidth / 2;
        int leftEarY1 = earBaseY + 75;
        int leftEarX2 = leftEarCenterX + earWidth / 2;
        int leftEarY2 = earBaseY - 50;
        int leftEarX3 = leftEarCenterX - 20;
        int leftEarY3 = earBaseY - earHeight;
        
        Polygon leftEar = new Polygon();
        leftEar.addPoint(leftEarX1, leftEarY1);
        leftEar.addPoint(leftEarX2, leftEarY2);
        leftEar.addPoint(leftEarX3, leftEarY3);
        g2.setColor(catColor);
        g2.fillPolygon(leftEar);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(leftEar);
        
        // Right ear
        int rightEarX1 = rightEarCenterX - earWidth / 2;
        int rightEarY1 = earBaseY - 50;
        int rightEarX2 = rightEarCenterX + earWidth / 2;
        int rightEarY2 = earBaseY + 75;
        int rightEarX3 = rightEarCenterX + 20;
        int rightEarY3 = earBaseY - earHeight;
        
        Polygon rightEar = new Polygon();
        rightEar.addPoint(rightEarX1, rightEarY1);
        rightEar.addPoint(rightEarX2, rightEarY2);
        rightEar.addPoint(rightEarX3, rightEarY3);
        g2.setColor(catColor.darker());
        g2.fillPolygon(rightEar);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(rightEar);
        
        // Inner ears
        g2.setStroke(new BasicStroke(4));
        
        int leftInnerX1 = leftEarCenterX - 20;
        int leftInnerY1 = earBaseY + 30;
        int leftInnerX2 = leftEarCenterX + 10;
        int leftInnerY2 = earBaseY - 40;
        int leftInnerX3 = leftEarCenterX - 10;
        int leftInnerY3 = earBaseY - earHeight + 20;
        
        Polygon leftInnerEar = new Polygon();
        leftInnerEar.addPoint(leftInnerX1, leftInnerY1);
        leftInnerEar.addPoint(leftInnerX2, leftInnerY2);
        leftInnerEar.addPoint(leftInnerX3, leftInnerY3);
        g2.setColor(Color.PINK.darker());
        g2.fillPolygon(leftInnerEar);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(leftInnerEar);
        
        int rightInnerX1 = rightEarCenterX - 10;
        int rightInnerY1 = earBaseY - 40;
        int rightInnerX2 = rightEarCenterX + 20;
        int rightInnerY2 = earBaseY + 30;
        int rightInnerX3 = rightEarCenterX + 10;
        int rightInnerY3 = earBaseY - earHeight + 20;
        
        Polygon rightInnerEar = new Polygon();
        rightInnerEar.addPoint(rightInnerX1, rightInnerY1);
        rightInnerEar.addPoint(rightInnerX2, rightInnerY2);
        rightInnerEar.addPoint(rightInnerX3, rightInnerY3);
        g2.setColor(Color.PINK.darker());
        g2.fillPolygon(rightInnerEar);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(rightInnerEar);
        
        g2.setStroke(new BasicStroke(7));
    }

    /**
     * Draws the head of the cat.
     */
    private void drawHead(Graphics2D g2) {
        int headW = 300;
        int headH = 220;
        int headX = centerX - headW / 2;
        int headY = centerY - headH / 2;
        
        Ellipse2D.Double head = new Ellipse2D.Double(headX, headY, headW, headH);
        g2.setColor(catColor);
        g2.fill(head);
        g2.setColor(Color.BLACK);
        g2.draw(head);
    }

    /**
     * Draws the cat's snout. The oval in the mouth area.
     */
    private void drawSnout(Graphics2D g2) {
        int snoutW = 180;
        int snoutH = 90;
        int snoutX = centerX - snoutW / 2;
        int snoutY = centerY - snoutH / 2;
        int snoutYOffset = 20;
        
        Ellipse2D.Double snout = new Ellipse2D.Double(snoutX, snoutY + snoutYOffset, snoutW, snoutH);
        g2.setColor(catColor.brighter());
        g2.fill(snout);
        g2.setColor(Color.BLACK);
        g2.draw(snout);
    }

    /**
     * If eyesClosed is false it draws open eyes.
     * If eyesClosed is true it draws closed eyes.
     */
    private void drawEyes(Graphics2D g2) {
        if (!eyesClosed) {
            // Eye whites
            int eyeWhiteSize = 80;
            int eyeWhiteX = centerX - eyeWhiteSize / 2;
            int eyeWhiteY = centerY - eyeWhiteSize / 2;
            
            Ellipse2D.Double leftEyeWhite = new Ellipse2D.Double(eyeWhiteX - 60, eyeWhiteY - 30, eyeWhiteSize, eyeWhiteSize);
            g2.setColor(Color.WHITE);
            g2.fill(leftEyeWhite);
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(5));
            g2.draw(leftEyeWhite);
            
            Ellipse2D.Double rightEyeWhite = new Ellipse2D.Double(eyeWhiteX + 60, eyeWhiteY - 30, eyeWhiteSize, eyeWhiteSize);
            g2.setColor(Color.WHITE);
            g2.fill(rightEyeWhite);
            g2.setColor(Color.BLACK);
            g2.draw(rightEyeWhite);
            
            // Pupils
            int pupilSize = 60;
            int pupilX = centerX - pupilSize / 2;
            int pupilY = centerY - pupilSize / 2;
            
            Ellipse2D.Double leftPupil = new Ellipse2D.Double(pupilX - 60, pupilY - 20, pupilSize, pupilSize);
            g2.setColor(eyeColor);
            g2.fill(leftPupil);
            g2.setColor(Color.BLACK);
            g2.draw(leftPupil);
            
            Ellipse2D.Double rightPupil = new Ellipse2D.Double(pupilX + 60, pupilY - 20, pupilSize, pupilSize);
            g2.setColor(eyeColor);
            g2.fill(rightPupil);
            g2.setColor(Color.BLACK);
            g2.draw(rightPupil);
            
            // Eye shine
            int shineSize = 30;
            int shineX = centerX - shineSize / 2;
            int shineY = centerY - shineSize / 2 - 20;
            
            Ellipse2D.Double leftWhiteShine = new Ellipse2D.Double(shineX - 60, shineY - 20, shineSize, shineSize);
            g2.setColor(Color.WHITE);
            g2.fill(leftWhiteShine);
            g2.setColor(Color.BLACK);
            g2.draw(leftWhiteShine);
            
            Ellipse2D.Double rightWhiteShine = new Ellipse2D.Double(shineX + 60, shineY - 20, shineSize, shineSize);
            g2.setColor(Color.WHITE);
            g2.fill(rightWhiteShine);
            g2.setColor(Color.BLACK);
            g2.draw(rightWhiteShine);
        } else {
            // Closed eyes
            g2.setStroke(new BasicStroke(8));
            g2.setColor(Color.BLACK);
            g2.drawArc(centerX - 100, centerY - 45, 70, 40, 0, 180);
            g2.drawArc(centerX + 30, centerY - 45, 70, 40, 0, 180);
            g2.setStroke(new BasicStroke(5));
        }
    }

    /**
     * Draws a nose represented as a triangle.
     */
    private void drawNose(Graphics2D g2) {
        int noseWidth = 50;
        int noseHeight = 30;
        
        Polygon nose = new Polygon();
        nose.addPoint(centerX - noseWidth / 2, centerY - noseHeight / 2 + 10);
        nose.addPoint(centerX + noseWidth / 2, centerY - noseHeight / 2 + 10);
        nose.addPoint(centerX, centerY + noseHeight / 2 + 10);
        
        g2.setColor(Color.PINK.darker());
        g2.fillPolygon(nose);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(nose);
    }

    /**
     * Draws mouth using two arcs to make a W shape.
     */
    private void drawMouth(Graphics2D g2) {
        int mouthW = 40;
        int mouthH = 40;
        int mouthY = centerY + 7;
        
        g2.drawArc(centerX - mouthW, mouthY, mouthW, mouthH, 0, -180);
        g2.drawArc(centerX, mouthY, mouthW, mouthH, 0, -180);
    }

    /**
     * Draws hat on the cat if the showHat flag is true.
     */
    private void drawHat(Graphics2D g2) {
        if (showHat) {
            int hatBrimW = 100;
            int hatBrimH = 30;
            int hatBrimX = centerX - hatBrimW / 2;
            int hatBrimY = centerY - hatBrimH / 2;
            g2.fillOval(hatBrimX, hatBrimY - 120, hatBrimW, hatBrimH);
            
            int hatTopW = 50;
            int hatTopH = 100;
            int hatTopX = centerX - hatTopW / 2;
            int hatTopY = centerY - hatTopH / 2;
            g2.fillRect(hatTopX, hatTopY - 160, hatTopW, hatTopH);
        }
    }
}