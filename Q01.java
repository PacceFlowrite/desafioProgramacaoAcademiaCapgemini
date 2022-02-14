package Q01;

import java.util.Scanner;

public class Q01 {
    static Scanner sc = new Scanner(System.in); 
    //Criando um scanner para pegar os dados do usuário
    
    public static void main(String[] args){
        System.out.println("Digite um número: "); //Pede dados ao usuário
        if(sc.hasNextInt()){
            int num = sc.nextInt();
            int ast = 1;
            String linha = ""; //variável que será impressa

            for(int i=0; i<num; ++i){ //Cria as linhas
                for(int j = 0; j<num;j++){ //Cria os caracteres em cada coluna
                    if((num-ast) <= j){ //avalia se o caractere na posição j da linha i deve ser um espaço ou um *
                        linha = linha + "*";
                    }else{
                        linha = linha + " ";
                    }
                }
                System.out.println(linha); //Imprime a váriável linha no console
                ast++; //aumenta o número de asteríscos na próxima iteração
                linha = ""; //"limpa" a variável linha para ser usada na próxima iteração.
            }
        }
    }
}
