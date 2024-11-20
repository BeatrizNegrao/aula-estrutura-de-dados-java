package Exercicios_aula8;

public class nodeArvoreBinaria {
    // O nó deverá possuir um campo info e dois ponteiros para nós
    private Object info;
    private nodeArvoreBinaria noEsquerda;
    private nodeArvoreBinaria noDireira;

    public nodeArvoreBinaria(Object info, nodeArvoreBinaria noEsquerda, nodeArvoreBinaria noDireira) {
        this.info = info;
        this.noEsquerda = noEsquerda;
        this.noDireira = noDireira;
    }

    public Object getInfo() {
        return info;
    }
    public nodeArvoreBinaria getNoEsquerda() {
        return noEsquerda;
    }
    public nodeArvoreBinaria getNoDireira() {
        return noDireira;
    }
    
    public void setInfo(Object info) {
        this.info = info;
    }
    public void setNoEsquerda(nodeArvoreBinaria noEsquerda) {
        this.noEsquerda = noEsquerda;
    }
    public void setNoDireira(nodeArvoreBinaria noDireira) {
        this.noDireira = noDireira;
    }
}
