package eu.profinit.education.flightlog.to;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.http.MediaType;

@Value
@Jacksonized
public class FileExportTo {

    String fileName;

    MediaType contentType;

    String encoding;

    @EqualsAndHashCode.Exclude
    byte[] content;
}