package ImpresoraLauraCristina;

import cisa_impresores.CisaExceptions;
import cisa_impresores.SendEmail;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author linusdufol
 */
public class BrotherLC {
    public static void BrotherLC() throws MalformedURLException, IOException, CisaExceptions {
        
        String source1 = "http://192.168.28.234/general/status.html"; //Brother HL-L2340D
        URL url1 = new URL(source1);
        try{
            
        String targetDirectory1 = "/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files";
        String fileName = source1.substring(source1.lastIndexOf('/') + 1, source1.length()); /**************/
        Path targetPath = new File(targetDirectory1 + File.separator + fileName).toPath();  /*status.html*/
        Files.copy(url1.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);    /**************/
        
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files/file.html"); //Declarem l'arxiu on ho posarem tot
        Scanner Brother = new Scanner(new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files/status.html")); //Llegim l'arxiu status.html
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        
        List<String> lines = new ArrayList<>(); //Array Brother HL-L2340D series
        while (Brother.hasNext()) {
            lines.add(Brother.nextLine()); //A l'array 'lines' afegim una linia a cada posicio de status.html
        }
        
        char int1 = lines.get(8).charAt(218); //Agafem la 1a unitat del height de la barra de percentatge de tinta
        char int2 = lines.get(8).charAt(219); //Agafem la 2a unitat del height de la barra de percentatge de tinta
        double total = ((int1 + int2) * 100) / 170; //Els sumem
        //Double percentatge = (total * 100) / 170; //Fem el percentatge sobre el total
        percentatgeBrother(total);
        SendEmail sendmail = new SendEmail();
        if(total <= 7){
             System.out.println("La impresora s'ha quedat sense tinta, enviant mail ...");
             String subject = "La impresora: Brother Laura & Cristina s'ha quedat sense tinta";
             String messages = "Falta el color: Negre (unic color)";
             EnviarMail(sendmail, subject, messages);
        }else{
            System.out.println("Color negre ... OK");
        }
        }catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void EnviarMail(SendEmail sendmail, String subject, String messages) {
        try {
            sendmail.Email(subject, messages);
        } catch (CisaExceptions ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void percentatgeBrother(Double percentatge) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files/file.html"); //Declarem l'arxiu on ho posarem tot
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
}
