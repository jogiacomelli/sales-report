package br.com.ilegra.challenge.salesreport.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileUtils {

    public static boolean fileExists(Path pathToFile) {
        File file = new File(pathToFile.toString());
        return file.exists() && file.isFile();
    }

    public static boolean fileIsPlainText(Path pathToFile) throws IOException {
        return Files.probeContentType(pathToFile).equals("text/plain");
    }

    public static Set<Path> listFiles(Path dir) throws IOException {
        Set<Path> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            stream.forEach((path) -> {
                if(!Files.isDirectory(path)) {
                    fileList.add(path);
                }
            });

        }

        return fileList;
    }

    public static List<String> readLines(Path file) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();

        Scanner s = new Scanner(new FileReader(file.toString()));

        while (s.hasNext()) {
            lines.add(s.nextLine());
        }

        s.close();

        return lines;
    }
}
