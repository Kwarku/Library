package data;

import data.Book;
import utils.DataReader;

/**
 * Created by Pawel on 16.05.2017.
 */
public class Library {
    public static final int MAX_PUBLICATIONS=2000;
    private Publication[] publications;
    private int publicationsNumber;

    public int getPublicationsNumber(){
        return publicationsNumber;
    }
    public Publication[] getPublications(){
        return publications;
    }

    public Library(){
        publications = new Publication[MAX_PUBLICATIONS];
    }

     public void addBook(Book book){
        addPublication(book);
     }
     public void addMagazine(Magazine magazine){
        addPublication(magazine);
     }


     public void addPublication(Publication pub) throws ArrayIndexOutOfBoundsException{
         if (publicationsNumber == MAX_PUBLICATIONS){
             throw new ArrayIndexOutOfBoundsException("MAX PUBLICATIONS " + MAX_PUBLICATIONS);
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



