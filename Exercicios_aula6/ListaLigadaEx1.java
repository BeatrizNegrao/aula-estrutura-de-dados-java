package Exercicios_aula6;
// Exercício de lista ligada:
public class ListaLigadaEx1 {
    private NodeEx1 inicio; // Armazena o primeiro nó da lista ligada (é apenas um ponteiro, não é instanciado)
    private NodeEx1 fim; // Armazena o último nó da lista ligada (é apenas um ponteiro, não é instanciado)
    private int tamanho; // Armazena o tamanho atual da lista

    // Construtor para inicializar uma lista ligada vazia
    public ListaLigadaEx1() {
        inicio = null;  // Define o primeiro nó como nulo (lista vazia)
        fim = null; // Define o último nó como nulo (lista vazia)
        tamanho = 0; // Inicializa o tamanho da lista como 0
    }

    public void adicionar(Object info) { // Método para adicionar um novo nó ao final da lista ligada

        NodeEx1 novoNo;  // Declaração de um novo nó 
        if (tamanho == 0) { // Verifica se o tamanho da lista é vazia 
            novoNo = new NodeEx1(info, null); // Criando o primeiro nó, apontando seu próximo como nulo
            inicio = fim = novoNo; // Define tanto o início quanto o fim como o novo nó
            tamanho++;// incrementa tamanho da lista
        } else {
            novoNo = new NodeEx1(info, null); // Cria um novo nó com o valor info, apontando seu próximo como nulo
            // fim: variável representa somente um ponteiro
            fim.setProximoNo(novoNo); // O último nó atual (fim) agora aponta para o novo nó que foi adicionado ao final da lista
            fim = novoNo; // Atualiza o ponteiro 'fim' para o novo nó
            tamanho++;// Incrementa tamanho da lista
        }
    }

    public void adicionar(Object info, int indice) { // adiciona na posição definida pelo índice
        NodeEx1 anterior;  // Declaração de uma variável para armazenar o nó anterior ao índice

        if(indice == 0){  // Caso o índice definido seja 0, adiciona o nó no início da lista
            NodeEx1 novoNo = new NodeEx1(info, inicio); 
            //Um novo nó (novoNo) é criado com a informação (info) e, como segundo argumento, 
            // é passado o nó atual que está no início da lista (inicio).
            // Isso significa que o novo nó vai apontar para o nó que já está no início.

            inicio = novoNo; 
            // Agora, a variável (inicio) é atualizada para o novo nó, fazendo com que o novo nó se torne o primeiro nó da lista.

            tamanho++; // Incrementa o tamanho da lista, já que um novo nó foi adicionado.
       
         }else if (indice < tamanho) { // Veridica se o índice definido é maior que o tamanho da lista
            anterior = percorreLista(indice - 1); // percorre até a posição anterior do índice definido
            NodeEx1 novoNo = new NodeEx1(info, anterior.getProxomoNo()); // o novo nó é criado com a informação (info), ##########
            anterior.setProximoNo(novoNo); // O nó anterior agora aponta para o novo nó
            tamanho++; // Incrementa o tamanho da lista 
        }

        else if(indice == tamanho - 1){ // caso queira adicionar um nó ao final da lista
            adicionar(info); // adiciona a informação                                                                   ##########
        }

    }

    public void remover(Object info, int indice){ // Removerá o nó definido pelo índice
        NodeEx1 noRemovido;

        if(indice == 0){ // caso a remoção ocorra no primeiro nó 
             inicio = inicio.getProxomoNo(); // o novo início agora aponta para o próximo nó
             tamanho--; // Decrementa tamanho da lista 
        }else{ // Remoção ocorre em qualquer posição
            NodeEx1 anterior = percorreLista(indice - 1); // Retorna o nó anterior ao nó que será removido
            noRemovido = anterior.getProxomoNo(); /* Propósito: Encontrar o nó que será removido. 
            Em seguida, armazenamos essa referência na variável noRemovido, para que possamos manipulá-la ou descartá-la 
            (remover da lista).*/ 
            anterior.setProximoNo(noRemovido.getProxomoNo()); // O anterior aponta para o próximo nó (do nó removido)

            if(indice == tamanho - 1){ // Se a remoção ocorrer no último nó da lista 
                fim = anterior; // O nó anterior passa a ser o último nó da lista
            }
            
            tamanho--; // Decrementa o tamanho da lista 
        }
    }

    public Object getLista(int indice) {
        // retornará o info do nó apontado pelo índice
        return percorreLista(indice).getInfo();
    }

    private NodeEx1 percorreLista(int indice) { // Método para percorrer a lista e retornar o nó de uma determinada posição
        NodeEx1 aux = inicio; // Inicia a busca do primeiro nó (início da lista)
        if (indice <= tamanho) { // verifica se o indice é válido
            for (int i = 0; i < indice; i++) { // Percorre a lista até o nó correspondente ao índice
                aux = aux.getProxomoNo(); // Atualiza o nó auxiliar para o próximo nó
            }
            return aux; // Retorna o nó encontrado
        } else {
            return null;  // Retorna null se o índice for inválido
        }
    }

    public int getTamanho() { // retorna O TAMANHO DA LISTA
        return tamanho;
    }
}

//Observações importantes:
/* Quando usar get e set:
 * getProxomoNo() (Getter):
 * Você usa o método getProxomoNo() quando deseja acessar o próximo nó ao qual o nó atual está apontando. É um método de leitura.
 * No contexto da lista ligada, você precisa disso para percorrer ou manipular os nós da lista sem alterar a estrutura dela.
 * 
 * setProximoNo() (Setter):
 * é usado quando você deseja modificar o ponteiro proximoNo do nó atual, para fazê-lo apontar para outro nó.
 * Em uma lista ligada, é essencial usar setters para ligar ou desligar nós da lista, 
 * especialmente durante operações como adicionar ou remover nós.
 * 
 * Contexto de uso na remoção:
 * getProxomoNo(): é usado para identificar qual nó será removido (o nó seguinte ao anterior).
 * setProximoNo(): é utilizado para fazer o nó anterior pular o nó que será removido e apontar diretamente para o nó após o removido,
 * efetivamente removendo o nó da lista.
 * 
 * Em resumo:
 * get: é para obter o próximo nó (leitura).
 * set: é para alterar a ligação entre nós (escrita).
 */ 
