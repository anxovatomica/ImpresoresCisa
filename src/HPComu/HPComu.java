package HPComu;

import cisa_impresores.*;
import static HPComu.TintaComu.*;

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
public class HPComu {
    public void HPComu() throws MalformedURLException, IOException, CisaExceptions {
        List<String> lines2 = new ArrayList<>(); //Array HP LaserJet 500 colorMFP M570dn&nbsp;&nbsp;&nbsp;192.168.28.8
    String source2 = "https://192.168.28.8/"; //HP LaserJet 500
        URL url2 = new URL(source2);

        String targetDirectory2 = "/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/index.html";
        
        DisableSSLVerification disableSsl = new DisableSSLVerification();
        DisableSsl(disableSsl); //Desavilito la verificacio ssl

        String fileName2 = source2.substring(source2.lastIndexOf('/') + 1, source2.length()); /******************/
        Path targetPath2 = new File(targetDirectory2 + File.separator + fileName2).toPath(); /*****index.html***/
        Files.copy(url2.openStream(), targetPath2, StandardCopyOption.REPLACE_EXISTING);    /******************/

        Scanner HPComun = new Scanner(new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/index.html"));// Llegim l'arxiu index.html

        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html"); //Declarem l'arxiu on ho posarem tot
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html

        while (HPComun.hasNext()) {
            lines2.add(HPComun.nextLine()); //A l'array 'lines' afegim una linia a cada posicio de index.html
        }
        int black = Integer.parseInt(lines2.get(293).replace(" ", "").substring(0, 2));//Percentatge color negre
        tintaBlack(black);
        int cian = Integer.parseInt(lines2.get(335).replace(" ", "").substring(0, 2));//Percentatge color negre
        tintaCian(cian);
        int magenta = Integer.parseInt(lines2.get(378).replace(" ", "").substring(0, 2));//Percentatge color negre
        tintaMagenta(magenta);
        int groc = Integer.parseInt(lines2.get(421).replace(" ", "").substring(0, 2));//Percentatge color negre
        tintaGroga(groc);
        
        ArrayList<Integer> percCol = new ArrayList<> ();
        ArrayList<String> colors = new ArrayList<> ();
        colors.add("Negre");
        colors.add("Cian");
        colors.add("Magenta");
        colors.add("Groc");
        percCol.add(black);
        percCol.add(cian);
        percCol.add(magenta);
        percCol.add(groc);
        SendEmail sendmail = new SendEmail();
        for (int i = 0; i <= percCol.size(); i++) {
            if (percCol.get(i) <= 60) {
                String subject = "La impresora: HP Comuna s'ha quedat sense tinta";
                String messages = "Falta el color: " + colors.get(i);
                EnviarMail(sendmail, subject, messages);
            }
        }
    }
    private static void EnviarMail(SendEmail sendmail, String subject, String messages){
        try{
            sendmail.Email(subject, messages);
            System.out.println("Email enviat!");
        } catch (CisaExceptions ex) {
            System.out.println(ex.getMessage());
        }
    }
    
private static void DisableSsl(DisableSSLVerification disableSsl){
        try{
            disableSsl.disableSslVerification();
            System.out.println("SSL Disabled");
        } catch (CisaExceptions ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
