package app;

/**
 * Created by Pawel on 25.05.2017.
 */
public class LibraryApp {
    public static final String APP_NAME = "Biblioteka v0.92";
    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}
