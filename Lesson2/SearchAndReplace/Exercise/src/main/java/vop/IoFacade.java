package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IoFacade {

    public String readFile(File inFile){
        StringBuilder sb = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(inFile);
            while (scanner.hasNext()){
                sb.append(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            scanner.close();
        }
        return sb.toString();
    }

    public void writeFile(String txt, File output){
        try(FileWriter fw = new FileWriter(output)){
            fw.write(txt);
            fw.flush();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
