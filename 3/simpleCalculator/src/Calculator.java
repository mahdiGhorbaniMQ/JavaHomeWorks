public class Calculator {
    public static double calculate(double a, char operator, double b) throws Exception {
        switch (operator){
            case '+': {
                return a+b;
            }
            case '-': {
                return a-b;
            }
            case '*': {
                return a*b;
            }
            case '/': {
                if(b!=0){
                    return a/b;
                }
                throw new Exception("Error: Second number can't be zero!");
            }
            default: {
                throw new Exception("Error: The operator is not defined!");
            }
        }
    }
}
