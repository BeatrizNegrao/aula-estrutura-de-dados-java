 /* Crie um método recursivo que receba dois números inteiros como parâmetros, o primeiro será o número da base e o segundo a potência,
 e retorne o valor da função.*/
public class EstruturaDadosL2Ex2 {

    public static void main(String[] args) {
        System.out.println("Valor: ");
        System.out.println(basePotencia(2,2));
        System.out.println("");
        }

        public static int basePotencia(int base, int potencia) {
           if(potencia == 0){
              return 1;  //todo número elevado a potência 0 = 1.
           }else{
              return base*basePotencia(base, potencia-1); /*exemplo1: (base:2,potência:2)=> 2 * (2^2-1) => 2*2 = 4.
                                                            exemplo2: (base:4,potência:3) => 4 * (4^3-1) => 4*16 = 64. */
        }
     }       
}
