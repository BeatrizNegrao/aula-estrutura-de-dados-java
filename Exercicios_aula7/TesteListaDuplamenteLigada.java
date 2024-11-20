package Exercicios_aula7;

public class TesteListaDuplamenteLigada {
    public static void main(String[] args){

        ListaDuplamenteLigadaEx1 minhaLista = new ListaDuplamenteLigadaEx1();

         //------------------Ex1--------------------//
        minhaLista.adicionar("Rodrigo");
        minhaLista.adicionar("Pedro");
        minhaLista.adicionar("Maria");
        minhaLista.adicionar("Julia");
        minhaLista.imprimirTodaLista();
        
        minhaLista.adicionar("Beatriz", 1);
        System.out.println("----------ADICIONANDO--------------");
        for(int i = 0; i < minhaLista.getTamanho(); i++){
            System.out.println(i + " - " + minhaLista.getLista(i));
        }

        minhaLista.remover("Maria", 3);
        System.out.println("----------REMOVENDO--------------");
        for(int i = 0; i < minhaLista.getTamanho(); i++){
            System.out.println(i + " - " + minhaLista.getLista(i));
        }
    }
}
