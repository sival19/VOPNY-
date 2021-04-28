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
                stack.add(stack.size(),c);
            else if (c=='{')
                stack.add(stack.size(),c);
            else if (c=='[')
                stack.add(stack.size(),c);
            else if(c==')')
                if (stack.isEmpty())
                    return false;
                else if(stack.contains('('))
                    stack.remove(stack.size()-1);
                else
                    return false;
            else if(c== '}')
                if(stack.isEmpty())
                    return false;
                else if(stack.contains('{'))
                    stack.remove(stack.size()-1);
                else
                    return false;

            else if(c== ']')
                if(stack.isEmpty())
                    return false;
                else if(stack.contains('['))
                    stack.remove(stack.size()-1);
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
        MatchingBracketsV2 pc = new MatchingBracketsV2();

        Scanner inputStream = null;
        File file = new File("C:\\Users\\iceha\\OneDrive\\Skrivebord\\2.Semester\\VOP\\MASTER\\exercises\\cehck.txt");

        try {
            inputStream = new Scanner(file);
            while (inputStream.hasNextLine()){
                String result = inputStream.nextLine();
                boolean b = pc.ckeckBrackets(result);
                System.out.println(result + " has balanced brackets: " + b);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            inputStream.close();
        }

//        do {
//            System.out.println("Enter an expression with { [ ( ) ] }: ('q' to stop)");
//            if (!sb.toString().equalsIgnoreCase("q")) {
//                boolean b = pc.ckeckBrackets(sb.toString());
//                System.out.println(sb + " has balanced brackets: " + b);
//            }
//        } while (!sb.toString().equalsIgnoreCase("q"));
    }
}
