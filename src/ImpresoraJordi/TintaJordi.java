package ImpresoraJordi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author linusdufol
 */
public class TintaJordi {
    public static void broCian(int per) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files/file.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String html = "<style>\n"
                + "#barra6 {\n"
                + "  width: 100%;\n"
                + "  background-color: #ddd;\n"
                + "}\n"
                + "\n"
                + "#progres6 {\n"
                + "  width: " + per + "%;\n"
                + "  height: 30px;\n"
                + "  background-color: #00FFF7;\n"
                + "}\n"
                + "</style>\n"
                + "<body>\n"
                + "\n"
                + "<h1>Impresora Brother HL-3040CN (JORDI)</h1>\n"
                + "<h4>Color cian</h4>\n"
                + "\n"
                + "<div id=\"barra6\">"
                + "  <div id=\"progres6\">" + per +  "%" + "</div>"
                + "</div>";
        bw.write(html);
        bw.close();
    }
    public static void broBlack(int per) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files/file.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
         String html = 
                 "<style>\n"
                + "#barra7 {\n"
                + "  width: 100%;\n"
                + "  background-color: #ddd;\n"
                + "}\n"
                + "\n"
                + "#progres7 {\n"
                + "  width: " + per + "%;\n"
                + "  height: 30px;\n"
                + "  background-color: #000000;\n"
                + "  color: #FFFFFF;\n"
                + "}\n"
                + "</style>\n"
                + "<body>\n"
                + "<h4>Color negre</h4>\n"
                + "\n"
                + "<div id=\"barra7\">"
                + "  <div id=\"progres7\">" + per +  "%" + "</div>"
                + "</div>";
        bw.write(html);
        bw.close();
    }
    public static void broYellow(int per) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files/file.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
         String html =  "<style>\n"
                + "#barra8 {\n"
                + "  width: 100%;\n"
                + "  background-color: #ddd;\n"
                + "}\n"
                + "\n"
                + "#progres8 {\n"
                + "  width: " + per + "%;\n"
                + "  height: 30px;\n"
                + "  background-color: #FFFF00;\n"
                + "}\n"
                + "</style>\n"
                + "<body>\n"
                + "<h4>Color groc</h4>\n"
                + "\n"
                + "<div id=\"barra8\">"
                + "  <div id=\"progres8\">" + per +  "%" + "</div>"
                + "</div>";
         bw.write(html);
        bw.close();
    }
    public static void broMagenta(int per) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/Files/file.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String html = "<style>\n"
                + "#barra9 {\n"
                + "  width: 100%;\n"
                + "  background-color: #ddd;\n"
                + "}\n"
                + "\n"
                + "#progres9 {\n"
                + "  width: " + per + "%;\n"
                + "  height: 30px;\n"
                + "  background-color: #E80CA9;\n"
                + "}\n"
                + "</style>\n"
                + "<body>\n"
                + "<h4>Color magenta</h4>\n"
                + "\n"
                + "<div id=\"barra9\">"
                + "  <div id=\"progres9\">" + per +  "%" + "</div>"
                + "</div>";
        bw.write(html);
        bw.close();
    }
}
