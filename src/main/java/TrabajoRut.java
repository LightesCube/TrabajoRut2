package org.example;

import java.util.Scanner;

public class TrabajoRut {

    private static int[] cadenaMultiplicadora;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String rut="12345678-9";
        String rutNuevo=rutSinVerificador(rut);
        String rutInvertido=invertirRut(rutNuevo);
        String rutMultiplicado=multiplicarRut(rutNuevo);
        System.out.println(rutMultiplicado);
        System.out.println(rutNuevo);
        System.out.println(rutInvertido);
    }

    public static String invertirRut(String rut) {
        String rutInvertido="";
        for (int i = 0; i < rut.length(); i++) {
            rutInvertido+= rut.charAt(rut.length()-1-i);
        }
        return rutInvertido;
    }
    public static String rutSinVerificador(String rut) {
        String[] rutDividido = rut.split("-");
        return rutDividido[0];
    }
    public static String multiplicarRut(String rut){
        int[] cadenaMultiplicadora = {2,3,4,5,6,7};
        System.out.println(rut);
        String nuevoRut="";
        int acumulador=0;
        int digitoNuevo=0;
        for (int i = 0; i < rut.length(); i++) {
            digitoNuevo=Integer.parseInt(String.valueOf(rut.charAt(i)))*cadenaMultiplicadora[acumulador];
            nuevoRut+="["+String.valueOf(digitoNuevo)+"]";
            if(i>cadenaMultiplicadora.length-1) {
                acumulador = 0;
                acumulador++;
                System.out.println(cadenaMultiplicadora[acumulador]);
            }
        }
        return nuevoRut;
    }
}


