import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PCSNextCellFinder {
    public static void main(String[] args) {
        String html = "<table>" +
                "<tr><td>Item</td><td>Qty</td><td>S</td><td>100</td></tr>" +
                "</table>";

        Document doc = Jsoup.parse(html);
        Elements rows = doc.select("tr");

        boolean pcsFound = false;

        for (Element row : rows) {
            Elements cells = row.select("td");
            for (int i = 0; i < cells.size(); i++) {
                if ("PCS".equalsIgnoreCase(cells.get(i).text().trim())) {
                    if (i + 1 < cells.size()) {
                        String nextValue = cells.get(i + 1).text().trim();
                        System.out.println("Next value after PCS: " + nextValue);
                    } else {
                        System.out.println("PCS found but no next cell.");
                    }
                    pcsFound = true;
                    break; // stop after first match
                }
            }
            if (pcsFound) break;
        }

        if (!pcsFound) {
            System.out.println("PCS not found");
        }
    }
}
