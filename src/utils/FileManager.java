package utils;
import data.Library;

import java.io.*;

/**
 * Created by Pawel on 29.06.2017.
 */

public class FileManager {
    public static final String FILE_NAME = "Library.o";

    public void writeLibraryToFile(Library lib){
        try(
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ){
            oos.writeObject(lib);

        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Błąd podczas zpaisu danych do pliku " + FILE_NAME);
        }

    }

    public Library readLibraryFromFile() throws IOException, ClassNotFoundException {
        Library library = null;
        try(
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            library = (Library) ois.readObject();

        } catch (FileNotFoundException e) {
            System.err.println("Nie odnaleziono pliku " + FILE_NAME);
            throw e;
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu dancyh do pliku " + FILE_NAME);
            throw e;
        } catch (ClassNotFoundException e) {
            System.err.println("Nieprawidłowy format pliku");
            throw e;
        }

        return library;
    }
}
