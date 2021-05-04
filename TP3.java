import java.text.DecimalFormat;

public class TP3 {

    static double arr[][] = new double[100][3];
    static double w0, w1, w2;

    static double randomize() { // -10 to 10
        return Math.floor(Math.random() * (10 - (-10) + 1) + (-10));
    }

    static double randomizeWeight() { // -1 => 1
        double random = Double.parseDouble(new DecimalFormat("##.#").format(Math.random() * (1 - (-1) + 1) + (-1)));
        if (random <= 1 && random >= -1)
            return random;
        else
            return randomizeWeight();
    }

    static double sortie(double x1, double x2, double w0, double w1, double w2) {
        double somme = w0 + (w1 * x1) + (w2 * x2);
        if (somme > 0)
            return 1;
        else
            return 0;
    }

    static void fill() {
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

    static void display() {
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

    static void randomizeW() {
        w0 = randomizeWeight();
        w1 = randomizeWeight();
        w2 = randomizeWeight();
        System.out.println("w0 = " + w0 + " w1 = " + w1 + " w2 = " + w2);
        System.out.println("-------------------------");
    }

    static int percentage = 0;

    static void test() {
        for (int i = 0; i < arr.length; i++) {
            if (sortie(arr[i][0], arr[i][1], w0, w1, w2) == arr[i][2]) {
                System.out.println("Le réseau pour cette donné x1=" + arr[i][0] + " x2=" + arr[i][1] + " est confort");
                percentage++;
            } else
                System.out.println(
                        "Le réseau pour cette donné x1=" + arr[i][0] + " x2=" + arr[i][1] + " n'est pas confort");
        }
        System.out.println(percentage +"% est confort pour les poids initial.");
    }

    static double epcilon = 0.1;
    static double x0 = 1;

    static void hebb (){
        System.out.println("Hebb: ");
        for (int i = 0; i < arr.length; i++) {
            double y = sortie(arr[i][0], arr[i][1], w0, w1, w2);
            double d = arr [i][2];
            double x1 = arr[i][0];
            double x2 = arr[i][1];
            if (y != d) {
                // modification de poids
                w0 += epcilon * y * x0;
                w1 += epcilon * y * x1;
                w2 += epcilon * y * x2;
                // changing the format
                w0 = Double.parseDouble(new DecimalFormat("##.#").format(w0));
                w1 = Double.parseDouble(new DecimalFormat("##.#").format(w1));
                w2 = Double.parseDouble(new DecimalFormat("##.#").format(w2));
                test2();
            } else ;
        }
    }

    static void widrow() {
        System.out.println("Windrow :");
        for (int i = 0; i < arr.length; i++) {
            double y = sortie(arr[i][0], arr[i][1], w0, w1, w2);
            double d = arr [i][2];
            double x1 = arr[i][0];
            double x2 = arr[i][1];
            if (y != d) {
                // modification de poids
                w0 += epcilon * (d - y) * x0;
                w1 += epcilon * (d - y) * x1;
                w2 += epcilon * (d - y) * x2;
                // changing the format
                w0 = Double.parseDouble(new DecimalFormat("##.#").format(w0));
                w1 = Double.parseDouble(new DecimalFormat("##.#").format(w1));
                w2 = Double.parseDouble(new DecimalFormat("##.#").format(w2));
                test2();
            } else ;
        }
    }

    static void test2 (){
        percentage = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sortie(arr[i][0], arr[i][1], w0, w1, w2) == arr[i][2]) {
                percentage++;
            }
        }
        System.out.println(percentage + "% est confort pour les poids w0="+ w0 +" w1="+ w1+ " w2="+ w2);
    }

    public static void main(String args[]) {
        // replissage aléatoire
        fill();
        // displaying filled data
        display();
        // randomizing weights
        randomizeW();
        // test de données
        test();
        hebb();
        widrow();
    }
}
