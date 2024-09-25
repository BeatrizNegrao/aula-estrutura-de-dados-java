package Exercicios_aula3;

import java.util.ArrayList;
/* 4) Considere uma pilha que armazene números, escreva uma função para ordenar os valores da pilha em ordem crescente,
utilize pilhas auxiliares para realizar a ordenação.*/
/*
    * Metodos Obrigatórios:
    * -Empilhar(Obj elemento)
    * -Obj Desempilhar()
    * -Booaleano Pilha Vazia()
    * -Booaleano Pilha Cheia()
    */

public class PilhaEx4 {
    ArrayList<Integer> elementos = new ArrayList<Integer>();

    // ***Construtor***
    public PilhaEx4() {
        elementos = new ArrayList<>();
    }

    // Método para empilhar
    public void Empilhar(Integer valor) {
        elementos.add(valor);
    }

    // Método para desempilhar
    public Integer Desempilhar() {
        if (!pilhaVazia()) {
            return elementos.remove(elementos.size() - 1);
        }
        return null; // Retorna null se a pilha estiver vazia
    }

    // Método para exibir o elemento no topo da pilha
    public Integer exibirInicio() {
        if (!pilhaVazia()) {
            return elementos.get(elementos.size() - 1);
        }
        return null; // Retorna null se a pilha estiver vazia
    }

