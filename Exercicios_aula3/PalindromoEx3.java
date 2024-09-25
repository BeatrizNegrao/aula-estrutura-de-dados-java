package Exercicios_aula3;
/* 3) Crie um método que recebe uma String e retorne True se a String é Palíndromo.
 * Ou seja, o nome é lido da mesma forma nos dois sentidos.
 * Para isso utilize uma pilha para inverter o nome, exemplo: “maria”  “airam”.
  Depois compare o nome invertido com o original, se forem iguais é palíndromo.
 * Utilize as classes Pilha, PilhaArray e Stack da API Java nos testes. E verifique se
 as três classes possuem o mesmo comportamento.
 * Utilize os métodos do objeto String :
 * .length(): para verificar a quantidade de caracteres da String. 
 */

public class PalindromoEx3 {
    // Recebe um vetor de char e retorna verdadeiro se for palindromo

    // Método que recebe um vetor de caracteres e retorna verdadeiro se for
    // palíndromo
    public boolean palindromo(char[] palavra) {

        PilhaEx3 aux = new PilhaEx3(palavra.length); // Cria uma pilha auxiliar para armazenar os caracteres
        char[] palavraInvertida = new char[palavra.length]; // Vetor para armazenar a palavra invertida

        // le a palavra auxiliar em pilhaauxiliar
        for (int i = 0; i < palavra.length; i++) {
            aux.empilhar(palavra[i]); // Adiciona o caractere na pilha
        }
        

        // desempilha pilha auxiliar e preenche o vetor palavraInvertida
        for (int i = 0; i < palavra.length; i++) {
            palavraInvertida[i] = (char) aux.desempilhar(); // Remove o caractere da pilha e armazena no vetor
        }

        System.out.println("Palavra original: " + new String(palavra));
        System.out.println("Palavra invertida: " + new String(palavraInvertida));

        // compara palavras original com palavra invertida
        for (int j = 0; j < palavra.length; j++) {
            // Se qualquer caractere não coincidir, não é um palíndromo
            if (palavra[j] != palavraInvertida[j]) {
                return false; // Retorna falso se as palavras não forem iguais
            }
        }
        return true;
        // se todas as posições forem iguais é palindromo

    }

    public static void main(String[] args) {
        PalindromoEx3 teste = new PalindromoEx3();
        char[] palavra = { 'a', 'r', 'a', 'r', 'a' };
        System.out.println("A palavra é palindromo? " + teste.palindromo(palavra)); // Deve retornar true
    }
}