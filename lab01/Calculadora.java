/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Danielly Rayanne Macedo Lima - 122110702
 */
 
import java.util.Scanner;

public class Calculadora{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String operador = sc.nextLine();
		
		//System.out.println(operador.getClass().getSimpleName());
		
		if(operador.equals("+")){
			float n1 = sc.nextFloat();
			float n2 = sc.nextFloat();
			
			float soma = n1 + n2;
			
			System.out.println("RESULTADO: " + soma);	
			
		}else if(operador.equals("-")){
			float n1 = sc.nextFloat();
			float n2 = sc.nextFloat();
			
			float diferenca= n1 - n2;
			
			System.out.println("RESULTADO: " + diferenca);
			
		}else if(operador.equals("*")){
			float n1 = sc.nextFloat();
			float n2 = sc.nextFloat();
			
			float multiplicacao = n1 * n2;
			
			System.out.println("RESULTADO: " + multiplicacao);
			
		}else if(operador.equals("/")){
			float n1 = sc.nextFloat();
			float n2 = sc.nextFloat();
			
			if (n2 != 0){
				float divisao= n1 / n2;
				System.out.println("RESULTADO: " + divisao);
			}else{
				System.out.println("ERRO");
			}
		}else{
		
			System.out.println("ENTRADA INVALIDA");
		}	
	}
}
