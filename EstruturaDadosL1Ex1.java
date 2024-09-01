
// 1.0) Crie um método que receba 1 vetor com 8 posições, inverta a ordem dos itens e retorne o vetor invertido.
public class EstruturaDadosL1Ex1 {
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

        for (int i = 0; i < 8; i++) {
            aux[i] = v[7 - i];
            System.out.println(aux[i]);

        }
    }
}
