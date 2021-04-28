import java.util.Scanner;
import java.util.Stack;

/**
 * @author erso
 */
public class MatchingBrackets {


    public boolean ckeckBrackets(String expression) {

        Stack<Character> stack = new Stack<Character>();
        char c;
        for(int i=0; i< expression.length(); i++){
            c= expression.charAt(i);
            if(c== '(')
                stack.push(c);
            else if (c=='{')
                stack.push(c);
            else if (c=='[')
                stack.push(c);
            else if(c==')')
                if (stack.empty())
                    return false;
                else if(stack.peek()=='(')
                    stack.pop();
                else
                    return false;
            else if(c== '}')
                if(stack.empty())
                    return false;
                else if(stack.peek()=='{')
                    stack.pop();
                else
                    return false;

            else if(c== ']')
                if(stack.empty())
                    return false;
                else if(stack.peek()=='[')
                    stack.pop();
                else
                    return false;
        }
        return stack.empty();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatchingBrackets pc = new MatchingBrackets();

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
