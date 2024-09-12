package Exercicios_aula4;
//Aula 04 - Filas
/*
   Fila - conceito FIFO (first-in  first-out).
   Métodos obrigatórios da fila:
   public void adicionar(Object item); -> Adiciona no final da fila.
   public Object remover(); -> Remove no inicío da fila.
   public Object exibirInicio(); -> Exibe o final da fila
   public int tamanho(); -> Retorna o tamanho da fila

   A fila deverá ser implementada utilizando ArrayList!
*/

/*1) Crie uma Classe in Java com o nome Fila e implemente os métodos padrões .
 * Implemente os métodos da interface.
 * Teste o objeto fila adicionando uma lista sequencial de números e os removendo em seguida.
 * Utilize os métodos do objeto ArrayList() :
 * .add(); que permite adicionar itens a lista
 * .remove(index lista); para remover itens
 * size(); que retorna o tamanho da lista
*/


import java.util.List;
import java.util.ArrayList;

public class FilaEx1 {

    // Declara uma lista genérica (fila) que pode armazenar qualquer tipo de objeto usando ArrayList.
    List<Object> fila = new ArrayList<>();

    public void adicionar(Object item) { // Método para adicionar um item à fila.
        fila.add(item); // Adiciona o item fornecido ao final da lista.
    }

    public Object remover() { // Método para remover o primeiro item da fila.
        return fila.remove(0); // Remove e retorna o primeiro item da lista (posição 0).
        // Qual o índice do inicio da lista? = 0.
    }

    // Método para exibir o primeiro item da fila sem removê-lo.
    public Object exibirInicio() {
        return fila.get(0);// Retorna o primeiro item da lista (posição 0) sem removê-lo.
    }

    // Método para retornar o tamanho atual da fila.
    public int tamanho() {
        return fila.size(); // Retorna o tamanho da lista.
    }

}

/* Mais explicações: 
 * Lista Genérica: A fila é uma lista que pode conter objetos de qualquer tipo, já que o tipo genérico Object é usado. 
  Isso permite que a fila armazene instâncias de qualquer classe.
 * Método adicionar: O item fornecido é adicionado ao final da lista, mantendo o comportamento de uma fila (inserção no final).
 * Método adicionar: O item fornecido é adicionado ao final da lista, mantendo o comportamento de uma fila (inserção no final).
 * Método exibirInicio: Retorna o primeiro item da fila sem removê-lo, permitindo que o primeiro item seja visualizado sem afetar a ordem.
 * Método tamanho: Retorna o tamanho atual na fila.
 */
