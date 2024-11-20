package Exercicios_aula8;

public class testeArvoreBinaria {
        public static void main(String[] args){
            ArvoreBinariaEx1 minhaArvore = new ArvoreBinariaEx1();
            minhaArvore.adicionar(5);
            minhaArvore.adicionar(3);
            minhaArvore.adicionar(1);
            minhaArvore.adicionar(2);
            minhaArvore.adicionar(4);
            minhaArvore.adicionar(8);
            minhaArvore.adicionar(7);
            minhaArvore.adicionar(6);
            minhaArvore.adicionar(9);

            System.out.println("----------------Pré Ordem:---------------- ");
            minhaArvore.preOrdem();

            System.out.println("------------------Ordem:----------------");
            minhaArvore.Ordem();
            
            System.out.println("------------------Pós Ordem----------------");
            minhaArvore.posOrdem();
       }
}
