package EstruturaDados_AC1;
// Utilize expressao.length() para obter a quantidade de caracteres da String
// expressao.
// Utilize expressao.charAt( indice ), para lêr um caracter da string expressao
// definido pelo índice.
// Utilize os métodos da classe Pilha.
/* ==== Adicione o seu código aqui ==== */
/*
 * ==== Não esqueça de comentar toda a lógica, irei retirar pontos se não
 * houver comentários ====
 */

public class ValidaBalanceamento {

    public static boolean validaBalanceamento(String expressao) {
        Pilha pilha = new Pilha(); 

        for (int i = 0; i < expressao.length(); i++) {
            char ch = expressao.charAt(i);

            // Se for um símbolo de abertura, empilha o símbolo de fechamento correspondente
            if (ch == '{') { // Verifica se o caracter é chave de abertura
                pilha.empilhar('}'); // Adiciona chave de fechamento
            } else if (ch == '[') { // Verifica se o caracter é colchete de abertura 
                pilha.empilhar(']'); // Adiciona o colchete de fechamento 
            } else if (ch == '(') { // Verifica se o caracter é parenteses de abertura 
                pilha.empilhar(')'); // Adiciona o parenteses de fechamento 
            }

            // Se for um símbolo de fechamento, verifica com o topo da pilha
            else if (ch == '}' || ch == ']' || ch == ')') { 
                if (pilha.pilhaVazia() || (char) pilha.desempilhar() != ch) { // verifica se a pilha está vazia ou se o caracter é diferente do valor da variável ch
                    return false; // Desbalanceado
                }
            }
        }

        // Se ao final a pilha estiver vazia, a sequência está balanceada
        return pilha.pilhaVazia();

    }

}

