package at.fhv.ec.application.impl;

import at.fhv.ec.application.api.FileService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@ApplicationScoped
public class FileServiceImpl implements FileService {
    @Inject
    Logger logger;

    private static final List<String> FILES = List.of(
        "/files/mp3/example.mp3",
        "/files/mp3/example2.mp3",
        "/files/mp3/example3.mp3"
    );

    @Override
    public byte[] getExampleFile() throws IOException {
        Random random = new Random();
        int randomPos = random.nextInt(FILES.size());

        File file = new File(FILES.get(randomPos));

        if(!file.exists()) {
            logger.info("File not found");
            throw new NoSuchElementException();
        }

        return Files.readAllBytes(file.toPath());
    }
}
