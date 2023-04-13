/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Danielly Rayanne Macedo Lima - 122110702
 */
 
import java.util.Scanner;


public class AcimaDaMedia{
	public static void main(String[] args) {
        	Scanner sc = new Scanner(System.in);
        	
        	String linha = sc.nextLine();
        	
        	for (String numString : linha.split(" ")) {  
    		     System.out.println("num:" + numString);
		}

	}
}
