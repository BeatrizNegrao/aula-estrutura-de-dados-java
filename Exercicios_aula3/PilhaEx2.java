package Exercicios_aula3;
/*Aula 03 - Pilhas
*2) Com base na classe PilhaVetor, crie uma Classe Pilha que implemente todos os métodos padrões, mas
utilizando Listas ao invés de vetores para armazenar os dados.
*Teste o objeto pilha empilhando uma lista sequencial de números e os desempilhando em seguida.
*Utilize os métodos do objeto ArrayList() :
*.add(); que permite adicionar itens a lista.
*.remove(index lista); para remover itens.
*.size(); que retorna o tamanho da lista.
*.isEmpty(); que informa se a lista está vazia.
*Obs:.Em Java todos os objetos derivam da Classe Object, portanto uma lista do tipo Object pode receber qualquer objeto.
*/
import java.util.ArrayList;
//Pilha implementada usando lista.
public class PilhaEx2 {
    //Armazena os elementos da pilha, utilizando ArrayList do tipo Object
    ArrayList<Object> elementos;
    //**Construtor**
    public PilhaEx2(){
        elementos = new ArrayList<Object>();
    }
    //Método que verifica se a pilha está vazia
    public boolean pilhaVazia(){
        if(elementos.size() == 0) return true;
        else                      return false;
    }
    //Empilha o item no topo da pilha 
    public void empilhar(Object item){
        elementos.add(item);
        System.out.println(item);
    }

    //Desempilha remove o item do topo da pilha e retorna o valor
    public Object desempilhar(){
        if(!pilhaVazia())
            return elementos.remove(elementos.size()-1); /*O método elementos.size() retorna o número total de elementos na lista,
                                                         mas os índices dos elementos da lista vão de 0 até o tamanho da lista - 1. o objetivo é remover o item do topo da pilha, 
                                                         que corresponde ao último elemento da lista. Para acessar esse último elemento, 
                                                         é necessário usar o índice size() - 1.*/
            return null; //Caso a pilha esteja vazia, retorna null.
        
    }


}
