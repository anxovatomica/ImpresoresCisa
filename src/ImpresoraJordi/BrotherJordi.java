/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImpresoraJordi;

import cisa_impresores.CisaExceptions;
import static ImpresoraJordi.TintaJordi.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author linusdufol
 */
public class BrotherJordi {
    public void BrotherJordi() throws FileNotFoundException, IOException, CisaExceptions {
        List<String> lines3 = new ArrayList<>(); //Array Brother Jordi
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html"); //Declarem l'arxiu on ho posarem tot
        Scanner info = new Scanner(new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/info.html")); //Llegim l'arxiu status.html
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        while (info.hasNext()) {
            lines3.add(info.nextLine()); //A l'array 'lines' afegim una linia a cada posicio de status.html
        }
        String cian = lines3.get(144);
        String magenta = lines3.get(158);
        String yellow = lines3.get(172);
        String black = lines3.get(186);
        broCian(cian);
        broMagenta(magenta);
        broYellow(yellow);
        broBlack(black);
    }
}
