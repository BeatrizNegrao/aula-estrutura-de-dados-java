// Aula 01 - Vetores e Matrizes 
/* 6) Escreva um método para imprimir no console uma matriz de 2 dimensões. Utilize o seguinte padrão:
|   X   |   X   |   X   |
|   Y   |   Y   |   Y   |
|   Z   |   Z   |   Z   |
Utilize System.out.print( "» + "\t" + variável + "It" + «|") para imprimir no console os marcadores com o espaço TAB entre eles.*/ 

public class EstruturaDadosL1Ex6 {
    public static void main(String[] args) {
        // Crianção da matriz de duas dimenções 3x3. 
    String[][] matriz = {
        {"X", "Y", "Z"},
        {"X", "Y", "Z"},
        {"X", "Y", "Z"}};

    imprimirMatriz(matriz); // Chamando o método para imprimir a matriz.
    }
   
    public static void imprimirMatriz(String[][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for(int m = 0; m < matriz[i].length; m++){
                System.out.println( "|" + "\t" + matriz[i][m] + "\t" + "|"); 
            }
            System.out.println();
        }
    }   
}

