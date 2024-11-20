package Exercicios_aula8;

public class ArvoreBinariaEx1 { // Devemos criar uma classe que permita adicionar de forma ordenada valores
                                // inteiros, sem valores duplicados

    // Atributos da árvore
    private nodeArvoreBinaria raiz;

    public void adicionar(int info) {
        /*
         * implementar o código necessário para permitir adicionar novos nós na árvore
         * binária de
         * forma ordenada, utilizando a seguir a regra: se o valor de info for maior que
         * o valor do nó
         * adiciona a direita senão a esqurda.
         * se o valor for duplicado encerra sem adicionar
         */

        if (raiz == null) {
            raiz = new nodeArvoreBinaria(info, null, null);
        } else {
            adicionarRecursivo(info, raiz);
        }
    }

    private void adicionarRecursivo(int info, nodeArvoreBinaria raiz) {

        if(info > (Integer) raiz.getInfo()){
             if (raiz.getNoDireira() == null) {
                nodeArvoreBinaria novoNo = new nodeArvoreBinaria(info, null, null);
                raiz.setNoDireira(novoNo);
            }else {
                adicionarRecursivo(info, raiz.getNoDireira());
            }
        }

        if(info < (Integer) raiz.getInfo()){
           if(raiz.getNoEsquerda() == null){
            nodeArvoreBinaria novoNo = new nodeArvoreBinaria(info, null, null);
            raiz.setNoEsquerda(novoNo);
           }else{
            adicionarRecursivo(info, raiz.getNoEsquerda());
           }
        }
    }

    public void preOrdem(){
        preOrdem(raiz);
    }

    public void Ordem(){
        Ordem(raiz);
    }

    public void posOrdem(){
        posOrdem(raiz);
    }

    private void preOrdem(nodeArvoreBinaria node){
        if(node != null){ // Verifica se o pai é diferente de nulo
            System.out.println(node.getInfo()); // Imprime o pai

            //Imprime a esquerda 
            preOrdem(node.getNoEsquerda());
            //Imprime a direita
            preOrdem(node.getNoDireira());
        }
    }

    private void Ordem(nodeArvoreBinaria node){
        if(node != null){ // Verifica se o pai é diferente de nulo
            Ordem(node.getNoEsquerda());
            System.out.println(node.getInfo());  // Imprime o pai
            Ordem(node.getNoDireira());
        }
    }

    private void posOrdem(nodeArvoreBinaria node){
        if(node != null){
            posOrdem(node.getNoEsquerda());
            posOrdem(node.getNoDireira());
            System.out.println(node.getInfo());
        }
    }


     //**********falta implementar o método percorrer arvore binária********** 
    /*private nodeArvoreBinaria percorreArvore(int indice) {
    } */

     public void imprimirTodaArvore(){ // Percorre a arvore até proxomo no == null
        nodeArvoreBinaria aux = raiz; // Começa pelo nó de início

        while(aux != null){  // Percorre toda a lista até encontrar o último nó (null)
            System.out.println(aux.getInfo().toString());
            aux = aux.getNoDireira().getNoEsquerda(); // Percorre a arvore
        }

    }
}


//implementar o método percorreArvore 
