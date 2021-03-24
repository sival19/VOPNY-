package vop;

import java.util.Arrays;

public class CircularBuffer {

    int putIndex = 0;
    int getIndex = 0;
    boolean valueSet = false;
    private final Integer[] buffer;
    private final int size;


    public CircularBuffer(int size) {
        buffer = new Integer[size];
        this.size = size;

    }

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("GOTHA");
            }

        }
        int value;
        value = buffer[getIndex];
        buffer[getIndex] = null;
        System.out.println("get: " + value);
        valueSet = false;
        getIndex = (getIndex + 1) % size;

        notifyAll();
        return value;

    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("INTERUPPPPPPTEEEEED");
            }

        }
        this.buffer[putIndex % size] = n;
        System.out.println("put: " + buffer[putIndex % size] + "\n");
        putIndex++;
        valueSet = true;
        notifyAll();

    }


    public String toString() {
        return "Buff: " + Arrays.toString(buffer);
    }
}

