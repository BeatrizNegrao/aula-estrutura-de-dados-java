package Exercicios_aula8;

public class nodeListaCircularEx1{
    private Object info;
    private nodeListaCircularEx1 proximo;
    private nodeListaCircularEx1 anterior;

    public nodeListaCircularEx1(Object info, nodeListaCircularEx1 proximo, nodeListaCircularEx1 anterior) {
        this.info = info;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public Object getInfo() {
        return info;
    }

    public nodeListaCircularEx1 getProximo() {
        return proximo;
    }

    public nodeListaCircularEx1 getAnterior() {
        return anterior;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public void setProximo(nodeListaCircularEx1 proximo) {
        this.proximo = proximo;
    }

    public void setAnterior(nodeListaCircularEx1 anterior) {
        this.anterior = anterior;
    }

}
