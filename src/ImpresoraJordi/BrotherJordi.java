package ImpresoraJordi;

import cisa_impresores.CisaExceptions;
import static ImpresoraJordi.TintaJordi.*;
import cisa_impresores.SendEmail;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

/**
 *
 * @author linusdufol
 */
public class BrotherJordi {

    public void BrotherJordi() throws FileNotFoundException, IOException, CisaExceptions {
        String source1 = "http://192.168.28.233/etc/view_config.html"; //Brother HL-L2340D
        URL url1 = new URL(source1);
        String targetDirectory1 = "/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files";
        String fileName = source1.substring(source1.lastIndexOf('/') + 1, source1.length()); /**************/
        Path targetPath = new File(targetDirectory1 + File.separator + fileName).toPath();  /*status.html*/
        Files.copy(url1.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        List<String> lines3 = new ArrayList<>(); //Array Brother Jordi
        List<Character> percCian = new ArrayList<>();
        List<Character> percMagenta = new ArrayList<>();
        List<Character> percGroc = new ArrayList<>();
        List<Character> percNegre = new ArrayList<>();
        try{
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files/file.html"); //Declarem l'arxiu on ho posarem tot
        Scanner info = new Scanner(new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files/view_config.html")); //Llegim l'arxiu status.html
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        while (info.hasNext()) {
            lines3.add(info.nextLine()); //A l'array 'lines' afegim una linia a cada posicio de status.html
        }

        for (int i = 6; percCian.size() <= 9;) {
            percCian.add(lines3.get(141).charAt(i));
            percMagenta.add(lines3.get(155).charAt(i));
            percGroc.add(lines3.get(169).charAt(i));
            percNegre.add(lines3.get(183).charAt(i));
            i += 8;
        }
        int per = 0, per2 = 0, per3 = 0, per4 = 0;
        for (int i = 0; i < percCian.size(); i++) {
            if (percCian.get(i) == '0') {
                per = per + 1 * 10;
            }
            if (percMagenta.get(i) == '0') {
                per2 = per2 + 1 * 10;
            }
            if (percGroc.get(i) == '0') {
                per3 =per3 + 1 * 10;
            }
            if (percNegre.get(i) == '0') {
                per4 =per4 + 1 * 10;
            }
        }
      
        ArrayList<Integer> percCol = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        SendEmail sendmail = new SendEmail();
        colors.add("negre");
        colors.add("cian");
        colors.add("magenta");
        colors.add("groc");
        percCol.add(per);
        percCol.add(per2);
        percCol.add(per3);
        percCol.add(per4);
        for (int i = 0; i < percCol.size(); i++) {
            if (percCol.get(i) <= 7) {
                System.out.println("La impresora s'ha quedat sense color " + colors.get(i) + ", " + "percentatge = " + percCol.get(i) + "%, " + "enviant mail ...");
                String subject = "La impresora: Brother Jordi s'ha quedat sense tinta";
                String messages = "Falta el color: " + colors.get(i);
                EnviarMail(sendmail, subject, messages);
            } else {
                System.out.println("Color " + colors.get(i) + " ... OK");
            }
        }

        String cian = lines3.get(144);
        String magenta = lines3.get(158);
        String yellow = lines3.get(172);
        String black = lines3.get(186);
        broCian(percCol.get(0));
        broMagenta(percCol.get(1));
        broYellow(percCol.get(2));
        broBlack(percCol.get(3));
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
}
