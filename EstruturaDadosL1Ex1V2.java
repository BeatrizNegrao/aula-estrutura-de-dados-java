//Aula 01 - Vetores e Matrizes 
//1.1) Crie um método que receba 1 vetor com 8 posições, inverta a ordem dos itens e retorne o vetor invertido.
public class EstruturaDadosL1Ex1V2 {
    public static void main(String[] args) {
        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < 8; i++) {
            System.out.println(vetor[i]);
        }
        System.out.println("========================================");
        inverteVetor(vetor);
    }

    public static void inverteVetor(int v[]) {

        int aux[] = new int[8];

        for (int i = 7; i >= 0; i--) {
            aux[7 - i] = v[i];
            System.out.println(aux[7 - i]);

        }
    }
}
