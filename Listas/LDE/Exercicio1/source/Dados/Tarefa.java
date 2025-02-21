package Exercicio1.source.Dados;

public class Tarefa {
    private String TaskName;
    private int priority;

    public Tarefa(String name, int priority){
        this.TaskName = name;
        this.priority = priority;
    }

    public String getTaskName(){ return this.TaskName; }
    public void setTaskName(String name) { this.TaskName = name; }

    public int GetTaskPriority() { return this.priority; }
    public void setTaskPriority(int newPriority) { this.priority = newPriority; }
}
