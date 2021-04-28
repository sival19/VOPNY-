import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchingBracketsV2 {



    public boolean ckeckBrackets(String expression) {
        List<Character> stack = new ArrayList<>();
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
    public static void main(String[] args) {
        MatchingBracketsV2 pc = new MatchingBracketsV2();

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
