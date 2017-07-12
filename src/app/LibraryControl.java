package app;

/**
 * Created by Pawel on 25.05.2017.
 */
import utils.DataReader;
import data.Book;
import data.Library;
import data.Magazine;
import utils.FileManager;
import utils.LibraryUtils;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static javafx.application.Platform.exit;

public class LibraryControl {
    // zmienna do komunikacji z użytkownikiem
    private DataReader dataReader;
    private FileManager fileManager;

    // "biblioteka" przechowująca dane
    private Library library;

    public LibraryControl() {
        dataReader = new DataReader();
        fileManager = new FileManager();
        try{
            library = fileManager.readLibraryFromFile();
            System.out.println("Wczytano dane biblioteki z pliku ");
        } catch (IOException | ClassNotFoundException e) {
            library = new Library();
            System.out.println("Utworzono nowa bazę biblioteki. ");
        }
    }

    /*
     * Główna pętla programu, która pozwala na wybór opcji i interakcję
     */
    public void controlLoop(Option option) {
        printOptions();

        try {
            option = Option.createFromInt(dataReader.getInt());
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();

            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono niepoprawne dane, publikacji nie dodano");
        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("Wybrana opcja nie istnieje, wybierz ponownie:");
        }

        // zamykamy strumień wejścia
        if (option == Option.EXIT) {
            dataReader.close();
        } else {
            controlLoop(option);
        }
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        for (Option o : Option.values()) {
            System.out.println(o);
        }
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printBooks() {
        LibraryUtils.printBooks(library);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printMagazines() {
        LibraryUtils.printMagazines(library);
    }

    private void exit() {
        fileManager.writeLibraryToFile(library);
    }


    // klasa wewnetrzna potrzeba do sterowania programem,
    // private bo zadna inna klasa jej nie potrzebuje
    private enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BOOK(1, "Dodanie książki"),
        ADD_MAGAZINE(2,"Dodanie magazynu/gazety"),
        PRINT_BOOKS(3, "Wyświetlenie dostępnych książek"),
        PRINT_MAGAZINES(4, "WYświetlenie dostępnych magazynów/gazet");

        private int value;
        private String description;

        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[option];
            } catch(ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException("Brak elementu o wskazanym ID");
            }

            return result;
        }
    }

}


