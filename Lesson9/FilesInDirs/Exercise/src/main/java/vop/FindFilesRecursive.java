package vop;

import java.io.File;
import java.util.Scanner;

/**
 * @author erso
 */
public class FindFilesRecursive {

    private int noDirs;
    private int noFiles;

//    private static void findFiles(File file, File[] listOfFiles){
//        if(file.isDirectory()){
//            listOfFiles = file.listFiles();
//            for (int i = 0; i < listOfFiles.length; i++) {
//                if (listOfFiles[i].isFile()){
//                    System.out.println("File: " + listOfFiles[i].getName());
//                }
//
//            }
//        }
//    }


    // Exercise: If a file is a directory: Call all files recursively,
    // else print full path to the file. Count both dirs and atomic files.
    private void findFiles(File file) {
        if (file.isDirectory()){
            File[] listOfFiles = file.listFiles();
            noDirs ++;
//            System.out.println("the path of: "+ file + " is: " + file.getAbsolutePath());
            for (int i = 0; i < listOfFiles.length; i++) {
                findFiles(listOfFiles[i]);
                if (listOfFiles[i] != null){

                }

            }
        }
        else if(file.isFile()){
            noFiles++;
//            System.out.println("path to file: " + file + " is: "+ file.getAbsolutePath());
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public String toString() {
        return "FindFilesRecursive{" + "noDirs=" + noDirs + ", noFiles=" + noFiles + '}';
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();
        File startDir = new File(directory);

        FindFilesRecursive ffr = new FindFilesRecursive();
        ffr.findFiles(startDir);
        System.out.println("\n*************\n" + ffr);
    }


}
