/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Danielly Rayanne Macedo Lima - 122110702
 */

import java.util.Scanner;


public class Passou{

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        float n1 = sc.nextFloat();
        float n2 = sc.nextFloat();

        float media = ( n1 + n2 )/2;

        if (media >= 7){

           System.out.println("pass: True!");

        }else{

          System.out.println("pass: False!");
        }

    }

}
