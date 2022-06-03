package report.example.report;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.settings.HorizontalAlignment;
import org.vandeseer.easytable.settings.VerticalAlignment;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.Table.TableBuilder;
import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;

public class ReportPdf {

    private static final Color LIGHT_BLACK_1 = new Color(59, 55, 61);

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

        content.setNonStrokingColor(LIGHT_BLACK_1);
        content.addRect(0, 0, 200, 850f);
        content.fill();

        TableDrawer contactData = TableDrawer.builder()
                .table(contactBox(content, ""))
                .startX(15)
                .startY(800f)
                .build();
        contactData.draw(() -> doc, () -> new PDPage(), 72f);

        TableDrawer tableGeral = TableDrawer.builder()
                .table(createBoxTitle(""))
                .startX(215)
                .startY(800)
                .build();
        tableGeral.draw(() -> doc, () -> new PDPage(), 72f);

        content.close();
    }

    private Table createBoxTitle(String title) {
        final TableBuilder tableBuilder = Table.builder().addColumnsOfWidth(365).fontSize(8)
                .textColor(Color.BLACK).font(PDType1Font.HELVETICA)// .backgroundColor(LIGHT_BLACK_1)
                .verticalAlignment(VerticalAlignment.MIDDLE);

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Jubiscleison Nunes").build())
                .font(PDType1Font.HELVETICA_BOLD).fontSize(25).borderColor(Color.BLUE)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Desenvolvedor FULL TALO").build())
                .textColor(Color.BLACK).fontSize(10)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Resumo").build())
                .fontSize(16).borderColor(Color.BLUE)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text(
                        "Conhecimentos básicos em HTML, CSS e JavaScript. Cursando Análise e Desenvolvimento de Sistemas no Centro Universitário Senac - 4º Semestre.")
                        .build())
                .fontSize(11).borderColor(Color.BLUE)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").paddingBottom(10).borderWidthBottom(1).borderColor(Color.BLACK)
                        .build())
                .fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Experiência").build())
                .fontSize(16).borderColor(Color.BLUE)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        for (int i = 0; i < 2; i++) {
            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("Control Union Brasil").build())
                    .textColor(Color.BLACK).fontSize(12)
                    .horizontalAlignment(HorizontalAlignment.LEFT).build());

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("Desenvolvedor de software").build())
                    .textColor(Color.BLACK).fontSize(9)
                    .horizontalAlignment(HorizontalAlignment.LEFT).build());

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("janeiro de 2021 - Present (1 ano 5 meses)").build())
                    .textColor(Color.BLACK).fontSize(9)
                    .horizontalAlignment(HorizontalAlignment.LEFT).build());

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("São Paulo, São Paulo, Brasil").build())
                    .textColor(Color.BLACK).fontSize(8)
                    .horizontalAlignment(HorizontalAlignment.LEFT).build());

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("").build()).fontSize(3).build());
        }

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").paddingBottom(10).borderWidthBottom(1).borderColor(Color.BLACK)
                        .build())
                .fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Formação acadêmica").build())
                .fontSize(16).borderColor(Color.BLUE)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        for (int i = 0; i < 2; i++) {
            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("Centro Universitário Senac").build())
                    .textColor(Color.BLACK).fontSize(12)
                    .horizontalAlignment(HorizontalAlignment.LEFT).build());

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("Graduação , Analise e Desenvolvimento de Sistemas · (2019 - 2021)")
                            .build())
                    .textColor(Color.BLACK).fontSize(9)
                    .horizontalAlignment(HorizontalAlignment.LEFT).build());

            tableBuilder.addRow(Row.builder()
                    .add(TextCell.builder().text("").build()).fontSize(3).build());
        }

        return tableBuilder.build();
    }

    private Table contactBox(PDPageContentStream content, String data) {
        final TableBuilder tableBuilder = Table.builder().addColumnsOfWidth(170).fontSize(8)
                .textColor(Color.BLACK).font(PDType1Font.HELVETICA)// .backgroundColor(TESTER)
                .verticalAlignment(VerticalAlignment.MIDDLE);

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Contato").paddingBottom(10).borderWidthBottom(1).borderColor(Color.WHITE)
                        .build())
                .textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(13).font(PDType1Font.HELVETICA)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("+55 11 99999-9999").build())
                .textColor(Color.WHITE).fontSize(9)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("https://www.linkedin.com/in/felipe-ferreira-768b27182/?jobid=1234")
                        .build())
                .textColor(Color.WHITE).fontSize(9).wordBreak(true)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("felipefsc.04@gmailc.com").build())
                .textColor(Color.WHITE).fontSize(9).wordBreak(true)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("São Paulo (SP), Zona, Minha casa aaaaaaaaaaaaaaa").build())
                .textColor(Color.WHITE).fontSize(9)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Principais competências").paddingBottom(10).borderWidthBottom(1)
                        .borderColor(Color.WHITE).build())
                .textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(13).font(PDType1Font.HELVETICA)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        for (int i = 0; i < 5; i++) {
            if (i < 4) {
                tableBuilder.addRow(Row.builder()
                        .add(TextCell.builder().text("- sou fodaaaaa!! seloko, muito foda quebra a linha porraaaaaa")
                                .build())
                        .textColor(Color.WHITE).fontSize(9)
                        .horizontalAlignment(HorizontalAlignment.LEFT).build());
                tableBuilder.addRow(Row.builder().height(4f)
                        .add(TextCell.builder().text("").build()).fontSize(3).build());
            } else {
                tableBuilder.addRow(Row.builder()
                        .add(TextCell.builder()
                                .text("- sou fodaaaaa!! seloko, muito foda aiiiii nossaaaa que grossoooo").build())
                        .textColor(Color.WHITE).fontSize(9)
                        .horizontalAlignment(HorizontalAlignment.LEFT).build());
            }
        }

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Certificações").paddingBottom(10).borderWidthBottom(1)
                        .borderColor(Color.WHITE).build())
                .textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(13).font(PDType1Font.HELVETICA)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        for (int i = 0; i < 3; i++) {
            if (i < 2) {
                tableBuilder.addRow(Row.builder()
                        .add(TextCell.builder().text("- sou fodaaaaa!! seloko, muito foda quebra a linha porraaaaaa")
                                .build())
                        .textColor(Color.WHITE).fontSize(9)
                        .horizontalAlignment(HorizontalAlignment.LEFT).build());
                tableBuilder.addRow(Row.builder().height(4f)
                        .add(TextCell.builder().text("").build()).fontSize(3).build());
            } else {
                tableBuilder.addRow(Row.builder()
                        .add(TextCell.builder()
                                .text("- sou fodaaaaa!! seloko, muito foda aiiiii nossaaaa que grossoooo").build())
                        .textColor(Color.WHITE).fontSize(9)
                        .horizontalAlignment(HorizontalAlignment.LEFT).build());
            }
        }

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("Idiomas").paddingBottom(10).borderWidthBottom(1).borderColor(Color.WHITE)
                        .build())
                .textColor(Color.WHITE).font(PDType1Font.HELVETICA_BOLD).fontSize(13).font(PDType1Font.HELVETICA)
                .horizontalAlignment(HorizontalAlignment.LEFT).build());
        tableBuilder.addRow(Row.builder()
                .add(TextCell.builder().text("").build()).fontSize(3).build());

        for (int i = 0; i < 6; i++) {
            if (i < 5) {
                tableBuilder.addRow(Row.builder()
                        .add(TextCell.builder().text("- Sou BR FDS").build())
                        .textColor(Color.WHITE).fontSize(9)
                        .horizontalAlignment(HorizontalAlignment.LEFT).build());
                tableBuilder.addRow(Row.builder().height(4f)
                        .add(TextCell.builder().text("").build()).fontSize(3).build());
            } else {
                tableBuilder.addRow(Row.builder()
                        .add(TextCell.builder().text("- Mentira sou Anunáqui").build())
                        .textColor(Color.WHITE).fontSize(9)
                        .horizontalAlignment(HorizontalAlignment.LEFT).build());
            }
        }
        return tableBuilder.build();
    }
}
