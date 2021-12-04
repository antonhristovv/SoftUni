package Lab.L02Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        this.setArea(Math.PI * this.radius * this.radius);
    }
}
