package day4.assignments;

interface Polygon {
    double getArea();
    default double getPerimeter(int... s) {
        double sum = 0;
        for (int i = 0; i < s.length; i++) {
            sum = sum + s[i];
        }
        return sum;
    }
    static String shapeInfo() {
        return "shape from plygn interface";
    }
}

class Rectangle implements Polygon {
    double len;
    double wi;

    Rectangle(double len, double wi) {
        this.len = len;
        this.wi = wi;
    }

    public double getArea() {
        return len * wi;
    }
}

class Triangle implements Polygon {
    double b;
    double h;

    Triangle(double b, double h) {
        this.b = b;
        this.h = h;
    }

    public double getArea() {
        return 0.5 * b * h;
    }
}

public class PolygonTest {
    public static void main(String[] args) {
        System.out.println(Polygon.shapeInfo());
        Rectangle r = new Rectangle(5.0, 4.0);
        System.out.println("rect area" + r.getArea());
        System.out.println("rect perimeter " + r.getPerimeter(5, 4, 5, 4));

        System.out.println();

        Triangle t = new Triangle(3.0, 4.0);
        System.out.println("triangle area" + t.getArea());
        System.out.println("triangle perimeterp " + t.getPerimeter(3, 4, 5));
    }
}