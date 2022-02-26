public class ShapeArgs {

    private double circleReduce;
    private double rectangleWidth;
    private double rectangleHeight;
    private double triangleWidth;
    private double triangleHeight;
    private double triangleRightSide;
    private double triangleLeftSide;
    private double squareWidth;


    public static ShapeArgs circleArgs(double reduce){
        return new ShapeArgs(
                reduce,
                0,
                0,
                0,
                0,
                0,
                0,
                0
        );
    }
    public static ShapeArgs triangleArgs(
            double triangleWidth,
            double triangleHeight,
            double triangleLeftSide,
            double triangleRightSide
    ){
        return new ShapeArgs(
                0,
                0,
                0,
                triangleWidth,
                triangleHeight,
                triangleLeftSide,
                triangleRightSide,
                0
        );
    }
    public static ShapeArgs squareArgs(double squareWidth){
        return new ShapeArgs(
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                squareWidth
        );
    }
    public static ShapeArgs rectangleArgs(double rectangleWidth, double rectangleHeight){
        return new ShapeArgs(
                0,
                rectangleWidth,
                rectangleHeight,
                0,
                0,
                0,
                0,
                0
        );
    }

    public ShapeArgs(){}
    public ShapeArgs(
            double circleReduce,
            double rectangleWidth,
            double rectangleHeight,
            double triangleWidth,
            double triangleHeight,
            double triangleLeftSide,
            double triangleRightSide,
            double squareWidth
    ){
        this.circleReduce = circleReduce;
        this.rectangleWidth = rectangleWidth;
        this.rectangleHeight = rectangleHeight;
        this.triangleWidth = triangleWidth;
        this.triangleHeight = triangleHeight;
        this.triangleLeftSide = triangleLeftSide;
        this.triangleRightSide = triangleRightSide;
        this.squareWidth = squareWidth;
    }

    public double getCircleReduce() {
        return circleReduce;
    }

    public double getRectangleWidth() {
        return rectangleWidth;
    }

    public double getRectangleHeight() {
        return rectangleHeight;
    }

    public double getTriangleWidth() {
        return triangleWidth;
    }

    public double getTriangleHeight() {
        return triangleHeight;
    }

    public double getTriangleLeftSide() {
        return triangleLeftSide;
    }

    public double getTriangleRightSide() {
        return triangleRightSide;
    }

    public double getSquareWidth() {
        return squareWidth;
    }
}
