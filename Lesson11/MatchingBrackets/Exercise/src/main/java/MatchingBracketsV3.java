import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MatchingBracketsV3 {

    public void pushA(Character c, List<Character> arrayList){
        arrayList.add(arrayList.size(), c);
    }


    public void popA(List<Character> arrayList){
         arrayList.remove(arrayList.size()-1);
    }


    public boolean ckeckBrackets(String expression) {
        List<Character> stack = new ArrayList<>();
        char c;
        for(int i=0; i< expression.length(); i++){
            c= expression.charAt(i);
            if(c== '(')
                pushA(c, stack);
            else if (c=='{')
                pushA(c,stack);
            else if (c=='[')
                pushA(c,stack);
            else if(c==')')
                if (stack.isEmpty())
                    return false;
                else if(stack.contains('('))
                    popA(stack);
                else
                    return false;
            else if(c== '}')
                if(stack.isEmpty())
                    return false;
                else if(stack.contains('{'))
                    popA(stack);
                else
                    return false;

            else if(c== ']')
                if(stack.isEmpty())
                    return false;
                else if(stack.contains('['))
                    popA(stack);
                else
                    return false;

            System.out.println(stack);


        }

        return stack.isEmpty();

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatchingBracketsV3 pc = new MatchingBracketsV3();

        Scanner in = new Scanner(System.in);
        String expression = "";
        do {
            System.out.println("Enter an expression with { [ ( ) ] }: ('q' to stop)");
            expression = in.nextLine();
            if (!expression.equalsIgnoreCase("q")) {
                boolean b = pc.ckeckBrackets(expression);
                System.out.println(expression + " has balanced brackets: " + b);
            }
        } while (!expression.equalsIgnoreCase("q"));
    }
}
