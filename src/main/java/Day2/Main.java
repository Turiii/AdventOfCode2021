package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int foo(ArrayList<String> list) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        for (String line :
                list) {
            String[] s = line.split(" ");
            int value = Integer.parseInt(s[1]);
            if(s[0].contains("forward")){
//                horizontal += value;
                horizontal += value;
                depth += aim * value;
            }
            if(s[0].contains("down")){
//                depth += Integer.parseInt(s[1]);
                aim += value;
            }
            if(s[0].contains("up")){
//                depth -= value;
                aim -= value;
            }
        }
        System.out.println("Horizontal: " + horizontal);
        System.out.println("Depth: " + depth);
        return horizontal * depth;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("src/main/java/Day2/input.txt");
        Scanner scanner = new Scanner(inputFile);
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        System.out.println(foo(list));

    }
}
