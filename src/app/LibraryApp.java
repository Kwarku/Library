package app;

/**
 * Created by Pawel on 25.05.2017.
 */
public class LibraryApp {
    public static void main(String[] args) {
        final String appName = "Biblioteka v1.0";
        System.out.println(appName);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}
