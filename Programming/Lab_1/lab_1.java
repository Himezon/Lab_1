import java.util.*;
import static  java.lang.Math.*;


public class lab_1 {

    public static boolean aInList(long a){ //является-ли a[i] каким-либо из перечисленных значений по условию
        if (a == 5 || a == 11 || a == 13 || a == 19 || a == 23 || a == 25){
            return true;
        }
        else return false;
    }

    public static long[] firstArray (){
        long[] a = new long[23]; //23 - количество long чисел в массиве по условию
        int k = 25;
        for (int i = 0; i < a.length; i++) {
            a[i] = k;
            k--;
        }
        return a;
    }

    public static double[] secondArray(){
        double[] x = new double[18]; // 18 - количество случайных double чисел в массиве по условию
        for (int i = 0; i < x.length; i++){
            x[i] = (Math.random() * (11.0 - (-12.0))) + (-12.0); //рандомизация с заданным диапазоном, всё по синтаксису!
        }
        return x;
    }

    public static double[][] thirdArray(long[] arr, double[] xrr){
        double[][] a = new double[12][18];

        for (int i = 0; i < a.length; i++){
            if (arr[i] == 15){
                for (int j = 0; j < a[i].length; j++) {
                    double x = xrr[j];
                    a[i][j] = pow(pow((x / 2), 3), 0.25 * tan(x)) * (0.5 + pow(log(abs(x)), 2 * asin((x - 0.5) / 23)));
                }
            }
            else if (aInList(arr[i])){
                for (int j = 0; j < a[i].length; j++) {
                    double x = xrr[j];
                    a[i][j] = exp(pow((x - 1) / x, x) / 0.5);
                }
            }
            else {
                for (int j = 0; j < a[i].length; j++) {
                    double x = xrr[j];
                    a[i][j] = pow(pow(sin(pow(0.25 / x, 2)), (double) 1 / 3), (double) 1 / 3);
                }
            }
        }

        return a;
    }

    public static void main(String[] args) {
        long[] a = firstArray();
        double[] x = secondArray();

        System.out.println("Первый массив: " + Arrays.toString(a) + "\n");
        System.out.println("Второй массив: " + Arrays.toString(x) + "\n");
        System.out.println("Третий массив: ");
        for (double[] i : thirdArray(a, x)){
            for (double j : i){
                System.out.printf("%-7.2f", j); //Вылетают NaN-ы в основном из-за того, что местами приходится возводить отрицательное число в дробную степень. Такая уж формула дана
            }
            System.out.println();
        }
    }
}