package itm.oss;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return (double) a / b;
    }

public int getNextPrime(int num){
    int index = num;
    while(true){
        index +=1;
        if (isPrime(index)){
            return index;
        }
    }

}

protected boolean isPrime(int num){

    if (num<=1){
        return false;
    } 

    for (int i = 2; i < num; i++){
        if (num % i == 0){
            return false;
        }
    }
    return true;
}
}
