package Exercicios_aula4;
//Aula 04 - Filas
/*
   Neste caso o conceito FIFO (First-In First-out), não é mais válido, porém a
   adição de novas regras pode incrementar as funcionalidades da Fila.

   Métodos obrigatórios da fila:
   public void adicionar(Object item); -> Adiciona no final da fila.
   public Object remover(); -> Remove no início da fila.
   public Object exibirInicio(); -> Exibe o final da fila
   public int tamanho(); -> Retorna o tamanho da fila

   A fila deverá ser implementada utilizando ArrayList!
*/

/*2)crie uma classe FilaPrioridade de forma similar a classe Fila, porém modifique o método adicionar incluindo a seguinte regra:
 * uma fila onde pessoas idosas (com 60 anos ou mais) têm prioridade. Elas são inseridas antes das pessoas mais jovens na fila.
 * Agora pense nos conceitos de herança de POO para reaproveitar o código da classe Pessoa, e crie uma nova classe FilaPrioridade.
*/

import java.util.List; //Importa a interface List, que define uma lista ordenada de elementos.
import java.util.ArrayList; //Importa a classe ArrayList, que implementa a interface List com um array 

public class FilaPrioridadeEx2 {

    // Declara uma lista (fila) de objetos do tipo PessoaEx2 usando a implementação ArrayList.
    List<PessoaEx2> fila = new ArrayList<PessoaEx2>();

    /* Método adicionar(): verifica se a pessoa possui mais de 60 anos. Se possuir,
     * verifica a última pessoa com mais de 60 anos e adiciona após essa pessoa.
     */
    // Ou seja, método para adicionar uma pessoa à fila de prioridade.
    // Se a pessoa tiver (idade >= 60), ela tem prioridade e será inserida antes das pessoas (idade < 60).
    public void adicionar(PessoaEx2 pessoa) {
        boolean sinaleiro = false; // Variável de controle para indicar se a pessoa foi inserida na posição correta.

        if (pessoa.getIdade() < 60) { // verifica se a pessoa tem menos de 60 anos.
            fila.add(pessoa); // Se a pessoa ter (idade < 60), adiciona ao final da fila.

        } else { // Se a pessoa for idosa, deve ser inserida antes das pessoas mais jovens.
            for (int i = 0; i < fila.size(); i++) { // Percorre do início ao fim da fila.
                if (fila.get(i).getIdade() < 60) {  // Verifica se a pessoa na posição 'i' é mais jovem (idade < 60).
                    fila.add(i, pessoa); // Insere a pessoa idosa antes da pessoa mais jovem na posição 'i'.
                    sinaleiro = true; // Marca que a pessoa idosa foi inserida.
                    break; // Encerra o loop for, pois já encontrou a posição correta.
                }
            }
            if (sinaleiro == false) { // Se nenhuma pessoa mais jovem foi encontrada (todas na fila são idosas).
                fila.add(pessoa); // Adiciona a pessoa idosa ao final da fila.
            }
        }

    }

    public PessoaEx2 remover() { // Método para remover a pessoa que está no início da fila (a primeira da lista).
        return fila.remove(0); /* Remove e retorna o primeiro elemento da lista (posição 0).
         Qual o primeiro índice da lista? = 0.*/ 
    }

    public PessoaEx2 exibirInicio() { // Método para exibir a pessoa que está no início da fila sem removê-la.
        return fila.get(0); // Retorna o primeiro elemento da lista (posição 0) sem removê-lo.
    }

    public int tamanho() {  // Método para retornar o tamanho da fila (quantidade de pessoas na lista).
        return fila.size(); // Retorna o número de elementos na lista (tamanho da fila).
    }

}

/*Mais explicações: 
*Fila de Prioridade: O objetivo da classe é gerenciar uma fila onde pessoas idosas (com 60 anos ou mais) têm prioridade. 
Elas são inseridas antes das pessoas mais jovens na fila.
*Método adicionar: Verifica a idade da pessoa. Se for (idade < 60), é adicionada ao final da fila. Se for (idade >= 60), 
a pessoa será inserida antes da primeira pessoa mais jovem.
*Método remover: Remove e retorna a pessoa no início da fila.
*Método exibirInicio: Exibe a pessoa no início da fila, sem removê-la.
*Método tamanho: Retorna o número de pessoas na fila.
*/ 