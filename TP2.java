import java.text.DecimalFormat;
import java.util.Scanner;

public class TP2 {

    static Scanner read = new Scanner(System.in);

    static double randomize() { // -10 to 10
        return Math.floor(Math.random() * (10 - (-10) + 1) + (-10));// Math.ceil(Math.random() * 10);
    }

    static double randomize0To1() { // 0 => 1
        return Double.parseDouble(new DecimalFormat("##.#").format(Math.random()));
    }

    static double sortie(double x1, double x2, double w0, double w1, double w2) {
        double somme = w0 + (w1 * x1) + (w2 * x2);
        if (somme > 0)
            return 1;
        else
            return 0;
    }

    static void fill(double arr[][]) {
        // filling the first half of the third column with 1's
        for (int i = 0; i < 50; i++) {
            arr[i][2] = 1;
        }
        // filling the second half of the third column with 0's
        for (int i = 50; i < 100; i++) {
            arr[i][2] = 0;
        }
        // filling the first and second column with random data
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = randomize();
            arr[i][1] = randomize();
        }
    }

    static void display(double arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][0] + " | ");
        }
        System.out.println();
        System.out.println("----------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][1] + " | ");
        }
        System.out.println();
        System.out.println("-------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][2] + " | ");
        }
        System.out.println();
        System.out.println("-------------------------");
    }

    public static void main(String args[]) {
        // data matrix
        double arr[][] = new double[100][3];
        // replissage
        fill(arr);
        // displaying filled data
        display(arr);
        // randomizing weights
        double w0 = randomize0To1();
        double w1 = randomize0To1();
        double w2 = randomize0To1();
        System.out.println("w0 = " + w0 + " w1 = " + w1 + " w2 = " + w2);
        System.out.println("-------------------------");
        // displaying results
        for (int i = 0; i < arr.length; i++) {
            if (sortie(arr[i][0], arr[i][1], w0, w1, w2) == arr[i][2]) {
                System.out.println("Le réseau pour cette donné x1=" + arr[i][0] + " x2=" + arr[i][1] + " est confort");
            } else
                System.out.println(
                        "Le réseau pour cette donné x1=" + arr[i][0] + " x2=" + arr[i][1] + " n'est pas confort");
        }
    }
}
