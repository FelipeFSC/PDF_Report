package report.example.report;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;

import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.settings.BorderStyleInterface;
import org.vandeseer.easytable.settings.HorizontalAlignment;
import org.vandeseer.easytable.settings.VerticalAlignment;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.Table.TableBuilder;
import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;
import java.io.IOException;

public class ReportPdf {

    /*
        example taken from:
        http://www.ibdd.org.br/relatorios.asp
    */
    private static final Color LIGHT_BLACK_1 = new Color(59, 55, 61);

    private static final Color TESTER = new Color(232, 183, 215);



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

        PDImageXObject pdImage = PDImageXObject.createFromFile("inputPhoto.png", doc);
        content.drawImage(pdImage, 0f, 661.10f, 200, 180);

        content.setNonStrokingColor(LIGHT_BLACK_1);
		content.addRect(0, 0, 200, 660.5f);
		content.fill();

        TableDrawer tableTitle = TableDrawer.builder()
            .table(createBoxTitle(""))
            .startX(15)
            .startY(650f)
            .build();
        tableTitle.draw(() -> doc, () -> new PDPage(), 72f);

        TableDrawer tableTitle_2 = TableDrawer.builder()
            .table(profileBox(content, "Contato", 505)) // -25 do Y geral
            .startX(15)
            .startY(530f)
            .build();
        tableTitle_2.draw(() -> doc, () -> new PDPage(), 72f);

        TableDrawer contactData = TableDrawer.builder()
            .table(contactBox(content, ""))
            .startX(15)
            .startY(490f)
            .build();
        contactData.draw(() -> doc, () -> new PDPage(), 72f);


        TableDrawer tableTitle_3 = TableDrawer.builder()
            .table(profileBox(content, "Idiomas", 295))
            .startX(15)
            .startY(320f)
            .build();
        tableTitle_3.draw(() -> doc, () -> new PDPage(), 72f);


        /*TableDrawer tableTitle1 = TableDrawer.builder()
            .table(createBoxTitle("RELATÓRIO ANUAL 2022"))
            .startX(20)
            .startY(800)
            .endY(40f)
            .build();
        tableTitle1.draw(() -> doc, () -> new PDPage(), 72f);*/

        content.close();
    }

    private Table createBoxTitle(String title) {
		final TableBuilder tableBuilder = Table.builder().addColumnsOfWidth(170).fontSize(8)
			.textColor(Color.BLACK).font(PDType1Font.HELVETICA).backgroundColor(LIGHT_BLACK_1)
            .verticalAlignment(VerticalAlignment.MIDDLE);

		tableBuilder.addRow(Row.builder()
			.add(TextCell.builder().text("Whinderson").build())
				.textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(25).borderColor(Color.BLUE)
				.horizontalAlignment(HorizontalAlignment.LEFT).build());
        tableBuilder.addRow(Row.builder()
			.add(TextCell.builder().text("Nunes").build())
				.textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(25).borderColor(Color.BLUE)
				.horizontalAlignment(HorizontalAlignment.LEFT).build());
        tableBuilder.addRow(Row.builder()
            .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
            .add(TextCell.builder().text("Desenvolvedor FULL TALO").build())
                .textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(12)
                .horizontalAlignment(HorizontalAlignment.CENTER).build());

		return tableBuilder.build();
	}

    private Table profileBox(PDPageContentStream content, String title, float y) throws IOException {
		final TableBuilder tableBuilder = Table.builder().addColumnsOfWidth(170).fontSize(8)
			.textColor(Color.BLACK).font(PDType1Font.HELVETICA).backgroundColor(LIGHT_BLACK_1)
            .verticalAlignment(VerticalAlignment.MIDDLE);

		tableBuilder.addRow(Row.builder()
			.add(TextCell.builder().text(title).build())
				.textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(20)
				.horizontalAlignment(HorizontalAlignment.LEFT).build());

        content.setNonStrokingColor(Color.WHITE);
        content.addRect(15, y, 170, 1);
        content.fill();

		return tableBuilder.build();
	}

    private Table contactBox(PDPageContentStream content, String data) {
        final TableBuilder tableBuilder = Table.builder().addColumnsOfWidth(170).fontSize(8)
			.textColor(Color.BLACK).font(PDType1Font.HELVETICA).backgroundColor(LIGHT_BLACK_1)
            .verticalAlignment(VerticalAlignment.MIDDLE);

        float padding = 8;

        tableBuilder.addRow(Row.builder()
            .add(TextCell.builder().text("felipefenix2000@gmail.com").build())
                .textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(10)
                .horizontalAlignment(HorizontalAlignment.LEFT).padding(padding).build());

        tableBuilder.addRow(Row.builder()
            .add(TextCell.builder().text("+55 11 93264-1186").build())
                .textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(10)
                .horizontalAlignment(HorizontalAlignment.LEFT).padding(padding).build());

        tableBuilder.addRow(Row.builder()
            .add(TextCell.builder().text("(55)11 5921-2926").build())
                .textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(10)
                .horizontalAlignment(HorizontalAlignment.LEFT).padding(padding).build());

        tableBuilder.addRow(Row.builder()
            .add(TextCell.builder().text("São Paulo (SP), Zona Sul - Interlagos").build())
                .textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(10)
                .horizontalAlignment(HorizontalAlignment.LEFT).padding(padding).build());

        return tableBuilder.build();
    }
}
