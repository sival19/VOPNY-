package vop;

import java.util.Arrays;
import java.util.Random;

/**
 * OOP test eksamen f09 opg 1
 *
 * @author erso
 */
public class ArrayManipulation {

    public static void main(String[] arg) {
        Random generator = new Random(222);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        System.out.println("Input:  " + Arrays.toString(array));

        ArrayManipulation arrMani = new ArrayManipulation();

        int[] result = arrMani.evenOdd(array);
        System.out.println("Output: " + Arrays.toString(result));

    }

    public int[] evenOdd(int[] array) {
        int odd = 0;
        int even = array.length - 1;
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0){
                temp[odd] = array[i];
                odd++;
            }
            else {
                temp[even] = array[i];
                even--;
            }



        }
        System.out.println(Arrays.toString(temp));
        sort(temp,odd);
        return temp;

    }

    private void sort(int[] array, int splitIndex) {
        Arrays.sort(array,0,splitIndex);
        for (int i = splitIndex; i < array.length; i++) {
            array[i] = -array[i];

        }
        Arrays.sort(array,splitIndex, array.length);

        for (int i = splitIndex; i < array.length; i++) {
            array[i] = -array[i];

        }

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    
