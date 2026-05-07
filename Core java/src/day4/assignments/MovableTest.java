package day4.assignments;

interface Movable {
 void moveUp();
 void moveDown();
 void moveLeft();
 void moveRight();
}

class MovablePoint implements Movable {
 int x, y;
 int xSpeed, ySpeed;

 MovablePoint(int x, int y, int xSpeed, int ySpeed) {
     this.x = x;
     this.y = y;
     this.xSpeed = xSpeed;
     this.ySpeed = ySpeed;
 }

 public void moveUp() {
     y = y + ySpeed;
 }

 public void moveDown() {
     y = y - ySpeed;
 }

 public void moveLeft() {
     x = x - xSpeed;
 }

 public void moveRight() {
     x = x + xSpeed;
 }

 public String toString() {
     return "Point at (" + x + "," + y + ")";
 }
}

class MovableCircle implements Movable {
 int radius;
 MovablePoint center;

 MovableCircle(int radius, int x, int y, int xSpeed, int ySpeed) {
     this.radius = radius;
     this.center = new MovablePoint(x, y, xSpeed, ySpeed); 
 }

 public void moveUp() {
     center.moveUp();
 }

 public void moveDown() {
     center.moveDown();
 }

 public void moveLeft() {
     center.moveLeft();
 }

 public void moveRight() {
     center.moveRight();
 }

 public String toString() {
     return "circle adius " + radius + "& center " + center.toString();
 }
}
class MovableRectangle implements Movable {
 MovablePoint topLeft;
 MovablePoint bottomRight;

 MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
     topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
     bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
 }

 public void moveUp() {
     topLeft.moveUp();
     bottomRight.moveUp();
 }

 public void moveDown() {
     topLeft.moveDown();
     bottomRight.moveDown();
 }

 public void moveLeft() {
     topLeft.moveLeft();
     bottomRight.moveLeft();
 }

 public void moveRight() {
     topLeft.moveRight();
     bottomRight.moveRight();
 }

 public String toString() {
     return "rect tl " + topLeft.toString() + " , br " + bottomRight.toString();
 }
}

public class MovableTest {
 public static void main(String[] args) {
     
     MovablePoint p1 = new MovablePoint(0, 0, 2, 2);
     System.out.println(p1.toString());
     p1.moveUp();
     p1.moveRight();
     System.out.println("move-up and right" + p1.toString());

     System.out.println("\n---Circle ---");
     MovableCircle c1 = new MovableCircle(5, 10, 10, 3, 3);
     System.out.println(c1.toString());
     c1.moveDown();
     System.out.println("move down" + c1.toString());

     System.out.println("\n--- rectangle ---");
     MovableRectangle r1 = new MovableRectangle(0, 5, 5, 0, 1, 1);
     System.out.println(r1.toString());
     r1.moveLeft();
     System.out.println("move left" + r1.toString());
 }
}
