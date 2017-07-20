package utils;

/**
 * Created by Pawel on 21.06.2017.
 */
import data.*;

import java.util.*;

public class LibraryUtils {

    public static void printBooks(Library   lib){
        printPublications(lib,  Book.class);
    }

    public static void printMagazines(Library   lib){
        printPublications(lib,  Magazine.class);
    }

    private static void printPublications(Library   lib,    Class   cl){
        long    countMagazines  =   lib.getPublications().values().stream()     //zwraca strumien utworzony z zbioru
                .filter(cl::isInstance)     //filtruje po klasie wywolujacej
                .sorted(new Library.AlphabeticalComparaotr())   //sortuje alfabetycznie zgodnie z metoda sortujaca
                .peek(System.out::println)      //wyswietla
                .count();

        if (countMagazines  ==  0){
            System.out.println("w bibliotece nie znaleziono publikacji typu "   +   cl.getSimpleName());
        }
    }

    public static void printUsers(Library   lib){
        lib.getUsers().values().stream()
                .sorted((a, b)   ->  a.getLastName().compareTo(b.getLastName()))
                .forEach(System.out :: println);
    }


}
