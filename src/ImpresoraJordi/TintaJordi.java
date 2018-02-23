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
    public static void broCian(String cian) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String html
                = "<style>"
                + "#html4 {"
                + "  background-color: #00FFF7;"
                + "  width: 90px;"
                + "  height: 30px;"
                + "}"
                + "</style>"
                + "<h1>Impresora Brother JORDI</h1>"
                + "<h4>Color cian</h4>"
                + "<div id=html4>" + cian + "</div>";
        bw.write(html);
        bw.close();
    }
    public static void broBlack(String black) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String html
                = "<style>"
                + "#html3 {"
                + "  background-color: #5B5B57;"
                + "  width: 90px;"
                + "  height: 30px;"
                + "}"
                + "</style>"
                + "<h4>Color negre</h4>"
                + "<div id=html3>" + black + "</div>";
        bw.write(html);
        bw.close();
    }
    public static void broYellow(String yellow) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String html
                = "<style>"
                + "#html1 {"
                + "  background-color: #FFFF00;"
                + "  width: 90px;"
                + "  height: 30px;"
                + "}"
                + "</style>"
                + "<h4>Color groc</h4>"
                + "<div id=html1>" + yellow + "</div>";
        bw.write(html);
        bw.close();
    }
    public static void broMagenta(String magenta) throws IOException {
        File file = new File("/Users/linusdufol/Documents/workspace/CISA_Impresores/src/cisa_impresores/file.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); //Declarem BW per file.html
        String html
                = "<style>"
                + "#html2 {"
                + "  background-color: #E80CA9;"
                + "  width: 90px;"
                + "  height: 30px;"
                + "}"
                + "</style>"
                + "<h4>Color magenta</h4>"
                + "<div id=html2>" + magenta + "</div>";
        bw.write(html);
        bw.close();
    }
}
