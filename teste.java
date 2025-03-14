import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        stackOverFlow(5);
    }

    public static void stackOverFlow(int t){
        if(t < 5247){
            System.out.print(t);
            stackOverFlow(t + 1);
        }
    }
}
 