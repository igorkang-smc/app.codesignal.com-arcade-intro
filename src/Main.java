import intro.Solutions;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        String[] s = Solutions.fileNaming_57.solution(new String[]{"doc", "doc", "image", "doc(1)", "doc"});
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(Arrays.asList(s));
    }
}