import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.VerticalAlignment;

import java.io.FileNotFoundException;

public class TwoTablesWithVs {
    public static void main(String[] args) {
        // Output file path
        String dest = "two_tables_with_vs.pdf";

        try {
            // Initialize PDF writer and document
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdfDoc = new PdfDocument(writer);
            
            // Set the page size to A4 landscape
            pdfDoc.setDefaultPageSize(PageSize.A4.rotate());

            Document document = new Document(pdfDoc);

            // Create the first table with two columns
            Table table1 = new Table(2);
            table1.addCell(new Cell().add(new Paragraph("Player 1")));
            table1.addCell(new Cell().add(new Paragraph("Score 1")));
            table1.addCell(new Cell().add(new Paragraph("Player 2")));
            table1.addCell(new Cell().add(new Paragraph("Score 2")));

            // Create the "VS" cell
            Paragraph vsParagraph = new Paragraph("VS").setFontSize(14).setBold()
                    .setFontColor(ColorConstants.RED);
            Cell vsCell = new Cell().add(vsParagraph);
            vsCell.setPadding(10);
            vsCell.setVerticalAlignment(VerticalAlignment.MIDDLE);

            // Create the second table with two columns
            Table table2 = new Table(2);
            table2.addCell(new Cell().add(new Paragraph("Player 3")));
            table2.addCell(new Cell().add(new Paragraph("Score 3")));
            table2.addCell(new Cell().add(new Paragraph("Player 4")));
            table2.addCell(new Cell().add(new Paragraph("Score 4")));

            // Add the tables and VS cell in a horizontal layout
            Table layoutTable = new Table(3); // 3 columns: table1, VS, table2
            layoutTable.addCell(new Cell().add(table1));
            layoutTable.addCell(vsCell);
            layoutTable.addCell(new Cell().add(table2));

            // Add the combined layout table to the document
            document.add(layoutTable);

            // Close the document
            document.close();
            System.out.println("PDF created successfully!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
