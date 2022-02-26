public class Square {
    public double area(ShapeArgs args) {
        return Math.pow(args.getSquareWidth(),2);
    }

    public double perimeter(ShapeArgs args) {
        return args.getSquareWidth() * 4;
    }
}
