package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String mostCommonBit(ArrayList<String> list, int whichBit) {
        int one = 0;
        int zero = 0;
        for (String line :
                list) {
            char[] bits = line.toCharArray();
            char bit = bits[whichBit];
            if (bit == '1') {
                one++;
            } else {
                zero++;
            }
        }
        int max = Math.max(one, zero);
        if (max == one) {
            return "1";
        } else {
            return "0";
        }
    }

    public static int BinaryToDecimal(ArrayList<Integer> bits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int bit :
                bits) {
            StringBuilder append = stringBuilder.append(bit);
        }
        return Integer.parseInt(stringBuilder.toString(), 2);
    }

    public static void partOne(ArrayList<String> list) {

        ArrayList<Integer> gamma_rate = new ArrayList<>();
        ArrayList<Integer> epsilon_rate = new ArrayList<>();

        int length = list.get(0).length();

        for (int i = 0; i < length; i++) {
            int a = Integer.parseInt(mostCommonBit(list, i));
            gamma_rate.add(a);
            if (a == 1) {
                epsilon_rate.add(0);
            } else {
                epsilon_rate.add(1);
            }
        }

        String gamma = gamma_rate.toString();
        int gamma_decimal = BinaryToDecimal(gamma_rate);

        String epsilon = epsilon_rate.toString();
        int epsilon_decimal = BinaryToDecimal(epsilon_rate);

        System.out.println(gamma + " -> " + gamma_decimal);
        System.out.println(epsilon + " -> " + epsilon_decimal);

        int value = gamma_decimal * epsilon_decimal;
        System.out.println(value);
    }

    public static ArrayList<String> remainList(ArrayList<String> list) {
        int length = list.get(0).length();
        int most_common;
        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            most_common = Integer.parseInt(mostCommonBit(list, i));
            for (String line :
                    list) {
                char[] bits = line.toCharArray();
                if (bits[i] == most_common) {
                    temp.add(line);
                }
            }
        }
        return temp;
    }

    public static void partTwo(ArrayList<String> list) {
        ArrayList<String> strings = remainList(list);
        while (strings.size() != 0) {
            remainList(strings);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("src/main/java/Day3/test.txt");
        Scanner scanner = new Scanner(inputFile);
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        partOne(list);
        partTwo(list);

    }
}
