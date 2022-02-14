
package Q03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q03 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int anagramas; //recebe entrada do usuário com o scanner
        System.out.println("Digite a string: ");
        String teste = sc.nextLine();
        anagramas = testaString(teste, teste.length()); //testa quantos anagramas a string contém
        
        System.out.println("A string " + teste + " contém " + anagramas + " anagramas!");
        
    }
    
    //método testa se duas strings são anagramas
    private static boolean isAnagrama(String a, String b){
        
        //coloca ambas strings in char arrays
        char[] strA = a.toCharArray();
        char[] strB = b.toCharArray();
        
        //usa o método sort da classe arrays para ordenar os arreios de caracteres
        Arrays.sort(strA);
        Arrays.sort(strB);
        
        /*retorna o resultado da comparação entre os dois arreios de caracteres 
        ordenados, se ambas as strings iniciais continham os mesmos caracteres, 
        o método retorna true*/
        return Arrays.equals(strA, strB);
    }
    
    private static int testaString(String s, int p){
        int anagramas = 0;
        ArrayList<String> grupos = new ArrayList();
        //coloca a string inteira num arrailist em grupos de p caracteres
        for(int i=0;i<=s.length()-p;i++){
            grupos.add(s.substring(i, i+p));
        }
        /*percorre o arraylist de strings e conta quantos são anagramas usanso o método
        isAnagrama(), se o método retornar verdadeiro incrementa anagramas*/
        for(int i =0;i<grupos.size();i++){
            for(int j = i+1;j<grupos.size();j++){
                if(isAnagrama(grupos.get(i), grupos.get(j))){
                    //imprime as strings comparadas com isAnagrama, usado para fins de teste
                    //System.out.println(grupos.get(i)+"|"+grupos.get(j)); 
                    anagramas++;
                }
            }
        }
        /*Testa se p = 1, o número minimo de caracteres na string, se for retorna
        a variável anagramas, se não, retorna a variável anagramas acrescido de
        testaString com p-1 até que p chegue a 1 a a recursão termine*/
        if(p == 1){
            return anagramas;
        }else{
            return anagramas + testaString(s, p-1);
        }
        
    }
}
