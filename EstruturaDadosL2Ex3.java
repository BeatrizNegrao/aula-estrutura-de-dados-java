//Aula 02 - Recursão
//3) Um exemplo clássico de uma função matemática recursiva é o cálculo do fatorial de um número.
public class EstruturaDadosL2Ex3 {
    public static void main(String[] args){
        System.out.println("Fatorial: " + fatorial(4));// O método fatorial é chamado, estabelecendo um valor para a variável (numero).
    }

    public static int fatorial(int numero){
        if(numero == 0)return 1; // Se a variável (numero) for igual a zero, a condição de parada retorná 1 e a recursão termina.
        else          return numero*fatorial(numero-1); /* Se a variável (numero) for diferente de zero, a chamada recursiva
        retorná o seu valor multiplicado pelo fatorial de seu antecessor, ou seja, método continua se chamando até que a condição de parada (numero == 0) seja alcançada.
        Ex: numero = 4 
        -> execução com fatorial(4):
        fatorial(4) = 4 x fatorial(3) 
        fatorial(3) = 3 x fatorial(2)
        fatorial(2) = 2 x fatorial(1)
        fatorial(1) = 1 x fatorial(0) 
        fatorial(0) = 1 (confição de parada)
        -> em seguida, os resultados são multiplicados em ordem reversa:
        fatorial(1) = 1x1 = 1
        fatorial(2) = 2x1 = 2
        fatorial(3) = 3x2 = 6
        fatorial(4) = 4x6 = 24.        
         .*/
        
    }
}
