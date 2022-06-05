package at.fhv.ec.application.impl;

import at.fhv.ec.application.api.FileService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.NoSuchElementException;

@ApplicationScoped
public class FileServiceImpl implements FileService {
    @Inject
    Logger logger;

    private static final String FILEPATH = "/files/mp3/example.mp3";

    @Override
    public byte[] getExampleFile() throws IOException {
        File file = new File(FILEPATH);

        if(!file.exists()) {
            logger.info("File not found");
            throw new NoSuchElementException();
        }

        return Files.readAllBytes(file.toPath());
    }
}
