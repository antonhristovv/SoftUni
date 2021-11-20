package Lab.L02PointInRectangle;

public class Rectangle {
    private final Point pointA;
    private final Point pointC;

    public Rectangle(Point pointA, Point pointC) {
        this.pointA = pointA;
        this.pointC = pointC;
    }

    public boolean contains(Point point) {
        int xCoordinate = point.getXCoordinate();
        int yCoordinate = point.getYCoordinate();
        return xCoordinate >= pointA.getXCoordinate() && xCoordinate <= pointC.getXCoordinate() && yCoordinate >= pointA.getYCoordinate() && yCoordinate <= pointC.getYCoordinate();
    }
}
