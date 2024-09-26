package Exercicios_aula3;

/*Aula 03 - Pilhas
* 1) Implemente os métodos empilhar, desempilhar, pilha está vazia e pilha está cheia.
*Utilize na implementação um vetor de Object que irá receber como parâmetro via
construtor o tamanho do vetor.
*Teste o objeto pilha empilhando uma lista sequencial de números e os desempilhando em seguida.
*Utilize os métodos do objeto Array() :
*length(); que retorna o tamanho do vetor.
*Crie uma variável int com nome de topo para controlar o índice do topo da pilha.
*Verifique se a pilha já está cheia antes de adicionar um novo item, e se está vazia antes de tentar remover.
*/
/*Metodos Obrigatórios:
Empilhar(Obj elemento)
Obj Desempilhar()
Booaleano Pilha Vazia()
Booaleano Pilha Cheia()
*/

public class PilhaVetorEx1 {
    /*
     * Metodos Obrigatórios:
     * -Empilhar(Obj elemento)
     * -Obj Desempilhar()
     * -Booaleano Pilha Vazia()
     * -Booaleano Pilha Cheia()
     */

    Object[] elementos;
    int indice = 0;

    // **Construtor**
    public PilhaVetorEx1(int tamanho) {
        this.elementos = new Object[tamanho]; //Reservando espaço na memória ao chamar new
        indice = 0;
    }

    // Empilha o item no topo da pilha se não estiver cheia, OU SEJA, adiciona um objeto ao topo da pilha.
    public void empilhar(Object item) {
        if(!pilhaCheia()) { //Verifica se não está cheia
            elementos[indice] = item; //Adiciona o item na posição indicada pelo índice
            System.out.println(elementos[indice]);
            indice++; //Incrementa o índice
        }

    }

    // Desempilha remove o item do topo da pilha e retorna o valor, OU SEJA, retira o objeto do topo da pilha se não estiver vazia.
    public Object desempilhar() {
        if(!pilhaVazia()) { // Verifica se não está vazia 
            indice--; //Decrementa o índice
            return elementos[indice];//Retorna o item do topo da pilha
        }else{
            return null; //Caso a pilha esteja vazia, retorna null.
        }   
    }

    // Retorna Verdadeiro se a pilha estiver vazia, OU SEJA, informa que todos os objetos já foram removidos.
    public boolean pilhaVazia() {
        if(indice == 0)
            return true;
        else
            return false;
    }

    // Retorna Verdadeiro se a pilha estiver Cheia.
    public boolean pilhaCheia() {
        if(indice == elementos.length)
            return true;
        else
            return false;
    }

}
