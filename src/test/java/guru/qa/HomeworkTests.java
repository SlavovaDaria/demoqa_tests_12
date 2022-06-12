package guru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.pdftest.matchers.ContainsExactText;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.hamcrest.MatcherAssert.assertThat;

public class HomeworkTests {
    public static String resourceName = "src/test/resources/ziplesson.zip";
    public static String resourceZipName = "ziplesson.zip";

    public static String textPdfName = "example.pdf";
    public static String textXlsxName = "import_ou_xlsx.xlsx";
    public static String textCsvName = "import_ou_csv.csv";
    public static File file = new File(resourceName);
    static ClassLoader cl = HomeworkTests.class.getClassLoader();

    static void zipFindTest(String findText) {
        try {
            ZipFile sourceZipFile = new ZipFile(file);
            String searchFileName = findText;
            Enumeration e = sourceZipFile.entries();
            boolean found = false;
            System.out.println("Trying to search " + searchFileName + " in " + sourceZipFile.getName());
            while (e.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) e.nextElement();

                if (entry.getName().indexOf(searchFileName) != -1) {
                    found = true;
                    System.out.println("Found " + entry.getName());

                }
            }

            if (found == false) {
                System.out.println("File " + searchFileName + " Not Found inside ZIP file " + sourceZipFile.getName());
            }

            sourceZipFile.close();
        } catch (IOException ioe) {
            System.out.println("Error opening zip file" + ioe);
        }
    }

    @Test
    void zipParsingTest() throws Exception {
        ZipFile zf = new ZipFile(file);
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream(resourceZipName));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            zipFindTest(entry.getName());
            System.out.println(String.format(
                    "Item: %s \nType: %s \nSize: %d\n",
                    entry.getName(),
                    entry.isDirectory() ? "directory" : "file",
                    entry.getSize()
            ));
        }
    }

    @Test
    void zipPdfTest() throws Exception {
        ZipFile zf = new ZipFile(file);
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream(resourceZipName));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            try (InputStream inputStream = zf.getInputStream(entry)) {
                if (entry.getName().equals(textPdfName)) {
                    PDF pdf = new PDF(inputStream);
                    Assertions.assertEquals(1, pdf.numberOfPages);
                    assertThat(pdf, new ContainsExactText("PDF"));
                    System.out.println("example.pdf found and checked success");
                }
            }
        }
    }


    @Test
    void zipXlsTest() throws Exception {
        ZipFile zf = new ZipFile(file);
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream(resourceZipName));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            try (InputStream inputStream = zf.getInputStream(entry)) {
                if (entry.getName().equals(textXlsxName)) {
                    System.out.println("import_ou_xlsx.xlsx found and checked success");
                }
            }
        }
    }


    @Test
    void zipCsvTest() throws Exception {
        ZipFile zf = new ZipFile(file);
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream(resourceZipName));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            try (InputStream inputStream = zf.getInputStream(entry)) {
                if (entry.getName().equals(textCsvName)) {
                    System.out.println("import_ou_csv.csv found and checked success");
                }
            }
        }
    }
}