import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();

        System.out.println(calc(s));
    }

    public static String calc(String s) {
        s = s.replace(" ", "");

        String[] a = s.split("[\\-*/+]");
        if (a.length != 2) throw new RuntimeException("ERROR");
        String res;
        int result = 0;


        boolean isRim1 = false;
        boolean isRim2 = false;

        boolean isAllRim = true;

        int arab1 = -1;
        int arab2 = -1;

        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        for (int i = 0; i < rim.length; i++) {
            if (a[0].equals(rim[i])) {
                isRim1 = true;
                arab1 = i + 1;
            }
            if (a[1].equals(rim[i])) {
                isRim2 = true;
                arab2 = i + 1;
            }
        }

        if (isRim2 && isRim1) {
            isAllRim = true;
        } else if (!isRim1 && !isRim2) {
            isAllRim = false;
            try {
                arab1 = Integer.parseInt(a[0]);
                arab2 = Integer.parseInt(a[1]);
            } catch (Exception e) {
                throw new RuntimeException("ERROR");
            }
        } else {
            throw new RuntimeException("ERROR");
        }

        if (arab1 > 10 || arab2 > 10 || arab1 < 1 || (arab2 < 1)) throw new RuntimeException("ERROR");

        if (isAllRim == false) {
            if (s.contains("+")) result = arab1 + arab2;
            if (s.contains("*")) result = arab1 * arab2;
            if (s.contains("/")) result = arab1 / arab2;
            if (s.contains("-")) result = arab1 - arab2;
            return Integer.toString(result);
        } else {
            if (s.contains("+")) result = arab1 + arab2;
            if (s.contains("*")) result = arab1 * arab2;
            if (s.contains("/")) result = arab1 / arab2;
            if (s.contains("-")) result = arab1 - arab2;
            if (result < 1) throw new RuntimeException("ERROR");
            res = rim[result - 1];
            return res;
        }
    }
}