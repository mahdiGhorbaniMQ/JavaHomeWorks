import java.util.Scanner;

public class Main {

    public static int getShape(Scanner scanner){
        System.out.println("for square insert 1");
        System.out.println("for rectangle insert 2");
        System.out.println("for triangle insert 3");
        System.out.println("for circle insert 4");
        System.out.print("shape is: ");

        int out = scanner.nextInt();
        if (out<5 && out>0)
            return out;
        return getShape(scanner);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int shape = getShape(scanner);
        double area, perimeter;
        switch (shape){
            case 1:{
                System.out.print("insert width: ");
                double width = scanner.nextDouble();
                Square square = new Square();
                area = square.area(ShapeArgs.squareArgs(width));
                perimeter = square.perimeter(ShapeArgs.squareArgs(width));
                break;
            }
            case 2:{
                System.out.print("insert width: ");
                double width = scanner.nextDouble();
                System.out.print("insert height: ");
                double height = scanner.nextDouble();
                Rectangle rectangle = new Rectangle();
                area = rectangle.area(ShapeArgs.rectangleArgs(width,height));
                perimeter = rectangle.perimeter(ShapeArgs.rectangleArgs(width,height));
                break;
            }
            case 3:{
                System.out.print("insert height: ");
                double height = scanner.nextDouble();
                System.out.print("insert width: ");
                double width = scanner.nextDouble();
                System.out.print("insert right side: ");
                double rightSide = scanner.nextDouble();
                System.out.print("insert left side: ");
                double leftSide = scanner.nextDouble();
                Triangle triangle = new Triangle();
                area = triangle.area(ShapeArgs.triangleArgs(width,height,rightSide,leftSide));
                perimeter = triangle.perimeter(ShapeArgs.triangleArgs(width,height,rightSide,leftSide));
                break;
            }
            default:{
                System.out.print("insert reduce: ");
                double reduce = scanner.nextDouble();
                Circle circle = new Circle();
                area = circle.area(ShapeArgs.circleArgs(reduce));
                perimeter = circle.perimeter(ShapeArgs.circleArgs(reduce));
                break;
            }
        }

        System.out.println("Area is: "+ area);
        System.out.println("Perimeter is: "+ perimeter);
    }
}
