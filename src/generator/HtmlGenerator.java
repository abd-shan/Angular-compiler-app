package generator;

import ast.program.AngularApp;
import ast.program.ComponentFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlGenerator {

    private static final String OUTPUT_DIR = "output";

    public HtmlGenerator(AngularApp angularApp) {
        List<ComponentFile> files = angularApp.getComponentFiles();

        // Ensure output directory exists
        File outputDir = new File(OUTPUT_DIR);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        for (ComponentFile file : files) {
            String className = file.getClassName();
            String fileName = className + ".html";
            File htmlFile = new File(outputDir, fileName);

            try (FileWriter writer = new FileWriter(htmlFile)) {
                // Build minimal HTML skeleton
                writer.write("<!DOCTYPE html>\n");
                writer.write("<html lang=\"en\">\n");
                writer.write("<head>\n");
                writer.write("    <meta charset=\"UTF-8\">\n");
                writer.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
                writer.write("    <title>" + className + "</title>\n");

                // Insert styles if available
                writer.write("    <style>\n");
                if (file.getStyles() != null) {
                    writer.write(file.getStyles());
                }
                writer.write("\n    </style>\n");

                writer.write("</head>\n");
                writer.write("<body>\n");
                // body intentionally left empty
                writer.write("</body>\n");
                writer.write("</html>\n");

                System.out.println("Created: " + htmlFile.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error creating file: " + htmlFile.getName());
                e.printStackTrace();
            }
        }
    }
}
