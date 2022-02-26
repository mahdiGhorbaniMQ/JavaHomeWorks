public class Circle extends Shape{
    public double area(ShapeArgs args) {
        return Math.pow(args.getCircleReduce(),2) * Math.PI;
    }

    public double perimeter(ShapeArgs args) {
        return args.getCircleReduce()* 2 * Math.PI;
    }
}
