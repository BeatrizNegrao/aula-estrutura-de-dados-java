package Exercicios_aula4;
//Aula 04 - Fila por prioridade
/*
   Neste caso o conceito FIFO (First-In First-out), não é mais válido, porém a
   adição de novas regras pode incrementar as funcionalidades da Fila.
   
   Métodos obrigatórios da fila:
   public void adicionar(Object item); -> Adiciona no final da fila.
   public Object remover(); -> Remove no inicío da fila.
   public Object exibirInicio(); -> Exibe o final da fila
   public int tamanho(); -> Retorna o tamanho da fila

   A fila deverá ser implementada utilizando ArrayList!
*/

/*2)crie uma classe FilaPrioridade de forma similar a classe Fila, porém modifique o método adicionar incluindo a seguinte regra:
 * uma fila onde pessoas idosas (com 60 anos ou mais) têm prioridade. Elas são inseridas antes das pessoas mais jovens na fila.
 * Agora pense nos conceitos de herança de POO para reaproveitar o código da classe Pessoa, e crie uma nova classe FilaPrioridade.
*/



public class PessoaEx2{
    int idade;
    String nome;

    //Construtor da classe
    public PessoaEx2(int idade, String nome){
        this.idade = idade;
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getNome(){
        return nome;
    }
         
}

