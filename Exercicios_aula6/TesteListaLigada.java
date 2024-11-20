package Exercicios_aula6;

public class TesteListaLigada {
    public static void main(String[] args) {
       
        ListaLigadaEx1 minhaLista = new ListaLigadaEx1();
         //------------------Ex1--------------------//
        minhaLista.adicionar("Rodrigo");
        minhaLista.adicionar("Pedro");
        minhaLista.adicionar("Carlos");
        minhaLista.adicionar("Creusa");

        for(int i = 0; i < 4; i++){
            System.out.println(i +" - "+ minhaLista.getLista(i));
        }

        minhaLista.adicionar("Rafael",4);
        System.out.println("----------ADICIONANDO--------------");
        for(int i = 0; i < minhaLista.getTamanho(); i++){
            System.out.println(i +" - "+ minhaLista.getLista(i));
        }

        minhaLista.remover("Creusa",3);
        System.out.println("----------REMOVENDO--------------");
        for(int i = 0; i < minhaLista.getTamanho(); i++){
            System.out.println(i + " - " + minhaLista.getLista(i));
        }
    }
}


//Entregar na próxima aula 
//Altere o método adicionar para permitir adidiconar no indice 0;