import java.io.*;
import java.util.*;
import java.util.regex.*;

public class TimeComplexityAnalyzer {

    static int loopCount = 0;
    static int maxNestedLoops = 0;
    static Stack<Integer> loopStack = new Stack<>();
    static Set<String> functions = new HashSet<>();
    static Set<String> recursiveFunctions = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Enter path to source code file:");
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        analyzeFile(filePath);
        printComplexity();
    }

    private static void analyzeFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        String currentFunction = null;
        int currentLoopDepth = 0;

        Pattern functionPattern = Pattern.compile("\\b(\\w+)\\s+\\w+\\s*\\(.*\\)\\s*\\{?");
        Pattern loopPattern = Pattern.compile("\\b(for|while|do)\\b");
        Pattern funcCallPattern = Pattern.compile("\\b(\\w+)\\s*\\(");

        while ((line = br.readLine()) != null) {
            line = line.trim();

            // Detect function definitions
            Matcher funcMatcher = functionPattern.matcher(line);
            if (funcMatcher.find()) {
                currentFunction = funcMatcher.group(1);
                functions.add(currentFunction);
            }

            // Detect loops
            Matcher loopMatcher = loopPattern.matcher(line);
            if (loopMatcher.find()) {
                loopStack.push(1);
                maxNestedLoops = Math.max(maxNestedLoops, loopStack.size());
            }

            // Detect closing of loops
            if (line.contains("}")) {
                if (!loopStack.isEmpty()) loopStack.pop();
            }

            // Detect recursion
            if (currentFunction != null) {
                Matcher callMatcher = funcCallPattern.matcher(line);
                while (callMatcher.find()) {
                    String calledFunc = callMatcher.group(1);
                    if (calledFunc.equals(currentFunction)) {
                        recursiveFunctions.add(currentFunction);
                    }
                }
            }
        }
        br.close();
    }

    private static void printComplexity() {
        System.out.println("\n--- Time Complexity Analysis ---");

        if (maxNestedLoops == 0 && recursiveFunctions.isEmpty()) {
            System.out.println("Estimated Complexity: O(1)");
        } else {
            String loopComplexity = maxNestedLoops > 0 ? "O(n^" + maxNestedLoops + ")" : "";
            String recursionComplexity = !recursiveFunctions.isEmpty() ? "+ recursion (depends on function calls)" : "";
            System.out.println("Estimated Complexity: " + loopComplexity + " " + recursionComplexity);
        }

        if (!recursiveFunctions.isEmpty()) {
            System.out.println("Recursive functions detected: " + recursiveFunctions);
        }
    }
}
