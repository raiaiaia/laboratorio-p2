/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Danielly Rayanne Macedo Lima - 122110702
 */
 
 import java.util.Scanner;
 
 public class MaiorMenorPalavras{
 	public static void main(String[] args){
 		
 		Scanner sc = new Scanner(System.in);
 		
 		String palavra1 = sc.nextLine();
 		String palavra2 = sc.nextLine();
 		
 		
 		if(palavra1.length() > palavra2.length()){
 			System.out.println(palavra2);
 			System.out.println(palavra1);
 		}
 		
 		if(palavra1.length() < palavra2.length()){
 			System.out.println(palavra1);
 			System.out.println(palavra2);
 		}
 		
 		if(palavra1.length() == palavra2.length()){
 			System.out.println(palavra1);
            System.out.println(palavra1);
 		}
 		
 	}
 
 }
