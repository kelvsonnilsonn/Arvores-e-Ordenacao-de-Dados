package source;

public class LSEAluno{
    private LSENode inicio;
    private LSENode fim;
    private int qtd;

    public boolean isEmpty(){
        return (this.qtd == 0);
    }

    private LSENode buscar(Aluno al) {
        for (LSENode aux = this.inicio; aux != null; aux = aux.getProx()) {
            if (al.compareTo(aux.getInfo()) == 0) {
                return aux;
            }
        }
        return null;
    }

    public void exibir (String matricula){
        Aluno procurar = new Aluno(matricula);
        LSENode retorno = this.buscar(procurar);

        if(retorno == NULL){
            System.out.println("Aluno não encontrado.");
        } else {
            System.out.println("Dados do aluno:");
            System.out.println(retorno.getInfo());
        }
    }


    public void inserirInicio(Aluno al){
        LSENode retorno = this.buscar(al);
        LSENode novo;
        if (retorno == NULL){
            novo = new LSENode(al);

            if(this.isEmpty() == true){
                this.fim = novo;
            } else {
                novo.setProx(this.inicio);
            }
            
            this.inicio = novo;
            this.qtd++;

            System.out.println("Aluno inserido");

        } else {
            System.out.println("Aluno já existe.");
        }
    }
}