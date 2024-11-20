package Exercicios_aula8;

public class testeListaCircular {
     public static void main(String[] args){

        ListaCircularEx1 minhaLista = new ListaCircularEx1();

         //------------------Ex1--------------------//
        minhaLista.adicionar("Pricila");
        minhaLista.adicionar("Pedro");
        minhaLista.adicionar("Marcelo");
        minhaLista.adicionar("Carol");
        
        minhaLista.adicionar("Beatriz", 1);
        System.out.println("----------ADICIONANDO--------------");
        for(int i = 0; i < minhaLista.getTamanho(); i++){
            System.out.println(i + " - " + minhaLista.getListaCircular(i));
        }

    }
}
