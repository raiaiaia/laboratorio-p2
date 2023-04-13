/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Danielly Rayanne Macedo Lima - 122110702
 */
 
 import java.util.Scanner;
 
 public class Pixels{
 	public static void main(String[] args){
 	Scanner sc = new Scanner(System.in);
 	
 	
 	int R, G, B;
 	
 	R = sc.nextInt();
 	G = sc.nextInt();
 	B = sc.nextInt();
 	 	
 	if(R <= 128 -1 || G <= 128 -1|| B <= 128 -1){
 		System.out.println("PRETO");
 	}else if(R >= 128 || G >= 128 || B >= 128){
 		System.out.println("BRANCO");
 	}
 	
 	}
 
 }
