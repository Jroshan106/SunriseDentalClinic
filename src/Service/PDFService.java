package service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

public class PDFService {

    public static String generateBill(
            String appointmentNo,
            String patientName,
            String dentistName,
            String treatmentType,
            double treatmentFee,
            double consultationFee,
            double discount,
            double total) {

        String fileName = "Sunrise_Dental_Bill_"
                + appointmentNo + ".pdf";

        String downloadsPath = System.getProperty("user.home")
                + File.separator + "Downloads";

        String filePath = downloadsPath
                + File.separator + fileName;

        Document document = new Document();

        try {

            PdfWriter.getInstance(
                    document,
                    new FileOutputStream(filePath)
            );

            document.open();

            Font titleFont = new Font(
                    Font.HELVETICA,
                    20,
                    Font.BOLD
            );

            Font headingFont = new Font(
                    Font.HELVETICA,
                    14,
                    Font.BOLD
            );

            Font normalFont = new Font(
                    Font.HELVETICA,
                    11,
                    Font.NORMAL
            );

            Paragraph title = new Paragraph(
                    "SUNRISE DENTAL CLINIC",
                    titleFont
            );

            title.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(title);

            Paragraph subtitle = new Paragraph(
                    "PATIENT BILL / RECEIPT",
                    headingFont
            );

            subtitle.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(subtitle);

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "Appointment Number: "
                    + appointmentNo,
                    normalFont
            ));

            document.add(new Paragraph(
                    "Patient Name: "
                    + patientName,
                    normalFont
            ));

            document.add(new Paragraph(
                    "Dentist: "
                    + dentistName,
                    normalFont
            ));

            document.add(new Paragraph(
                    "Treatment: "
                    + treatmentType,
                    normalFont
            ));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "BILL DETAILS",
                    headingFont
            ));

            document.add(new Paragraph(
                    "Treatment Fee: Rs. "
                    + String.format("%.2f", treatmentFee),
                    normalFont
            ));

            document.add(new Paragraph(
                    "Consultation Fee: Rs. "
                    + String.format("%.2f", consultationFee),
                    normalFont
            ));

            document.add(new Paragraph(
                    "Discount: Rs. "
                    + String.format("%.2f", discount),
                    normalFont
            ));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "TOTAL: Rs. "
                    + String.format("%.2f", total),
                    headingFont
            ));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "Thank you for choosing Sunrise Dental Clinic.",
                    normalFont
            ));

            document.add(new Paragraph(
                    "Please keep this receipt for your records.",
                    normalFont
            ));

            document.close();

            openPDF(filePath);

            return filePath;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    private static void openPDF(String filePath) {

        try {

            File pdfFile = new File(filePath);

            if (!pdfFile.exists()) {
                return;
            }

            if (Desktop.isDesktopSupported()) {

                Desktop.getDesktop().open(pdfFile);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}