    // Verifica se a pilha está vazia
    public boolean pilhaVazia() {
        if (elementos.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Método para ordenar a pilha usando pilhas auxiliares
    public void OrdenaPilha() {
        PilhaEx4 aux1 = new PilhaEx4(); // Será usada para armazenar os elementos já ordenados
        PilhaEx4 aux2 = new PilhaEx4(); // Serve para transferências temporárias.

        // Loop Externo para Desempilhar e Processar Todos os Elementos
        while (!this.pilhaVazia()) {
            /*  Laço while:
             * Objetivo: O laço while garante que o bloco de código dentro dele 
             * seja executado repetidamente enquanto a pilha não estiver vazia.
             * 
             * !this.pilhaVazia(): verifica se a pilha original não está vazia.
             * Se retornar true, a pilha está vazia e o laço termina.
             * Se retornar false, a pilha ainda contém elementos, então o laço continua.
             * 
             * Se a pilha contém os elementos [5, 3, 2], o laço while será executado três vezes, 
             * uma para cada elemento, até que a pilha esteja vazia.
             */

            Integer temporaria = this.Desempilhar();
            /*
             * Desempilhando o Elemento do Topo:
             * this.Desempilhar(): 
             * Aqui estamos chamando o método Desempilhar() da classe PilhaEx4. O this refere-se à instância atual da classe, 
             * ou seja, o objeto da pilha de onde estamos tentando remover um elemento.
             * O método Desempilhar() remove e retorna o elemento que está no topo da pilha.
             * Se a pilha não estiver vazia, o valor do topo é removido da pilha e retornado
             * 
             * 
             * Integer temporaria: a variávelt(temporaria) é uma variável do tipo Integer.
             * O propósito da variável é armazenar temporariamente o valor que é desempilhado da pilha original.
             * = : O sinal de igual (=) é o operador de atribuição. 
             * Ele atribui o valor que está à direita (resultado de this.Desempilhar()) à variável à esquerda (temporaria).
             * 
             * Exemplo:
             * 1. Estado Inicial da Pilha:
             * -> Suponha que a pilha original tem os elementos: [5, 3, 2].
             * -> O elemento 2 é o topo da pilha.
             * 2. Execução da Linha:
             * -> Quando Integer temporaria = this.Desempilhar(); é executado:
             * -> O valor 2 é removido da pilha original.
             * -> A variável temporaria: agora contém: [2].
             * -> A pilha original agora contém: [5, 3].
             * 3. Valor Armazenado:
             * -> O valor em temporaria (2) pode agora ser utilizado para comparação 
             * ou qualquer outra lógica que você tenha implementado no código após essa linha.
             */

            // Loop Interno para Inserção Ordenada em pilhaAux1
            while (!aux1.pilhaVazia() && aux1.exibirInicio() > temporaria) {
                /* Condição do while:
                 * !aux1.pilhaVazia(): Este método verifica se a pilha aux1 não está vazia.
                 * 
                 * aux1.exibirInicio() > temporaria: 
                 * Este método (exibirInicio()) retorna o elemento que está no topo da pilha aux1 sem removê-lo.
                 * O laço continuará enquanto o valor no topo da pilha aux1 for maior que da vaiável(temporaria).
                 * A condição é verdadeira se o elemento no topo de aux1 for maior que temporaria.
                 * 
                 * Exemplo: 
                 * 1. Condições Iniciais:
                 * Suponha que a pilha aux1 contém os elementos [7, 5, 3, 1] (onde 7 está no topo) e temporaria contém o valor 4.
                 * -> Quando o laço começa, a condição !aux1.pilhaVazia() verifica se aux1 não está vazia (o que é verdade, já que tem elementos).
                 * -> A condição aux1.exibirInicio() > temporaria compara o valor no topo (7) com temporaria (4). 
                 * Como 7 é maior que 4, a condição é verdadeira e o laço entra na execução.
                 */

                aux2.Empilhar(aux1.Desempilhar()); // Transfere para pilhaAux2
                /* Esta linha é executada se as duas condições acima forem verdadeiras. Aqui está o que acontece:
                 * -> O método Desempilhar() é chamado na pilha aux1, removendo o elemento que está no topo e retornando-o.
                 * -> O elemento retornado é então empilhado na pilha auxiliar aux2 através do método Empilhar().
                 * -> Isso significa que estamos movendo elementos da pilha (aux1) para pilha (aux2)
                 * enquanto os elementos em aux1 são maiores que o valor de temporaria.
                 * 
                 * aux1.Desempilhar():Remove e retorna o elemento no topo da pilha aux1. 
                 * 
                 * 
                 * aux2.Empilhar(...): O valor que foi desempilhado de aux1 é empilhado na pilha aux2. 
                 * 
                 * Exemplo:
                 * Vamos ilustrar com um exemplo em que aux1 contém os elementos [9, 7, 5, 4, 2] e temporaria é 6:
                 * 1. Estado Inicial:
                 * -> aux1 = [9, 7, 5, 4, 2]
                 * -> aux2 = []
                 * -> temporaria = 6
                 * 
                 * 2. 1ª iteração:
                 * -> temporaria = 6
                 * -> Enquanto: !aux1.pilhaVazia() → for true 
                 * -> E Enquanto: aux1.exibirInicio() = 9 > 6 → for true
                 * -> A linha aux2.Empilhar(aux1.Desempilhar()); executa:
                 *  aux1.Desempilhar(): remove 9 de aux1(topo da pilha aux1), aux1 = [7, 5, 4, 2].
                 *  aux2.Empilhar(): adiciona 9 a aux2, aux2 = [9].
                 * 
                 * 3. 2ª iteração:
                 * -> temporaria = 6
                 * -> Enquanto: !aux1.pilhaVazia() → for true
                 * E Enquanto: aux1.exibirInicio() > temporaria = 7 > 6 → for true
                 * -> A linha aux2.Empilhar(aux1.Desempilhar()); executa:
                 *  aux1.Desempilhar(): remove 7, deixando aux1 = [5, 4, 2].
                 *  aux2.Empilhar(): adiciona 7 a aux2, deixando aux2 = [9, 7].
                 * 
                 * 4. 3ª iteração:
                 * -> temporaria = 6
                 * -> Enquanto: !aux1.pilhaVazia() → for true
                 * -> E Enquanto: aux1.exibirInicio() > temporaria  = 5 > 6 → for false
                 * -> A linha aux2.Empilhar(aux1.Desempilhar()); executa:
                 * -> O loop termina porque o topo de aux1 (5) não é maior que o topo temporaria (6).
                 */
            }

            aux1.Empilhar(temporaria); // Insere o valor na posição correta
            /*
             * Inserção do Valor da variável(temporaria) na Posição Correta:
             * temporaria: É o valor que foi desempilhado da pilha original e que precisa
             * ser inserido na pilha auxiliar aux1 de forma ordenada.
             * aux1.Empilhar(temporaria): O método Empilhar() insere o valor da
             * variável(temporaria) no topo de pilha aux1.
             * Exemplo:
             * -> pilha aux1: [1, 3]
             * -> temporaria: 4
             * -> pilha aux1: [1, 3, 4]
             */

            while (!aux2.pilhaVazia()) {
                /*
                 * Retorno dos Elementos de pilha aux2 para pilha aux1:
                 * Laço while:
                 * !aux2.pilhaVazia(): executa enquanto pilha aux2 não estiver vazia, ou seja,
                 * enquanto ainda houver elementos temporários armazenados em pilha aux2 que
                 * precisam ser retornados para pilha aux1.
                 * 
                 * Propósito:
                 * Como o código do loop anterior transferiu temporariamente
                 * os elementos maiores que os valores da variável(temporaria)
                 * para pilha aux2, esses elementos agora precisam ser devolvidos a pilha aux1,
                 * para que a ordenação seja mantida.
                 */

                aux1.Empilhar(aux2.Desempilhar());
                /*
                 * aux2.Desempilhar(): Remove o elemento do topo da pilha aux2 e retorna esse
                 * valor.
                 * Esse elemento é o que foi temporariamente movido da pilha aux1 para pilha
                 * aux2 no laço for anterior,
                 * para abrir espaço para inserir o valor da variável(temporaria).
                 * 
                 * aux1.Empilhar(): Insere o valor desempilhado da pilha aux2 de volta no topo
                 * da pilha aux1.
                 * Como os elementos foram desempilhados da pilha aux1 em ordem decrescente (do
                 * maior para o menor),
                 * eles precisam ser recolocados no topo da pilha aux1 na mesma ordem em que
                 * estavam antes,
                 * para manter a sequência de valores ordenados.
                 * 
                 * Exemplo ----- >
                 * Suponha que temos a seguinte situação após o laço for anterior:
                 * pilha aux1 (parcialmente ordenada):
                 * -> aux1: [1, 3]
                 * temporaria (valor a ser inserido):
                 * -> temporaria: 4
                 * pilha aux2 (contém os valores maiores que os da variável temporaria):
                 * -> pilha aux2: [7, 5]
                 * Em seguida temos:
                 * 1. Inserção do valor da variável(temporaria) em pilha aux1:
                 * Após o código:
                 * aux1.Empilhar(temporaria), temporaria será empilhado:
                 * -> aux1: [1, 3, 4]
                 * 2. Transferência dos Elementos da pilha aux2 de Volta para pilha aux1.
                 * 
                 * Primeiro, desempilha 5 da pilha aux2 e empilha em pilha aux1:
                 * -> pilha aux1: [1, 3, 4, 5]
                 * -> pilha aux2: [7]
                 * 
                 * Depois, desempilha 7 da pilha aux2 e empilha em pilha aux1:
                 * -> pilha aux1: [1, 3, 4, 5, 7]
                 * -> pilha aux2: []
                 * 
                 * Resumindo: Esse processo garante que pilha aux1 continue ordenada em ordem
                 * crescente,
                 * com o novo valor da variável(temporaria) inserido corretamente.
                 */
            }

        }

        // Transfere todos os elementos da pilha aux1 (ordenados) de volta para a pilha original
        while (!aux1.pilhaVazia()) {
            /* Condição do While:
             * !aux1.pilhaVazia(): Esta condição verifica se a pilha aux1 não está vazia.
            */
            this.Empilhar(aux1.Desempilhar());
            /* this.Empilhar(aux1.Desempilhar()): Esta linha executa duas operações:
             * aux1.Desempilhar(): Remove o elemento no topo da pilha aux1 e retorna esse valor.
             * this.Empilhar(...): A função Empilhar é chamada na instância atual da classe (this), 
             * que é a pilha original de onde os valores foram extraídos.
             *  O valor retornado por Desempilhar() é adicionado ao topo da pilha original.
             * 
             * Exemplo:
             *  Estado Inicial: 
             * -> aux1 = [3, 2, 1]
             * -> this (a pilha original) = []
             * 
             * 1ª iteração do While:
             * -> aux1.Desempilhar(): remove 3, que é o elemento do topo.
             * -> this.Empilhar(): adiciona 3 à pilha original.
             * -> aux1 = [2, 1] e pilha original = [3]
             * 
             * 2ª iteração do While:
             * -> aux1.Desempilhar(): remove 2.
             * -> this.Empilhar(): adiciona 2 à pilha original.
             * -> aux1 = [1] e pilha original = [3, 2]
             * 
             * 3ª iteração do While:
             * -> aux1.Desempilhar(): remove 1
             * -> this.Empilhar(): adiciona 1 à pilha original.
             * -> aux1 = [] e pilha original = [3, 2, 1]
             * 
             */

        }
    }

    public String toString() {
        return elementos.toString();
    }

    public static void main(String[] args) {
        // Criar uma pilha e adicionar valores
        PilhaEx4 valores = new PilhaEx4();
        valores.Empilhar(5);
        valores.Empilhar(20);
        valores.Empilhar(1);
        valores.Empilhar(0);
        valores.Empilhar(4);
        valores.Empilhar(15);

        System.out.println("Pilha antes de ordenar: " + valores);

        valores.OrdenaPilha();

        System.out.println("Pilha ordenada: " + valores);

    }
}
