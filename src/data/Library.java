package data;

import data.Book;
import utils.DataReader;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pawel on 16.05.2017.
 */
public class Library implements Serializable {
    private static final long serialVersionUID = 2995794334600947814L;

    //zmieniony typ
    private Map<String, Publication> publications;
    //dodanie
    private Map<String , LibraryUser> users;

    //zwracamy rozmiar mapy
    public int getPublicationsNumber(){
        return publications.size();
    }
    //zmieniony typ
    public Map<String, Publication> getPublications(){
        return publications;
    }

    //dodany getter
    public Map<String, LibraryUser> getUsers(){
        return users;
    }


    public Library(){
        //zmieniony typ
      publications = new HashMap<>();
      //dodane
        users = new HashMap<>();
    }


     public void addBook(Book book){
        addPublication(book);
     }
     public void addMagazine(Magazine magazine){
        addPublication(magazine);
     }


     public void addUser(LibraryUser user){
         users.put(user.getPesel(), user);
     }

     //zmiana logiki
     public void removePublication(Publication pub){
        if (publications.containsValue(pub)){
            publications.remove(pub.getTitle());
        }
     }

    // zmiana logiki i usuniecie wyjatku
     public void addPublication(Publication pub){
         publications.put(pub.getTitle(),pub);
     }

    // zmiana logiki petli
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Publication p: publications.values()){
            builder.append(p);
            builder.append("\n");
        }
        return builder.toString();
    }

    public static class AlphabeticalComparaotr implements Comparator<Publication>{

        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1==null && o2==null){
                return 0;
            }
            if (o1 == null){
                return 1;
            }
            if (o2 ==null){
                return -1;
            }
           return  o1.getTitle().compareTo(o2.getTitle());
        }
    }
    public static class DateCopmarator implements Comparator<Publication>{

        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1==null && o2==null){
                return 0;
            }
            if (o1 == null){
                return 1;
            }
            if (o2 ==null){
                return -1;
            }
            Integer i1 = o1.getYear();
            Integer i2 = o2.getYear();
            return -i1.compareTo(i2);
        }
    }




}



