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
        for (int i = 0; i < elementos.size(); i++) {
            /*
             * Função do for: Esse laço for é usado para iterar sobre todos os elementos
             * presentes na pilha original.
             *
             * Componentes do Laço for:
             * int i = 0: Inicializa uma variável i com o valor 0. A variável i é usada como
             * contador para controlar o número de iterações do laço.
             * 
             * i < elementos.size(): A condição de controle do laço. Ela garante que o laço
             * continue a ser executado
             * enquanto i for menor que o número total de elementos da pilha
             * (elementos.size()).
             * O método elementos.size() retorna o tamanho atual da pilha, ou seja, o número
             * de elementos que estão armazenados nela.
             * Quando i atingir o tamanho da pilha, o laço será encerrado.
             * 
             * i++: Após cada iteração, o valor de i é incrementado em 1, o que garante que
             * o laço percorra todos os elementos da pilha.
             */

            Integer temporaria = this.Desempilhar();
            /*
             * Desempilhando o Elemento do Topo:
             * this.Desempilhar(): Chama o método
             * Desempilhar() na instância atual da classe
             * (this), que remove o elemento do topo da pilha original e o retorna.
             * O método Desempilhar() deve estar definido de tal forma que remova o elemento
             * mais recente adicionado à pilha (o elemento no topo) e o devolva.
             * 
             * Se a pilha original tiver 5 elementos, na primeira iteração o elemento que
             * está no topo será removido e retornado.
             * 
             * A pilha segue a estrutura de LIFO (Last In, First Out), ou seja, o último
             * elemento a ser empilhado será o primeiro a ser desempilhado.
             * 
             * Armazenamento em 'temporaria': O valor desempilhado é armazenado na variável
             * (temporaria), que é do tipo Integer. Isso significa que, após
             * desempilhar um valor da pilha,
             * esse valor será mantido na variável (temporaria) para ser utilizado na lógica
             * subsequente.
             *
             * Exemplo: Se a pilha tiver os elementos [5, 3, 7, 1]
             * com 1 no topo, a chamada para this.Desempilhar() na primeira iteração
             * removerá 1 da pilha e o armazenará na variável (temporaria).
             */

            // Loop Interno para Inserção Ordenada em pilhaAux1
            while (!aux1.pilhaVazia() && aux1.exibirInicio() > temporaria) {
                /*
                 * Estrutura do for:
                 * Este for é um loop sem inicialização e incremento explícito, ou seja, ele
                 * apenas depende da condição no meio.
                 * É basicamente um while disfarçado de for.
                 *
                 * Condição do laço:
                 * O laço continua executando enquanto:
                 * 1. !aux1.pilhaVazia(): A pilha auxiliar 1 não estiver vazia, ou seja,
                 * ainda houver elementos a serem comparados.
                 * 2. aux1.exibirInicio() > temporaria: O elemento no topo de (aux1)
                 * for maior que a variável(temporaria), ou seja, o valor no topo da pilha
                 * auxiliar 1 é maior do que o valor que estamos tentando inserir (temporaria).
                 * 
                 * Se ambas as condições forem verdadeiras, o loop continuará. Se uma delas
                 * falhar (a pilha estiver vazia ou o valor no topo não for maior que
                 * (temporaria)), o
                 * laço será encerrado.
                 */

                aux2.Empilhar(aux1.Desempilhar()); // Transfere para pilhaAux2
                /*
                 * Transferência de Elementos:
                 * aux1.Desempilhar(): Remove o elemento do topo da pilha auxiliar 1
                 * (aux1). Como a pilha segue o princípio LIFO (Last In, First Out), o
                 * elemento removido é o que está no topo.
                 * 
                 * aux2.Empilhar(): Coloca o elemento desempilhado de aux1 no topo da
                 * segunda pilha auxiliar (aux2).
                 * 
                 * Exemplo: Suponha que pilha aux1 inicialmente tenha os seguintes valores:
                 * -> pilha aux1: [1, 3, 5, 7]
                 * -> temporaria: 4
                 * 
                 * Na primeira iteração, o topo de pilha aux1 é 7, que é maior que 4, então 7
                 * será desempilhado da pilha aux1 e empilhado em aux2.
                 * -> pilha aux1: [1, 3, 5]
                 * -> pilha aux2: [7]
                 * 
                 * Em seguida, na segunda iteração, o topo da pilha aux1 é 5, que ainda é maior
                 * que 4. Então, 5 é movido para pilha aux2.
                 * -> pilha aux1: [1, 3]
                 * -> pilha aux2: [7, 5]
                 * 
                 * Agora, o topo de pilha aux1 é 3, que não é maior que 4. O laço termina, pois
                 * encontramos o ponto onde o valor da variável(temporaria) deve ser inserido.
                 * -> pilha aux1: [1, 3]
                 * -> pilha aux2: [7, 5]
                 * -> temporaria: 4
                 * 
                 * Quando o Laço Termina? :
                 * O laço continua removendo elementos da pilha aux1 e transferindo para
                 * pilha aux2 até que:
                 * 1. A pilha aux1 esteja vazia.
                 * 2. Ou o elemento no topo de pilha aux1 seja menor ou igual ao valor
                 * armazenada
                 * na variável temporaria (indicando a posição onde (temporaria) deve ser
                 * inserido).
                 */

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
                     * enquanto ainda houver elementos temporários armazenados em pilha aux2 que precisam ser retornados para pilha aux1.
                     * 
                     * Propósito: 
                     * Como o código do loop anterior transferiu temporariamente 
                     * os elementos maiores que os valores da variável(temporaria) 
                     * para pilha aux2, esses elementos agora precisam ser devolvidos a pilha aux1,  
                     * para que a ordenação seja mantida.
                     */

                    aux1.Empilhar(aux2.Desempilhar());
                    /*
                     * aux2.Desempilhar(): Remove o elemento do topo da pilha aux2 e retorna esse valor. 
                     * Esse elemento é o que foi temporariamente movido da pilha aux1 para pilha aux2 no laço for anterior, 
                     * para abrir espaço para inserir o valor da variável(temporaria).
                     * 
                     * aux1.Empilhar(): Insere o valor desempilhado da  pilha aux2 de volta no topo da pilha aux1. 
                     * Como os elementos foram desempilhados da pilha aux1 em ordem decrescente (do maior para o menor), 
                     * eles precisam ser recolocados no topo da pilha aux1 na mesma ordem em que estavam antes, 
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
                     * 2. Transferência dos Elementos da  pilha aux2 de Volta para pilha aux1.
                     * 
                     * Primeiro, desempilha 5 da pilha aux2 e empilha em pilha aux1:
                     * -> pilha aux1: [1, 3, 4, 5]
                     * -> pilha aux2: [7]
                     * 
                     * Depois, desempilha 7 da pilha aux2 e empilha em pilha aux1:
                     * -> pilha aux1: [1, 3, 4, 5, 7]
                     * -> pilha aux2: []
                     * 
                     * Resumindo: Esse processo garante que pilha aux1 continue ordenada em ordem crescente,
                     * com o novo valor da variável(temporaria) inserido corretamente.
                     */
                }
            }
        }

        // Transfere todos os elementos da pilha aux1 (ordenados) de volta para a pilha original
        //for(int i= 0; i<aux1.elementos.size(); i++){
            /* 
             * O laço for: percorre todos os elementos da pilha aux1.
             * 
             * O método aux1.elementos.size() retorna o número de elementos que ainda estão presentes em pilha aux1.
             * 
             * O laço será executado uma vez para cada elemento presente na pilha auxiliar (aux1). 
             * A variável(i) é usada apenas para controlar a quantidade de iterações e garantir que todos os elementos 
             * sejam transferidos de volta para a pilha original.
            */
            //this.Empilhar(aux1.Desempilhar());
             /*
              * Transferência de Elementos:
              * aux1.Desempilhar(): Este método remove o elemento do topo da pilha auxiliar(aux1) e o retorna. 
              * Como as pilhas seguem o princípio LIFO (Last In, First Out), o elemento que foi empilhado por último será o 
              * primeiro a ser desempilhado.
              *
              * this.Empilhar(...): Após desempilhar o elemento da pilha aux1, ele é empilhado na pilha original.
              * O uso de this refere-se à instância atual da classe, ou seja, 
              * a pilha original na qual os elementos devem ser colocados de volta.
              *
              * Por que os elementos estão sendo movidos de volta? :
              * Como a pilha original deve ser ordenada, 
              * este laço transfere os elementos que estão atualmente em pilha aux1 de volta para a pilha original.
              *
              * Exemplo: 
              * Suponha que pilha aux1 contém os seguintes elementos ordenados:
              * -> pilha aux1: [1, 2, 3, 4, 5]
              *
              * O laço for vai percorrer todos os 5 elementos da pilha aux1 e, a cada iteração, 
              * transferir o elemento do topo da pilha aux1 para a pilha original.
              *
              * 1ª iteração:
              * aux1.Desempilhar(): remove 5 de aux1.
              * this.Empilhar(): coloca 5 no topo da pilha original.
              * -> pilha aux1: [1, 2, 3, 4]
              * -> Pilha original: [5]
              *
              * 2ª iteração:
              * aux1.Desempilhar(): remove 4 de aux1.
              * this.Empilhar(): coloca 4 no topo da pilha original.
              * -> pilha aux1: [1, 2, 3]
              * -> Pilha original: [5, 4]
              *
              * 3ª iteração:
              * aux1.Desempilhar(): remove 3 de aux1.
              * this.Empilhar(): coloca 3 no topo da pilha original.
              * -> pilha aux1: [1, 2]
              * -> Pilha original: [5, 4, 3]
              *
              * 4ª iteração:
              * aux1.Desempilhar(): remove 2 de aux1.
              * this.Empilhar(): coloca 2 no topo da pilha original.
              * -> pilha aux1: [1]
              * -> Pilha original: [5, 4, 3, 2]
              *
              * 5ª iteração:
              * aux1.Desempilhar(): remove 1 de pilha aux1.
              * this.Empilhar(): coloca 1 no topo da pilha original.
              * -> pilha aux1: [] (vazia)
              * -> Pilha original: [5, 4, 3, 2, 1]
              * O número 1 topo da pilha e 5 fundo da pilha.
              * Agora a pilha original contém os elementos em ordem crescente da direita para a esquerda.
              */
            
        }
    //}

    public String toString() {
        return elementos.toString();
    }

    public static void main(String[] args){
        //Criar uma pilha e adicionar valores 
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
