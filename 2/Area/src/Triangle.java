public class Triangle {
    public double area(ShapeArgs args) {
        return (args.getTriangleWidth() * args.getTriangleHeight()) / 2;
    }

    public double perimeter(ShapeArgs args) {
        return args.getRectangleWidth() + args.getTriangleLeftSide() + args.getTriangleRightSide();
    }
}
