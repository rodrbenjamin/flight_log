package eu.profinit.education.flightlog.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@UtilityClass
public class FileUtils {

    public static String readResourceFileToString(String fileName) throws IOException, URISyntaxException {
        return new String(Files.readAllBytes(Paths.get(Objects.requireNonNull(FileUtils.class.getClassLoader().getResource(fileName)).toURI())));
    }

    public static String normalizeLineEndingsToCrLf(String fileContent) {
        return fileContent.replaceAll(StringUtils.CR + StringUtils.LF, StringUtils.LF).replaceAll(StringUtils.LF, StringUtils.CR + StringUtils.LF);
    }
}