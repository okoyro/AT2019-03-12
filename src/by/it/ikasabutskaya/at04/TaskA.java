package by.it.ikasabutskaya.at04;

import java.util.Scanner;

import static by.it.ikasabutskaya.at04.Helper.*;

public class TaskA {
    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9 ; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double start = array[0];
        double stop = array[array.length-1];
        InOut.printArray(array,"V",5);
        Helper.sort(array);
        InOut.printArray(array,"V",4);
        for (int i = 0; i < array.length; i++) {
            if (array[i]==start) {
                System.out.println("Index of the first element="+i);
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i]==stop) {
                System.out.println("Index of the last element="+i);
                break;
            }
        }
    }




    public static void main(String[] args) {
        printMulTable();
        Scanner scan = new Scanner(System.in);
        String s=scan.nextLine();
        buildOneDimArray(s);
    }
}
