package utils;

/**
 * Created by Pawel on 21.06.2017.
 */
import data.*;

import java.util.*;

public class LibraryUtils {


    public static void printBooks(Library lib) {
        List<Publication> publications = new ArrayList<>();
        publications.addAll(lib.getPublications().values());
        Collections.sort(publications, new Library.AlphabeticalComparaotr());

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
        List<Publication> publications = new ArrayList<>();
        publications.addAll(lib.getPublications().values());

        Collections.sort(publications, new Library.AlphabeticalComparaotr());
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
        List<LibraryUser> users = new ArrayList<>();
        users.addAll(lib.getUsers().values());
        Collections.sort(users, new Comparator<LibraryUser>() {
            @Override
            public int compare(LibraryUser o1, LibraryUser o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        for (LibraryUser u : users){
            System.out.println(u);
        }
    }
}