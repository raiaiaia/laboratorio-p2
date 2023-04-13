/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Danielly Rayanne Macedo Lima - 122110702
 */

package lp2.lab01; 

public class IdadePreferencialInteligente {
    public static void main(String[] args) {  // Definindo uma função
        int anoAtual = 2023;
        int anoNascimento = 2002;
        boolean gravida = true;
        int criancaColo = 1;
        
        int idade = anoAtual - anoNascimento;
        
        if (idade >= 60) {
            System.out.println("Voce tem " + idade
                   + " anos. Voce pode usar o atendimento especial.");
        } else {
            System.out.println("Voce tem " + idade + " anos. Voce ainda nao pode usar o atendimento especial.");
        }
        
        
        if (gravida){
            System.out.println("Preferencial Gestante.");
    	} else {
            System.out.println("Voce não tem prioridade de Gestante.");
        }
        
        if(criancaColo > 0){
           System.out.println("Preferencial pois está com " + criancaColo + " crianças de colo.");
        } else {
            System.out.println("Voce não tem prioridade de Criança de colo.");
        }
   }
}

