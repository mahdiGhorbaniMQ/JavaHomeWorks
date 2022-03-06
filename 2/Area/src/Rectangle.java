public class Rectangle extends Shape {

    public double area(ShapeArgs args) {
        return args.getRectangleWidth() * args.getRectangleHeight();
    }

    public double perimeter(ShapeArgs args) {
        return (args.getRectangleWidth() + args.getRectangleHeight()) * 2;
    }
}
