/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImpresoraLauraCristina;


import cisa_impresores.CisaExceptions;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author linusdufol
 */
public class BrotherLC {
    public static void BrotherLC() throws MalformedURLException, IOException, CisaExceptions {
        List<String> lines = new ArrayList<>(); //Array Brother HL-L2340D series
        String source1 = "http://192.168.28.234/general/status.html"; //Brother HL-L2340D
        URL url1 = new URL(source1);
        String targetDirectory1 = "/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores";
        String fileName = source1.substring(source1.lastIndexOf('/') + 1, source1.length());
        /**
         * **********
         */
        Path targetPath = new File(targetDirectory1 + File.separator + fileName).toPath();
        /*status.html*/
        Files.copy(url1.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        /**
         * **********
         */
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html"); //Declarem l'arxiu on ho posarem tot
        Scanner Brother = new Scanner(new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/status.html")); //Llegim l'arxiu status.html
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        while (Brother.hasNext()) {
            lines.add(Brother.nextLine()); //A l'array 'lines' afegim una linia a cada posicio de status.html
        }
        char int1 = lines.get(8).charAt(218); //Agafem la 1a unitat del height de la barra de percentatge de tinta
        char int2 = lines.get(8).charAt(219); //Agafem la 2a unitat del height de la barra de percentatge de tinta
        double total = int1 + int2; //Els sumem
        Double percentatge = (total * 100) / 170; //Fem el percentatge sobre el total
        percentatgeBrother(percentatge);
        if(percentatge < 80){
            System.out.println("Tinta Baixa");
            tonerRunOut(percentatge);
        }

    }
    public static void percentatgeBrother(Double percentatge) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html"); //Declarem l'arxiu on ho posarem tot
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        
        String q = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<style>\n"
                + "#barra1 {\n"
                + "  width: 100%;\n"
                + "  background-color: #ddd;\n"
                + "}\n"
                + "\n"
                + "#progres1 {\n"
                + "  width: " + percentatge + "%;\n"
                + "  height: 30px;\n"
                + "  background-color: #4CAF50;\n"
                + "}\n"
                + "</style>\n"
                + "<body>\n"
                + "\n"
                + "<h1>Impresora Brother HL-L2340D (Laura i Cristina)</h1>\n"
                + "\n"
                + "<div id=\"barra1\">"
                + "  <div id=\"progres1\">" + percentatge +  "%" + "</div>"
                + "</div>";
        
        bw.write(q);
        bw.close();
    }
    public static void tonerRunOut(Double percentatge) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html"); //Declarem l'arxiu on ho posarem tot
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String p = "<script>\n"
                + "$(document).ready(parpadear);\n"
                + "function parpadear(){ $('#barra1').fadeIn(500).delay(250).fadeOut(500, parpadear).css(\"background-color\", \"blue\") }\n"
                + "</script>";

        bw.write(p);
        bw.close();
    }
}
