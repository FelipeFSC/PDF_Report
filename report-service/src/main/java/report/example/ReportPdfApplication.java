package report.example;

import report.example.report.ReportPdf;

public class ReportPdfApplication {

	public static void main(String[] args) {
		ReportPdf report = new ReportPdf();

		report.generate();
	}

}
