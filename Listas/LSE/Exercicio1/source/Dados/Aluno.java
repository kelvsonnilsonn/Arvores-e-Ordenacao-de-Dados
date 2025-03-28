package Exercicio1.source.Dados;

public class Aluno implements Comparable <Aluno> {
    private String matricula;
    private String nome;
    private double media;
    private int faltas;

    public Aluno(String matricula){
        this.matricula = matricula;
    }

    public String getMatricula(){ return matricula; }
    public void setMatricula(String matri){ this.matricula = matri; }

    public String getNome(){ return nome; }
    public void setNome(String nome){ this.nome = nome; }

    public double getMedia(){ return media; }
    public void setMedia(double media){ this.media = media; }

    public int faltas(){ return faltas; }
    public void setFaltas(int faltas){ this.faltas = faltas; }

    @Override
    public String toString() {
        return String.format("Aluno: %s - Matricula: %s\nMedia = %.1f - Faltas = %d", nome, matricula, media, faltas);
    }

    public int compareTo(Aluno outro) {
        return this.matricula.compareTo(outro.matricula);
    }    
}