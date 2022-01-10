package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int CounterLarger(ArrayList<Integer> list) {
        int previous = -1;
        int actual = 0;
        int counterLarger = 0;
        for (int i = 1; i < list.size(); i++) {
            previous = list.get(i - 1);
            actual = list.get(i);
//            System.out.print(actual);
            if (actual > previous) {
//                System.out.print("\tIncreasing\n");
                counterLarger += 1;
            } else {
//                System.out.print("\tDecreasing\n");
            }
        }
        return counterLarger;
    }

    public static int Counter(ArrayList<Integer> list) {
        int A = 0;
        int B = 0;
        int C = 0;
        int previous = 0;
        int actual = 0;
        int counter = 0;
        ArrayList<Integer> listOfSums = new ArrayList<>();
        for (int i = 0; i < list.size()-2; i++) {
            if(i+2 <= list.size()-1){
                A = list.get(i);
                B = list.get(i + 1);
                C = list.get(i + 2);
                actual = A + B + C;
                listOfSums.add(actual);
                if(i != 0){
                    previous = listOfSums.get(i-1);
                    if(actual>previous){
                        counter += 1;
                    }
                }

            }
        }
        return counter;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("src/main/java/Day1/input.txt");
        Scanner scanner = new Scanner(inputFile);

        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        System.out.println("Counter: " + CounterLarger(list));

        System.out.println(Counter(list));


    }
}
