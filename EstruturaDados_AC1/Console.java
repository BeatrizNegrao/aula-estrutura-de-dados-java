package EstruturaDados_AC1;

public class Console {
    public static void main(String[] args) {
        
        boolean resp1 =ValidaBalanceamento.validaBalanceamento("{[()()]}");
        System.out.println("Resposta deve ser TRUE: = " + resp1);
        resp1 = ValidaBalanceamento.validaBalanceamento("{[(a))]}");
        System.out.println("Resposta deve ser FALSE: = " + resp1);
        // ******* TESTA FILA PRIORIDADE *******
        
    
        FilaPacientes fila = new FilaPacientes();
        fila.adicionar(new Paciente("João", 5));
        fila.adicionar(new Paciente("Maria", 2));
        fila.adicionar(new Paciente("Pedro", 0));
        fila.adicionar(new Paciente("Jorge", 2));
        System.out.println("Sequencia Correta: Pedro => Maria => Jorge => João");
        while (fila.tamanho() > 0) {
            Paciente p = fila.remover();
            System.out.println(p.getPrioridade() + " - " + p.getNome());
        }
    }
}
