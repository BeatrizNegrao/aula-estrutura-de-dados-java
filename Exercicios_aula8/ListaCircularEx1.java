package Exercicios_aula8;

public class ListaCircularEx1 {
    private nodeListaCircularEx1 inicio;
    private nodeListaCircularEx1 fim;
    private int tamanho;

    public ListaCircularEx1(){
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public void adicionar(Object info){

        if(inicio == null){ // Lista vazia, novo nó aponta para ele mesmo
            nodeListaCircularEx1 novoNo = new nodeListaCircularEx1(info, null, null);
             inicio= fim = novoNo;
             novoNo.setProximo(novoNo);
             novoNo.setAnterior(novoNo);
             tamanho++;
        }else{  // Adicionar no final da lista
            nodeListaCircularEx1 novoNo = new nodeListaCircularEx1(info, null, fim);
            novoNo.setProximo(inicio); // Aponta para o início, mantendo a circularidade
            novoNo.setAnterior(fim); // Aponta para o último nó
            fim.setProximo(novoNo);  // Último nó aponta para o novo nó
            inicio.setAnterior(novoNo); // Início aponta para o novo último nó
            fim = novoNo;  // Atualiza o fim
            tamanho++;
        }
    }

    public void adicionar(Object info, int indice){

        if(indice == 0){
            nodeListaCircularEx1 novoNo = new nodeListaCircularEx1(info, inicio, fim);
            inicio.setAnterior(novoNo);
            fim.setProximo(novoNo);
            inicio = novoNo;
            tamanho++;
        }else if(indice < tamanho){ //add o novoNo na posição intermediária
            nodeListaCircularEx1 aux = percorreLista(indice);
            nodeListaCircularEx1 novoNo = new nodeListaCircularEx1(info, aux, aux.getAnterior());
            aux.getAnterior().setProximo(novoNo);
            aux.setAnterior(novoNo);
            tamanho++;
        }else{ // add o novoNo na última posição
            adicionar(info);
        }
    }

    public void remover(Object info,int indice){

    }

    private nodeListaCircularEx1 percorreLista(int indice) {
        nodeListaCircularEx1 aux;

        if (indice < tamanho / 2) {
            // Percorre do início ao meio
            aux = inicio;
            for (int i = 0; i < indice; i++) {
                aux = aux.getProximo();
            }
        } else {
            // Percorre do fim ao meio
            aux = fim;
            for (int i = tamanho - 1; i > indice; i--) {
                aux = aux.getAnterior();
            }
        }
        return aux;
    }

    public Object getListaCircular(int indice){                                    
        //Retorna a informação do nó apontado pelo indice
        return percorreLista(indice).getInfo();
    }

    public int getTamanho(){
        return tamanho;
    }
}

//Implementar o método remover 