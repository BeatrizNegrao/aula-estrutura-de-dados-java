package Exercicios_aula4;

public class TesteFila {
    public static void main(String[] args){
        //Ex1)
        FilaEx1 minhaFila = new FilaEx1();// Cria um novo objeto da classe FilaEx1, que gerenciará a fila de itens.

        
        System.out.println("Enfileirando: ");
        for(int i = 0; i < 10; i++){ // Laço para adicionar 10 valores (de 0 a 9) à fila.
            minhaFila.adicionar(i);// Adiciona o valor 'i' à fila.
            System.out.print(i + " | "); // Imprime o valor recém-adicionado, seguido de um separador "|".  

        }
        System.out.println("\nDesenfileirar: ");
        for(int i = 0; i < 10; i++){ // Laço para remover os 10 valores da fila, um por um, e imprimir cada valor removido.
            System.out.print(minhaFila.remover() + " | "); // Remove o item do início da fila e imprime o valor removido, seguido de um separador "|".
        }

        /*Mais explicações:
         * Enfileirando (Adicionando): O laço for adiciona os números de 0 a 9 à fila e imprime cada número conforme é adicionado.
         * Desenfileirando (Removendo): O segundo laço for remove cada número da fila na mesma ordem em que foi adicionado, 
         já que a fila segue o princípio de FIFO, e imprime cada número removido.
        */

        System.out.println("\n----------------------------------------");
        //Ex2)
        FilaPrioridadeEx2 filaINSS = new FilaPrioridadeEx2();//Cria um novo objeto FilaPrioridadeEx2, que irá gerenciar a fila de pessoas.
        PessoaEx2 p1, p2, p3, p4, p5; // Declaração de variáveis do tipo PessoaEx2.

        // Cria uma nova pessoa com 17 anos chamada "Vitor".
        p1 = new PessoaEx2(17, "Vitor");
        System.out.println(p1.getNome());// Imprime o nome da pessoa "Vitor".
        filaINSS.adicionar(p1);// Adiciona "Vitor" à fila, sem prioridade (pois tem menos de 60 anos).

        // Cria uma nova pessoa com 65 anos chamada "João".
        p2 = new PessoaEx2(65, "João");
        System.out.println(p2.getNome());// Imprime o nome da pessoa "João".
        filaINSS.adicionar(p2);// Adiciona "João" à fila com prioridade, pois ele tem mais de 60 anos.

        // Cria uma nova pessoa com 69 anos chamada "Rosana".
        p3 = new PessoaEx2(69, "Rosana");
        System.out.println(p3.getNome());// Imprime o nome da pessoa "Rosana".
        filaINSS.adicionar(p3);// Adiciona "Rosana" à fila com prioridade (mais de 60 anos).

        // Cria uma nova pessoa com 40 anos chamada "Gabriela".
        p4 = new PessoaEx2(40, "Gabriela");
        System.out.println(p4.getNome());// Imprime o nome da pessoa "Gabriela".
        filaINSS.adicionar(p4);// Adiciona "Gabriela" ao final da fila, sem prioridade (menos de 60 anos).

        // Cria uma nova pessoa com 67 anos chamada "José".
        p5 = new PessoaEx2(67, "José");
        System.out.println(p5.getNome());// Imprime o nome da pessoa "José".
        filaINSS.adicionar(p5);// Adiciona "José" à fila com prioridade, pois tem mais de 60 anos.


        System.out.println("------------------------------");

        // Obtém o tamanho atual da fila e armazena na variável (tamanhofila)
        int tamanhofila = filaINSS.tamanho();

        PessoaEx2 aux;// Declaração de uma variável auxiliar para armazenar temporariamente as pessoas removidas da fila.

        for(int i = 0; i < tamanhofila; i++){//LOOP FOR percorre a fila e remove uma pessoa por vez, imprimindo o nome e a idade de cada uma.
            aux = filaINSS.remover();// Remove a pessoa no início da fila e armazena em 'aux'
            System.out.println(aux.getNome() + "| " + aux.getIdade()); // Imprime o nome e a idade da pessoa removida.
        }


    }
    
}

