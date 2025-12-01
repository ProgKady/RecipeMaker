
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Mmmain {
    public static void main(String[] args) {
        // Sample HTML table
        String html = "<table><tr id='row1'><td>Row 1</td></tr><tr id='row2'><td>Row 2</td></tr></table>";
        
       Document docyy = Jsoup.parse(html);
    Elements rowsyy = docyy.select("table tr");
    int lastIndexyy = rowsyy.size() - 1;
    Element specificRowyy = docyy.select("tr").get(lastIndexyy);
    Element newRowyy = new Element("tr");
    newRowyy.append("<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 215.891px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 240.234px; border-style: dotted;\">&nbsp;</td>");
   specificRowyy.after(newRowyy);

        // Output the modified HTML
        System.out.println(docyy.toString());
    }
}
