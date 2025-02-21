package BinariaBusca;

import BinariaBusca.source.ABB;
import BinariaBusca.source.Dados.*;

public class App {
    public static void main(String[] args){
        ABB<Integer> arvore = new ABB<Integer>(); // isso cria uma cópia da classe ABBNode para Integer, podendo mudar para qualquer outro tipo de dado.
        ABB<Aluno> turma = new ABB<Aluno>();
    }
}
