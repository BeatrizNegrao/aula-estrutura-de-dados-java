package Exercicios_aula2;
//Aula 02 - Recursão
//1) Crie um método recursivo que receba um valor inteiro decimal e retorne uma String com o valor correspondente em binário.
public class EstruturaDadosL2Ex1 {
    public static void main(String[] args) {
        System.out.println("Valor: ");
        decimalToBinario(20);
        System.out.println("");
        }

        public static void decimalToBinario(int valor) {
           if(valor <= 2){
            System.out.println(valor/2);
            System.out.println(valor%2);
           } else{
            decimalToBinario(valor/2);
            System.out.println(valor%2);
           }
        }
}
