package E01ClassBox;

public class Box {
    //length, width and height
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    //A box’s side should not be zero or a negative number.
    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    //Surface Area = 2lw + 2lh + 2wh
    public double calculateSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    //Lateral Surface Area = 2lh + 2wh
    public double calculateLateralSurfaceArea() {
        return 2 * (length * height + width * height);
    }

    //Volume = lwh
    public double calculateVolume() {
        return length * width * height;
    }
}
