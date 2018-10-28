package FileSystemModule;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class FSListener extends FileAlterationListenerAdaptor {
    @Override
    public void onStart(final FileAlterationObserver observer) {
//        System.out.println("The WindowsFileListener has started on " + observer.getDirectory().getAbsolutePath());
    }

    @Override
    public void onDirectoryCreate(final File directory) {
        System.out.println(directory.getAbsolutePath() + " was created.");
    }

    @Override
    public void onDirectoryChange(final File directory) {
        System.out.println(directory.getAbsolutePath() + " was modified");
    }

    @Override
    public void onDirectoryDelete(final File directory) {
        System.out.println(directory.getAbsolutePath() + " was deleted.");
    }

    @Override
    public void onFileCreate(final File file) {
        System.out.println(file.getAbsoluteFile() + " was created.");
        System.out.println("----------> length: " + file.length());
        System.out.println("----------> last modified: " + new Date(file.lastModified()));
        System.out.println("----------> readable: " + file.canRead());
        System.out.println("----------> writable: " + file.canWrite());
        System.out.println("----------> executable: " + file.canExecute());
    }

    @Override
    public void onFileChange(final File file) {
        System.out.println(file.getAbsoluteFile() + " was modified.");
        System.out.println("----------> length: " + file.length());
        System.out.println("----------> last modified: " + new Date(file.lastModified()));
        System.out.println("----------> readable: " + file.canRead());
        System.out.println("----------> writable: " + file.canWrite());
        System.out.println("----------> executable: " + file.canExecute());
    }

    @Override
    public void onFileDelete(final File file) {
        System.out.println(file.getAbsoluteFile() + " was deleted.");
    }

    @Override
    public void onStop(final FileAlterationObserver observer) {
//        System.out.println("The WindowsFileListener has stopped on " + observer.getDirectory().getAbsolutePath());
    }
}
