package EstruturaDados_AC1;
//2) Utilize expressao.length() para obter a quantidade de caracteres da String
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
        
        
        // Percorre cada caractere da expressão.
        for (int i = 0; i < expressao.length(); i++) {
            char ch = expressao.charAt(i);

            // Se o caractere for um símbolo de abertura, empilha o símbolo de fechamento correspondente.
            if (ch == '{') { // Verifica se o caractere é uma chave de abertura.
                pilha.empilhar('}'); // Adiciona chave de fechamento
            } else if (ch == '[') { // Verifica se o caractere é um colchete de abertura.
                pilha.empilhar(']'); // Adiciona o colchete de fechamento correspondente.
            } else if (ch == '(') { // Verifica se o caractere é um parêntese de abertura.
                pilha.empilhar(')'); // Adiciona  o parêntese de fechamento.
            }

            // Se o caractere for um símbolo de fechamento, verifica se ele corresponde ao símbolo no topo da pilha.
            else if (ch == '}' || ch == ']' || ch == ')') { 
                if (pilha.pilhaVazia() || (char) pilha.desempilhar() != ch) { // Verifica se a pilha está vazia (o que significa que não há correspondência) ou se o símbolo no topo da pilha não é o correspondente.
                    return false; // Se não houver correspondência, a expressão está desbalanceada.
                }
            }
        }

        // Se ao final a pilha estiver vazia, significa que todos os símbolos foram balanceados.
        return pilha.pilhaVazia();

    }

}

