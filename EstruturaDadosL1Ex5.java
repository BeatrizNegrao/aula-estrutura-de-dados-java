// Aula 01 - Vetores e Matrizes
/* 5) Escreva um método que receba dois vetores de 5 números cada, 
gere um terceiro vetor com os elementos dos outros dois vetores intercalados.*/
public class EstruturaDadosL1Ex5 {
    public static void main(String[] args) {
        // Criação dos vetores
        char[] vetor1 = { 'A', 'B', 'C', 'D', 'E' };
        int[] vetor2 = { 1, 2, 3, 4, 5 };

        Object[] vetorAlternado = intercalarVetores(vetor1, vetor2); /* Chamando o método para intercalar vetores
                                                                     (usando o método Object[] para vetores de tipos diferentes). */ 
                                                                      
        for (Object elemento : vetorAlternado) { /* Estrutura do loop for-each -> for (TipoElemento elemento : Colecao) {}
                                                  usado para iterar sobre elementos em uma coleção, como arrays ou listas. */ 

            System.out.print(elemento + " "); /*imprimi a variável (elemento) na saída padrão,
                                              concatenando o valor do elemento com um espaço.*/ 
        }

    }

    public static Object[] intercalarVetores(char[] vetor1, int[] vetor2) {
        Object[] vetorAlternado = new Object[vetor1.length + vetor2.length];

        int index = 0; /* Criada para rastrear a posição correta em que cada elemento dos vetores (vetor1 e vetor2)
                         devem ser inseridos no vetor intercalado (vetorAlternado).*/

        for (int i = 0; i < vetor1.length; i++) { // intercala os elementos dos dois vetores
            vetorAlternado[index++] = vetor1[i];
            vetorAlternado[index++] = vetor2[i];

        }

          return vetorAlternado;

    }

}
