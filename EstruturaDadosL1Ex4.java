//Aula 01 - Vetores e Matrizes 
//4) Crie um método que receba como parâmetro um número decimal, converta esse número para binário e retorne na forma de um vetor com 8 posições.
public class EstruturaDadosL1Ex4 {
    public static void main(String[] args) {

        int valorDecimal = 20;
        System.out.println("Decimal: ");
        System.out.println(valorDecimal + " ");

        System.out.println("-------------------------");
        int[] binario = converteToBinario(valorDecimal);

        System.out.println("Binário: ");
        for (int bit : binario) {
            System.out.print(bit);
        }

    }

    public static int[] converteToBinario(int valorDecimal) {
        int binario[] = new int[8];
        for (int i = 7; i >= 0; i--) { //Começa da última posição para a primeira, para armazenar os bits corretamente, assim como funciona no cálculo de conversão.
            binario[i] = valorDecimal % 2;   // Armazena o resto da divisão por 2 para obter o bit binário (0 ou 1)
            valorDecimal = valorDecimal / 2; // Divide o valorDecimal por 2 para continuar a conversão

        }
        return binario;
    }
}
