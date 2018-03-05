package cisa_impresores;

import HPComu.HPComu;
import ImpresoraLauraCristina.BrotherLC;
import ImpresoraJordi.BrotherJordi;
import java.awt.Desktop;
import java.io.*;

/**
 *
 * @author linusdufol
 */
public class CISA_Impresores {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files/file.html"); //Declarem l'arxiu on ho posarem tot
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        System.out.println("Processant dades ...");

        //Si l'arxiu file.html no existeix el creem i donem tots els permisos
        if (!file.exists()) {
            bw = new BufferedWriter(new FileWriter(file));
            file.setExecutable(true);
            file.setReadable(true);
            file.setWritable(true);
        } else {
            file.delete();
        }

        HPComu hpcomu = new HPComu();
        BrotherJordi brotherjordi = new BrotherJordi();
        BrotherLC brotherlc = new BrotherLC();

        System.out.println("IMPRESORA BROTHER LAURA & CRISTINA: ");
        BrotherLC(brotherlc);
        
        System.out.println("IMPRESORA HP COMUNA: ");
        HpComu(hpcomu);
        
        System.out.println("IMPRESORA BROTHER JORDI: ");
        BrotherJordi(brotherjordi);

        Desktop.getDesktop().open(file);
        System.out.println("FUNCIONA");
    }

    private static void BrotherLC(BrotherLC brotherlc) throws IOException {
        try {
            brotherlc.BrotherLC();
        } catch (CisaExceptions ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void BrotherJordi(BrotherJordi brotherjordi) throws IOException {
        try {
            brotherjordi.BrotherJordi();
        } catch (CisaExceptions ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void HpComu(HPComu hPcomu) throws IOException {
        try {
            hPcomu.HPComu();
        } catch (CisaExceptions ex) {
            System.out.println(ex.getMessage());
        }
    }

}
