package FileSystemModule;

import java.io.File;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class FSMonitor {

    public static void main(String[] args) throws Exception {
        long interval = 1000;
        final String dir = "./test_folder";
        // Change this to match the environment you want to watch.
        final File directory = new File(dir);
        FileAlterationObserver fao = new FileAlterationObserver(directory);
        fao.addListener(new FSListener());
        final FileAlterationMonitor monitor = new FileAlterationMonitor(interval);
        monitor.addObserver(fao);
        System.out.println("Starting monitor. CTRL+C to stop.");
        monitor.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("Stopping monitor.");
                monitor.stop();
            } catch (Exception ignored) {
            }
        }));
    }
}