package HPComu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author linusdufol
 */
public class TintaComu {
    public static void tintaCian(int cian) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html"); //Declarem l'arxiu on ho posarem tot
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String o = "<style>\n"
                + "#barra3 {\n"
                + "  width: 100%;\n"
                + "  background-color: #ddd;\n"
                + "}\n"
                + "\n"
                + "#progres3 {\n"
                + "  width: " + cian + "%;\n"
                + "  height: 30px;\n"
                + "  background-color: #00FFF7;\n"
                + "  color: #000000;\n"
                + "}\n"
                + "</style>\n"
                + "<body>\n"
                + "<h4>Color cian</h4>\n"
                + "<div id=\"barra3\">\n"
                + "  <div id=\"progres3\">" + cian + "%" + "</div>\n"
                + "</div>";
        bw.write(o);
        bw.close();
    }
    public static void tintaBlack(int black) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html"); //Declarem l'arxiu on ho posarem tot
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String o = "<style>\n"
                + "#barra2 {\n"
                + "  width: 100%;\n"
                + "  background-color: #ddd;\n"
                + "}\n"
                + "\n"
                + "#progres2 {\n"
                + "  width: " + black + "%;\n"
                + "  height: 30px;\n"
                + "  background-color: #000000;\n"
                + "  color: #FFFFFF;\n"
                + "}\n"
                + "</style>\n"
                + "<body>\n"
                + "\n"
                + "<h1>Impresora COMUNA HP LaserJet 500</h1>\n"
                + "\n"
                + "<h4>Color negre</h4>\n"
                + "<div id=\"barra2\">\n"
                + "  <div id=\"progres2\">" + black + "%" + "</div>\n"
                + "</div>";
        bw.write(o);
        bw.close();
    }
    public static void tintaGroga(int groc) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html"); //Declarem l'arxiu on ho posarem tot
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String o = "<style>\n"
                + "#barra5 {\n"
                + "  width: 100%;\n"
                + "  background-color: #ddd;\n"
                + "}\n"
                + "\n"
                + "#progres5 {\n"
                + "  width: " + groc + "%;\n"
                + "  height: 30px;\n"
                + "  background-color: #FFFF00;\n"
                + "  color: #000000;\n"
                + "}\n"
                + "</style>\n"
                + "<body>\n"
                + "<h4>Color groc</h4>\n"
                + "<div id=\"barra5\">\n"
                + "  <div id=\"progres5\">" + groc + "%" + "</div>\n"
                + "</div>";
        bw.write(o);
        bw.close();
    }
    public static void tintaMagenta(int magenta) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html"); //Declarem l'arxiu on ho posarem tot
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String o = "<style>\n"
                + "#barra4 {\n"
                + "  width: 100%;\n"
                + "  background-color: #ddd;\n"
                + "}\n"
                + "\n"
                + "#progres4 {\n"
                + "  width: " + magenta + "%;\n"
                + "  height: 30px;\n"
                + "  background-color: #E80CA9;\n"
                + "  color: #000000;\n"
                + "}\n"
                + "</style>\n"
                + "<body>\n"
                + "<h4>Color magenta</h4>\n"
                + "<div id=\"barra4\">\n"
                + "  <div id=\"progres4\">" + magenta + "%" + "</div>\n"
                + "</div>";
        bw.write(o);
        bw.close();
    }
}
