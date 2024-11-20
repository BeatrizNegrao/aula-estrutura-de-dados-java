package Exercicios_aula7;

public class ListaDuplamenteLigadaEx1 {
    // Definição de atributos da lista
    private NodeDuploEx1 inicio; // Ponteiro para o primeiro nó da lista
    private NodeDuploEx1 fim; // Ponteiro para o último nó da lista
    private int tamanho; // Contador do número de elementos na lista

    // Construtor para inicializar uma lista ligada vazia
    public ListaDuplamenteLigadaEx1() {
        inicio = null;  // Define o primeiro nó como nulo (lista vazia)
        fim = null; // Define o último nó como nulo (lista vazia)
        tamanho = 0; // Inicializa o tamanho da lista como 0
    }

    public void adicionar(Object info){ // Método para adicionar um elemento no final da lista

        if(inicio == null){ // Se o início for null, a lista está vazia
           
            NodeDuploEx1 novoNo = new NodeDuploEx1(info, null, null);  // cria o primeiro nó na lista
            inicio = fim = novoNo; // O novo nó é tanto o início quanto o fim da lista
            tamanho++; // Incrementa o tamanho da lista

        } else { // Adiciona o nó na última posição da lista
            NodeDuploEx1 novoNo = new NodeDuploEx1(info, null, fim); // Cria o novo nó com o próximo como null e o anterior como o último nó
            fim.setProximo(novoNo); // Atualiza o último nó para apontar para o proxímo (novo nó)
            fim = novoNo; // O novo nó se torna o último nó da lista
            tamanho++; //Incrementa tamanho
        }
    }

    public void adicionar(Object info, int indice){ // Método que adiciona um nó definido pelo índice
        NodeDuploEx1 novoNo;  // Declara um novo nó

        if(indice == 0){ // Caso o índice definido seja 0, adiciona o nó no início da lista
           novoNo  = new NodeDuploEx1(info, inicio, null); // O próximo nó será o atual início(1° da lista), e o anterior será nulo
           inicio.setAnterior(novoNo); // Atualiza o nó que era o primeiro da lista(inicio) para apontar para o anterior (novo nó)
           inicio = novoNo; // O novo nó se torna o início da lista, ou seja, agora, o novo nó é oficialmente o primeiro da lista.
           tamanho++; //Incrementa tamanho

        }else if(indice < tamanho -1){ // Verifica se o índice definido está dentro da posição intermediária (nem no começo nem no fim da lista).
            NodeDuploEx1 aux = percorreLista(indice);  // Encontra o nó na posição definida pelo índice
            novoNo = new NodeDuploEx1(info, aux, aux.getAnterior()); // Cria o novo nó, apontando para o nó atual (aux) como próximo e para o anterior de aux como anterior.
            aux.setAnterior(novoNo);  // O nó definido pelo índice(aux) agora aponta para o novo nó(novoNo) que é seu nó anterior
            novoNo.getAnterior().setProximo(novoNo); // Atualiza o nó anterior para apontar para o novo nó como próximo
            tamanho++; //Incrementa tamanho 

        }else if(indice == tamanho -1){ // Se o índice for o último da lista
            adicionar(info); // Chama o método para adicionar o nó no final da lista
        }
    }

    public void remover(Object info, int indice){ // Removerá o nó definido pelo índice
        NodeDuploEx1 noRemovido; // Declara o nó que será removido
        NodeDuploEx1 anterior; // Declara o nó anterior
        NodeDuploEx1 proximo; // Declara o próximo nó

        if(indice == 0){ // caso a remoção ocorra no primeiro nó 
            noRemovido = inicio; // O nó a ser removido é o primeiro
            inicio = inicio.getProximo(); // O novo início passa a ser o próximo nó
            tamanho--; // Decrementa tamanho da lista 

        }else if(indice < tamanho - 1){ // Verifica se o índice definido está dentro da posição intermediária (nem no começo nem no fim da lista).
            anterior = percorreLista(indice - 1); // Localiza o nó anterior ao que será removido
            noRemovido = anterior.getProximo(); // Define o nó a ser removido (o nó definido para remover é próximo nó do anterior localizado)
            anterior.setProximo(noRemovido.getProximo()); // aponta a seta do nó anterior (nó removido) ao próximo nó (nó removido)
            proximo = percorreLista(indice + 1);  // Localiza o próximo nó ao que será removido
            noRemovido = proximo.getAnterior(); // Define o nó a ser removido como o anterior do próximo nó localizado
            proximo.setAnterior(noRemovido.getAnterior()); // aponta a seta do próximo nó (do nó removido) ao nó anterior(do nó removido)
            tamanho--;  // Decrementa tamanho da lista 

        }else if(indice == tamanho - 1){ // caso a remoção ocorra no último nó 
            noRemovido = fim; // O último nó passa a ser o nó definido para remoção 
            fim = fim.getAnterior(); // o nó anterior do último nó passa a ser o atual último nó
            tamanho--;  // Decrementa tamanho da lista 
        }      
    }

    public Object getLista(int indice){                                    
        //Retorna a informação do nó apontado pelo indice
        return percorreLista(indice).getInfo();
    }

    private NodeDuploEx1 percorreLista(int indice){  //Percorre a lista e retorna o nó ao índice
      NodeDuploEx1 aux; 

        if(indice < tamanho/2){ //percorre a lista do inicio para o fim
            aux = inicio;
            for(int i = 0; i < indice; i++){
                aux = aux.getProximo();
            }
             return aux;
        }else{ //percorre a lista do fim para o inicio
            aux = fim;
            for(int i = tamanho -1; i > indice; i--){
                aux = aux.getAnterior();
            }
            
        }
        return aux;
    }

    public void imprimirTodaLista(){ // Percorre a lista até proxomo no == null
        NodeDuploEx1 aux = inicio; // Começa pelo nó de início

        while(aux != null){  // Percorre toda a lista até encontrar o último nó (null)
            System.out.println(aux.getInfo().toString());
            aux = aux.getProximo(); // Percorre a lista
        }
    }

    public int getTamanho() { // retorna O TAMANHO DA LISTA
        return tamanho; // Retorna  o tamanho da lista 
    }
}
