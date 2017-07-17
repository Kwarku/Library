package utils;

/**
 * Created by Pawel on 21.06.2017.
 */
import data.*;

import java.util.Arrays;
import java.util.Collection;

public class LibraryUtils {

    // zmiana typu i petli
    public static void printBooks(Library lib) {
        Collection<Publication> publications = lib.getPublications().values();
        int countBooks = 0;
       for (Publication p: publications){
           if (p instanceof Book){
               System.out.println(p);
               countBooks++;
           }
       }
        if(countBooks == 0) {
            System.out.println("Brak książek w bibliotece");
        }
    }

    public static void printMagazines(Library lib) {
      Collection<Publication> publications = lib.getPublications().values();
        int countMagazines = 0;
        for (Publication p: publications){
            if (p instanceof Magazine){
                System.out.println(p);
                countMagazines++;
            }
        }
        if(countMagazines == 0) {
            System.out.println("Brak magazynów w bibliotece");
        }
    }

    //dodanie metody wyswietlajaca liste uzytkownikow
    public static void printUsers(Library lib){
        Collection<LibraryUser> users = lib.getUsers().values();
        for (LibraryUser u : users){
            System.out.println(u);
        }
    }
}