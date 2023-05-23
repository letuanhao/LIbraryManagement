/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ket_noi_db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh0
 */
public class ReadFileTxt {
   public void readfile(){
        File directory = new File("");
        String fileName = directory.getAbsolutePath();
        //System.out.println(fileName);
        File file = new File(fileName+"/src/database_infor.txt");
        
        File directory1 = new File("");
        String fileName1 = directory1.getAbsolutePath();
        //System.out.println(fileName1);
        File file1 = new File(fileName1+"/dist/database_infor.txt");
        FileInputStream fileInputStream;
        try {
            if(file.canRead()){
                fileInputStream = new FileInputStream(file);
                System.out.println("1");
            }
            else{
                fileInputStream = new FileInputStream(file1);
                System.out.println("2");
            }
            Scanner scanner = new Scanner(fileInputStream);
            
            scanner.hasNextLine();
            scanner.nextLine();
            scanner.hasNextLine();
            DB_infor.setTaikhoan(scanner.nextLine().trim());
            scanner.hasNextLine();
            DB_infor.setMatkhau(scanner.nextLine().trim());
            scanner.close();
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadFileTxt.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFileTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        File directory1 = new File("");
        String fileName1 = directory1.getAbsolutePath();
        System.out.println(fileName1);
        File file1 = new File(fileName1+"/database_infor.txt");
        
        boolean l = file1.canRead();
        System.out.println(l);
        
    }
}
