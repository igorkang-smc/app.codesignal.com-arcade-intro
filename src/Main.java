import intro.Solutions;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Object ob = Solutions.digitsProduct_56.solution(19);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(ob);
    }
}