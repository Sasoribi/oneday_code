package io.sasoribi.algorithm.calculate;

public class MyPow {

    //50. Pow(x, n)
    public double myPow(double x, int n) {
        long correct = n;
        if (correct == 1)
            return x;

        if (correct == 0) {
            return 1;
        }

        // 计算倒数(n<0),int = -2147483648 时会导致 x == -x,所以需要使用long类型
        if (correct < 0) {
            correct = -correct;
            x = 1 / x;
        }
        double result = myPow(x, (int) (correct / 2));

        return correct % 2 == 0 ? result * result : result * result * x;
    }
}
