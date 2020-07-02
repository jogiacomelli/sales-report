package br.com.ilegra.challenge.salesreport.watcher;

import br.com.ilegra.challenge.salesreport.configuration.AppProperties;
import br.com.ilegra.challenge.salesreport.service.FileProcessorService;
import br.com.ilegra.challenge.salesreport.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.Set;

@Service
public class DirectoryWatcherService implements CommandLineRunner {

    @Autowired
    private FileProcessorService fileProcessor;

    @Autowired
    private AppProperties properties;

    private static Path path;

    @Override
    public void run(String... args) throws Exception {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            path = Paths.get(properties.getHomePath() + properties.getDataFolderIn());

            System.out.println("Folder to watch: " + path.toString());
            
            handleFile(FileUtils.listFiles(path));

            path.register(
                    watcher,
                    StandardWatchEventKinds.ENTRY_CREATE);

            WatchKey key;
            while ((key = watcher.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    if(kind.equals(StandardWatchEventKinds.OVERFLOW)) {
                        continue;
                    }
                    handleFile((Path) event.context());
                }
                key.reset();
            }

        } catch (IOException | InterruptedException e) {
            //log
            throw e;
        }
    }

    private void handleFile(Path filename)  {
        fileProcessor.process(path.resolve(filename));
    }

    private void handleFile(Set<Path> listFiles) {
        listFiles.forEach(this::handleFile);
    }

}
