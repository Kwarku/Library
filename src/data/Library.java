package data;

import data.Book;
import utils.DataReader;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Pawel on 16.05.2017.
 */
public class Library implements Serializable {
    private static final long serialVersionUID = 2995794334600947814L;

    public static final int INITIAL_COMPACITY=1;
    private Publication[] publications;
    private int publicationsNumber;

    public int getPublicationsNumber(){
        return publicationsNumber;
    }
    public Publication[] getPublications(){
        return publications;
    }

    public Library(){
        publications = new Publication[INITIAL_COMPACITY];
    }

     public void addBook(Book book){
        addPublication(book);
     }
     public void addMagazine(Magazine magazine){
        addPublication(magazine);
     }

     public void removePublication(Publication pub){
         if (pub == null)
             return;

         final int NOT_FOUND = -1;
         int found = NOT_FOUND;
         int i=0;
         while (i<publications.length && found == NOT_FOUND){
             if (pub.equals(publications[i])){
                 found = i;
             } else {
                 i++;
             }
         }
         if (found != NOT_FOUND){
             System.arraycopy(publications, found +1 , publications , found ,
                     publications.length -found -1);
             publicationsNumber--;
         }
     }


     public void addPublication(Publication pub) throws ArrayIndexOutOfBoundsException{
         if (publicationsNumber == publications.length){
             publications = Arrays.copyOf(publications , publications.length*2);
         }
         publications[publicationsNumber]=pub;
         publicationsNumber++;
     }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i< publicationsNumber;i++){
            builder.append(publications[i]);
            builder.append("\n");
        }
        return builder.toString();
    }




}



