package Q02;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Q02 {
    
    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args){
        String senha;
        do{
            System.out.println("Digite sua senha: ");
            senha = sc.nextLine();
        }while(!senhaSegura(senha)); //método avalia se a senha digitada pelo usuário é válida.
        System.out.println("Senha segura!"); //O programa só sairá do loop se e somente se a senha digitada for segura
    }

    private static boolean senhaSegura(String senha) {
        //criando e iniciando as variáveis necessárias para os testes
        String cEspeciais = "!@#$%^&*()-+";
        boolean teste = false;
        boolean comprimento = false;
        boolean digito = false;
        boolean maiusculo = false;
        boolean minusculo = false;
        boolean especial = false;

        for(int i=0;i<senha.length();i++){ //verificando a string caracter por caracter
            if(Character.isUpperCase(senha.charAt(i))) maiusculo = true; //verifica se o character na posição i é maiusculo
            if(Character.isLowerCase(senha.charAt(i))) minusculo = true; //o mesmo acima mas minúsculo
            if(Character.isDigit(senha.charAt(i))) digito = true; //o mesmo acima mas com dígitos
            for(int j = 0; j<cEspeciais.length(); j++){ //verifica se o caracter na posição i da senha é o mesmo da posição j da string de caracteres especiais
                if(senha.charAt(i)== cEspeciais.charAt(j)) especial = true;
            }
        }
        if(senha.length()>5) comprimento = true;
        
        teste = comprimento && digito && maiusculo && minusculo && especial; //agrupa todos os resultados dos testes anteriores em uma única variável de retorno.
        if(!teste) System.out.println("Senha insegura!"); //dá retornos ao usuário se a senha não for segura e aconselha como melhorá-la
        if(!comprimento){
            int len = senha.length();
            len = 6-len;
            System.out.println("A senha precisa de mais " + len + " caracteres!");
        }
        if(!digito) System.out.println("A senha deve conter pelo menos um dígito!");
        if(!maiusculo)System.out.println("A senha deve conter pelo menos um caracter maiúsculo!");
        if(!minusculo)System.out.println("A senha deve conter pelo menos um caracter minusculo!");
        if(!especial)System.out.println("A senha deve conter pelo menos um caracter especial!");

        return teste;
    }
}
