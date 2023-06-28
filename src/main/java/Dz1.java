import java.util.Arrays;
import java.util.Random;

/*
 * 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
 * 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
 * 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в
 * массив m1
 * 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и
 * сохранить в массив m2
 */

public class Dz1 {
    public static void main(String[] args) {



        int i = getRandom(0, 2000);
        System.out.println(i);
        int n = seniorBit_1(i);
        System.out.println(n);
        int z = seniorBit_2(i);
        System.out.println(z);
        int m = seniorBit_3(i);
        System.out.println(m);
        int[] m1 = multiplesArray(i, n);
        System.out.println(Arrays.toString(m1));
        int[] m2 = nonMultiplesArray(i, n);
        System.out.println(Arrays.toString(m2));

    }
    static int getRandom (int min_n, int max_n){
        Random random = new Random();
        System.out.print("Случайное число = ");
        return random.nextInt(min_n, max_n);
    }
    static int seniorBit_1(int num){
        int count = 0;
        while (num >= 2)
        {
            count++;
            num /= 2;
        }
        System.out.print("Номер старшего бита = ");
        return count;
    }
    static int seniorBit_2(int q){
        int t = 0;
        while(q > 1) {
            q >>= 1;
            t++;
        }
        System.out.print("Номер старшего бита = ");
        return t;
    }
    static int seniorBit_3(int r) {
        int t = Integer.toBinaryString(r).length()-1;
        System.out.print("Номер старшего бита n = ");
        return t;
    }
    static int[] multiplesArray(int a, int b){
        int size = 0;
        for (int j = a; j < Short.MAX_VALUE; j++){
            if (j%b == 0) size++;
        }
        int[] m1 = new int[size];
        int k = 0;
        for (int j = a; j < Short.MAX_VALUE; j++){
            if (j%b == 0) {
                m1[k] = j;
                k++;
            }
        }
        return m1;
    }

    static int[] nonMultiplesArray(int a, int b){
        int size = 0;
        for (int j = Short.MIN_VALUE; j < a; j++){
            if (j%b != 0) size++;
        }
        int[] m2 = new int[size];
        int k = 0;
        for (int j = Short.MIN_VALUE; j < a; j++){
            if (j%b != 0) {
                m2[k] = j;
                k++;
            }
        }
        return m2;
    }

}
