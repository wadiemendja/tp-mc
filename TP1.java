import java.util.Scanner;

public class TP1 {
    static double sortie (double entre1, double entre2,double w0, double w1, double w2) {
        double somme = w0 + entre1 * w1 + entre2 * w2;
        if (somme > 1) return 1; else return 0;
    }
    public static void main(String args []) {
        Scanner read = new Scanner (System.in);
        System.out.print("Entrre1 : ");
        double entre1 = read.nextDouble();
        System.out.print("Entre2 : ");
        double entre2 = read.nextDouble();
        System.out.print("w0 : ");
        double w0 = read.nextDouble();
        System.out.print("w1 : ");
        double w1 = read.nextDouble();
        System.out.print("w1 : ");
        double w2 = read.nextDouble();
        double s = sortie(entre1, entre2, w0, w1, w2);
        System.out.print("La sortie: " + s);
        read.close();
    }
}