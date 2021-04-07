package vop;

import java.util.Arrays;
import java.util.Random;

/**
 * OOP test eksamen f09 opg 1
 * @author erso
 */
public class ArrayManipulation {

    public int[] evenOdd(int[] array, int left, int right){
        int temp;
        if(left>=right)
            return array;
        else if (array[left]%2!=0 && array[right]%2==0){
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            return evenOdd(array, left +=1,right -=1);

        }
        else{
            if(array[right]%2!=0){
                return evenOdd(array, left, right -=1); //if right odd decrease index
            }
            if(array[left]%2==0){
                return evenOdd(array, left+=1, right); //if left even increase
            }

            return array;
        }
    }

    public int[] evenOdd(int[] array) {
        int left = 0;
        int right = array.length - 1;
        return evenOdd(array, left, right);


//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void sort(int [] array, int splitIndex){


//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String [] arg){
        Random generator = new Random(222);
        int[] array = new int [10];
        for(int i = 0; i < array.length; i++){
            array[i] = generator.nextInt(100);
        }
        System.out.println("Input:  "+Arrays.toString(array));

        ArrayManipulation arrMani = new ArrayManipulation();
    
        int[] result = arrMani.evenOdd(array);
        System.out.println("Output: " +Arrays.toString(result));

    }
}

    
