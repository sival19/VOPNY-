import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MatchingBracketsV2 {



    public boolean ckeckBrackets(String expression) {
        List<Character> stack = new ArrayList<Character>();
        char c;
        for(int i=0; i< expression.length(); i++){
            c= expression.charAt(i);
            if(c== '(')
                stack.add(c);
            else if (c=='{')
                stack.add(c);
            else if (c=='[')
                stack.add(c);
            else if(c==')')
                if (stack.isEmpty())
                    return false;
                else if(stack.contains('('))
                    stack.remove(i);
                else
                    return false;
            else if(c== '}')
                if(stack.isEmpty())
                    return false;
                else if(stack.contains('{'))
                    stack.remove(i);
                else
                    return false;

            else if(c== ']')
                if(stack.isEmpty())
                    return false;
                else if(stack.contains('['))
                    stack.remove(i);
                else
                    return false;
        }
        return stack.isEmpty();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        MatchingBrackets pc = new MatchingBrackets();
        File file = new File("check.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line= br.readLine())!=null) {
            sb.append(line);
            sb.append("\n");
        }

        fr.close();

        do {
            System.out.println("Enter an expression with { [ ( ) ] }: ('q' to stop)");
            if (!sb.toString().equalsIgnoreCase("q")) {
                boolean b = pc.ckeckBrackets(sb.toString());
                System.out.println(sb + " has balanced brackets: " + b);
            }
        } while (!sb.toString().equalsIgnoreCase("q"));
    }
}
