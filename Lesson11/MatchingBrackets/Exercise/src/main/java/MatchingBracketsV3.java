import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MatchingBracketsV3 {

    public void pushA(Character c, List<Character> arrayList){
        arrayList.add(0, c);
    }


    public char popA(List<Character> arrayList){
         char i = arrayList.get(0);
         arrayList.remove(0);
         return i;
    }


    public boolean ckeckBrackets(String expression) {
        List<Character> stack = new LinkedList<>();
        char c;
        for (int i = 0; i < expression.length(); i++) {
            c = expression.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                pushA(c,stack);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = popA(stack);

                if (!(open == '(' && c == ')' || open == '{' && c == '}' || open == '[' && c == ']')) {
                    return false;

                }
            }
        }
        return stack.isEmpty();

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatchingBracketsV3 pc = new MatchingBracketsV3();

        File file = new File("C:\\Users\\iceha\\OneDrive\\Skrivebord\\2.Semester\\VOP\\MASTER\\exercises\\cehck.txt");
        try (Scanner inputStream = new Scanner(file)) {
            while (inputStream.hasNextLine()) {
                String result = inputStream.nextLine();
                boolean b = pc.ckeckBrackets(result);
                System.out.println(result + " has balanced brackets: " + b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
