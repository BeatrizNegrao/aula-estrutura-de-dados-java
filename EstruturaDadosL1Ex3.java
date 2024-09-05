// Aula 01 - Vetores e Matrizes
// 3) Crie um método que receba como parâmetro um número binário na forma de um vetor com 8 posições e retorne esse número convertido para decimal.
public class EstruturaDadosL1Ex3 {
    public static void main(String[] args) {
        System.out.println("Binário:");
        int binario[] = {0, 0, 0, 0, 1, 0, 1, 0};

        // Exibe o vetor binário
        for (int i = 0; i < 8; i++) {
            System.out.print(binario[i] + " ");
        }

        System.out.println("\n-------------------------------------");

        // Converte o binário para decimal e exibe o resultado
        int decimal = converteToDecimal(binario);
        System.out.println("Decimal: " + decimal);
    }

    // Método que converte o número binário em decimal
    public static int converteToDecimal(int[] binario) {
        int decimal = 0;

        // Percorre o vetor do início ao fim
        for (int i = 0; i < 8; i++) {
            // Calcula o valor decimal
            decimal += binario[i] * Math.pow(2, 7 - i); // Usando deslocamento de bits com Math.pow
        }

        return decimal; // Retorna o valor decimal
    }
}
