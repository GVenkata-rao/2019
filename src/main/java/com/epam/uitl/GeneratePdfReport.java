package com.epam.uitl;


import com.epam.dto.InvoiceData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class GeneratePdfReport {
    public static ByteArrayInputStream orderReport(List<InvoiceData> invoices) {

            Document document = new Document();
            document.addHeader("Invoice","Order invoice");
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            try {

                PdfPTable table = new PdfPTable(4);
                table.setWidthPercentage(60);
                table.setWidths(new int[]{5, 3, 3,3});

                Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

                PdfPCell hcell;
                hcell = new PdfPCell(new Phrase("ProductName", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("Price", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("quantity", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                hcell = new PdfPCell(new Phrase("amount", headFont));
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);

                double totalSum=0;
                for (InvoiceData invoice : invoices) {

                    PdfPCell cell;

                    cell = new PdfPCell(new Phrase(invoice.getProductName()));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(Double.toString(invoice.getPrice())));
                    cell.setPaddingLeft(5);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(Integer.toString(invoice.getQuantity())));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setPaddingRight(5);
                    table.addCell(cell);

                    cell = new PdfPCell(new Phrase(Double.toString(invoice.getAmount())));
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cell.setPaddingRight(5);
                    table.addCell(cell);
                    totalSum+=invoice.getAmount();
                }

                PdfWriter.getInstance(document, out);
                document.open();
                document.add(new Paragraph("Order Invoice"));
                /*document.add(new Paragraph("Total Amount"+totalSum));*/
                Paragraph para1 = new Paragraph("Total Amount :"+totalSum);
                para1.setAlignment(Paragraph.ALIGN_RIGHT);
                para1.setSpacingAfter(50);
                document.add(para1);

                document.add(table);

                document.close();

            } catch (DocumentException ex) {
                ex.printStackTrace();

                //    Logger.getLogger(GeneratePdfReport.class.getName()));
            }

            return new ByteArrayInputStream(out.toByteArray());
        }
    }

