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

public class PilhaEx3 {
    public char[] elementos;
    public int topo;

    public PilhaEx3(int tamanho) {
        elementos = new char[tamanho];
        topo = -1;
    }

    // Empilhar um elemento na pilha
    public void empilhar(char elemento) {
        if (topo < elementos.length - 1) {
            topo++;
            elementos[topo] = elemento;
        } else {
            System.out.println("Pilha cheia");
        }
    }

    // Desempilhar um elemento da pilha
    public char desempilhar() {
        if (topo >= 0) {
            char elemento = elementos[topo];
            topo--;
            return elemento;
        } else {
            System.out.println("Pilha vazia");
            return '\0'; // Retorna um caractere nulo se a pilha estiver vazia
        }
    }

    // Verifica se a pilha está vazia
    public boolean pilhaVazia() {
        return topo == -1;
    }
}
