package report.example.report;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;

import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.settings.HorizontalAlignment;
import org.vandeseer.easytable.settings.VerticalAlignment;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.Table.TableBuilder;
import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;

public class ReportPdf {

    /*
        example taken from:
        http://www.ibdd.org.br/relatorios.asp
    */
    private static final Color LIGHT_BLUE_3 = new Color(231, 241, 243);


    public void generate() {
        System.out.println("Report generating");
        PDDocument doc = new PDDocument();
        try {
            createReport(doc);

            doc.save("teste.pdf");
            doc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void createReport(PDDocument doc) throws Exception {
        PDPage page = new PDPage(PDRectangle.A4);
        doc.addPage(page);

        PDPageContentStream content = new PDPageContentStream(doc, page);

        TableDrawer tableTitle = TableDrawer.builder()
            .table(createBoxTitle("RELATÓRIO ANUAL 2019"))
            .startX(20)
            .startY(800)
            .endY(40f)
            .build();
        tableTitle.draw(() -> doc, () -> new PDPage(), 72f);

        content.close();
    }

    private Table createBoxTitle(String title) {
		final TableBuilder tableBuilder = Table.builder().addColumnsOfWidth(600).fontSize(8)
			.textColor(Color.BLACK).font(PDType1Font.HELVETICA).backgroundColor(LIGHT_BLUE_3)
			.verticalAlignment(VerticalAlignment.MIDDLE);

		tableBuilder.addRow(Row.builder()
			.add(TextCell.builder().text(title).build())
				.textColor(Color.BLACK).font(PDType1Font.HELVETICA_BOLD).fontSize(23)
				.horizontalAlignment(HorizontalAlignment.LEFT).build());

		return tableBuilder.build();
	}
}
