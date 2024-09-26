package EstruturaDados_AC1;

public class Console {
    public static void main(String[] args) {

         // Testa a função de validação com uma expressão corretamente balanceada.
        boolean resp1 = ValidaBalanceamento.validaBalanceamento("{[()()]}");
         // Exibe a resposta esperada TRUE, já que a expressão está balanceada.
        System.out.println("Resposta deve ser TRUE: = " + resp1);
         // Testa a função de validação com uma expressão desbalanceada.
        resp1 = ValidaBalanceamento.validaBalanceamento("{[(a))]}");
        // Exibe a resposta esperada FALSE, já que a expressão não está balanceada.
        System.out.println("Resposta deve ser FALSE: = " + resp1);

        // ******* TESTA FILA PRIORIDADE *******

        FilaPacientes fila = new FilaPacientes(); // Cria uma nova fila de pacientes.

        // Adiciona pacientes na fila com diferentes níveis de prioridade.
        fila.adicionar(new Paciente("João", 5));
        fila.adicionar(new Paciente("Maria", 2));
        fila.adicionar(new Paciente("Pedro", 0));
        fila.adicionar(new Paciente("Jorge", 2));

        // Imprime a sequência correta de prioridade esperada.
        System.out.println("Sequencia Correta: Pedro => Maria => Jorge => João");

        // Loop que remove pacientes da fila, imprimindo suas prioridades e nomes até que a fila esteja vazia.
        while (fila.tamanho() > 0) {
            Paciente p = fila.remover();  // Remove o primeiro paciente da fila.
            System.out.println(p.getPrioridade() + " - " + p.getNome());  // Imprime a prioridade e o nome do paciente removido.
        }
    }
}
