public class Number implements MyInteger{

    private int number;

    public Number(){}
    public Number(int number){
        this.number = number;
    }

    @Override
    public boolean isEven() {
        return this.number%2 == 0;
    }

    @Override
    public boolean isOdd() {
        return this.number%2 == 1;
    }

    @Override
    public boolean isNegative() {
        if (isZero()) return false;

        return Math.abs(this.number) != this.number;
    }

    @Override
    public boolean isPositive() {
        if (isZero()) return false;
        return Math.abs(this.number) == this.number;

    }

    @Override
    public boolean isZero() {
        return this.number == 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
