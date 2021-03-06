package com.kodcu;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usta on 09.05.2014.
 */
public class IO {

    public static String convert(InputStream is) {

        String content = "";

        try {
            content = IOUtils.toString(is);
            IOUtils.closeQuietly(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static String normalize(String content) {
        content = content.replace("'", "\\'");
        content = content.replace("\n", "\\n");
        content = content.replace("\r", "\\n");
        return content;
    }

//    public static String readFile(Path path, Boolean lineBreak) {
//        List<String> lines = new ArrayList<>();
//        try {
//            lines.clear();
//            lines.addAll(Files.readAllLines(path, Charset.forName("UTF-8")));
//        } catch (IOException e) {
//        }
//
//        final StringBuffer buffer = new StringBuffer();
//
//        for (String line : lines) {
//            buffer.append(line);
//            if (lines.size() != buffer.length()) ;
//            if (lineBreak)
//                buffer.append("\n");
//        }
//
//        return buffer.toString();
//    }

    public static void writeToFile(File file, String content, StandardOpenOption... openOption) {
        try {
            Files.write(file.toPath(), content.getBytes(Charset.forName("UTF-8")), openOption);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(Path path) {
        String content = "";
        try {
            InputStream is = Files.newInputStream(path, StandardOpenOption.READ);
            content = IOUtils.toString(is,"UTF-8");
            IOUtils.closeQuietly(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
