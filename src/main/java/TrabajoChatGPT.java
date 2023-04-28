import java.util.Scanner;
public class TrabajoChatGPT {

    public class CalculoDigitoVerificadorRut {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String rut;
            do {
                System.out.print("Ingrese el rut (sin puntos ni guión): ");
                rut = sc.next();
            } while (!validarRut(rut));
            int digitoVerificador = calcularDigitoVerificador(rut);
            System.out.println("El dígito verificador es: " + digitoVerificador);
        }

        public static boolean validarRut(String rut) {
            if (rut.matches("\\d{7,8}")) {
                return true;
            } else {
                System.out.println("El rut ingresado no es válido. Debe contener 7 u 8 dígitos.");
                return false;
            }
        }

        public static int calcularDigitoVerificador(String rut) {
            int suma = 0;
            int multiplicador = 2;
            for (int i = rut.length() - 1; i >= 0; i--) {
                suma += Character.digit(rut.charAt(i), 10) * multiplicador;
                multiplicador++;
                if (multiplicador > 7) {
                    multiplicador = 2;
                }
            }
            int division = suma / 11;
            int resto = suma - division * 11;
            int digitoVerificador;
            if (resto == 0) {
                digitoVerificador = 0;
            } else if (resto == 1) {
                digitoVerificador = 'k' - '0'; // Si el resto es 1, el dígito verificador es 'k'
            } else {
                digitoVerificador = 11 - resto;
            }
            return digitoVerificador;
        }
    }
}
