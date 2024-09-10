package Exercicios_aula3;

public class TestePilha {
    public static void main(String[] args) {
        // **** Pilha com Vetor *****
        PilhaVetorEx1 minhaPilha = new PilhaVetorEx1(10);
        
        System.out.println();

        System.out.println("\n ----------PILHA COM VETOR: ----------");
        System.out.println("Pilha está vazia? : " + minhaPilha.pilhaVazia());
        System.out.println("Pilha está cheia? : " + minhaPilha.pilhaCheia());

        System.out.println("\n ---------- Empilhar: ---------- ");
        for (int i = 0; i < 10; i++) {
            minhaPilha.empilhar(i);
        }

        System.out.println();

        System.out.println(" \n ---------- Desempilhar: ---------- ");
        for (int i = 0; i < 10; i++) {
            System.out.println(minhaPilha.desempilhar());
        }
        System.out.println();


        //**************** Pilha com Lista ****************************
        PilhaEx2 minhaPilha2 = new PilhaEx2();

        System.out.println();

        System.out.println(" \n ---------- PILHA COM LISTA ---------- ");
        System.out.println("Pilha está vazia? : " + minhaPilha2.pilhaVazia());

        System.out.println("\n ---------- Empilhar: ---------- ");
        for(int i = 0; i<10; i++){
            minhaPilha2.empilhar(i);
        }

        System.out.println();

        
        System.out.println("\n ----------- Desempilhar: ----------- ");
        for(int i = 0; i<10; i++){
            System.out.println(minhaPilha2.desempilhar());
        }










    }

}
