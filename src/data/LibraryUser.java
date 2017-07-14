package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Pawel on 14.07.2017.
 *
 * addPublicationToHistory i borrowPublication i returnPublication pozwalaja na powiazanie ksiazki
 * z uzytkownikiem i dodaja mozliwosc wyporzyczenia kilku ksiazek tych samych dzieki zastosowaniu ArrayList a nie zbior
 *
 */
public class LibraryUser extends User{
    private static final long serialVersionUID = 1704976407311180890L;

    private List<Publication> publicationHistory;
    private List<Publication> borrowedPublications;

    public List<Publication> getPublicationHistory(){
        return publicationHistory;
    }
    public List<Publication> getBorrowedPublications(){
        return borrowedPublications;
    }

    public LibraryUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
        publicationHistory = new ArrayList<>();
        borrowedPublications = new ArrayList<>();
    }


    private void addPublicationToHistory(Publication pub){
        publicationHistory.add(pub);
    }
    private void borrowPublication(Publication pub){
        borrowedPublications.add(pub);
    }

    public boolean returnPublication(Publication pub){
        boolean result = false;
        if (borrowedPublications.remove(pub)){
            result = true;
            addPublicationToHistory(pub);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryUser)) return false;
        if (!super.equals(o)) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(getPublicationHistory(), that.getPublicationHistory()) &&
                Objects.equals(getBorrowedPublications(), that.getBorrowedPublications());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPublicationHistory(), getBorrowedPublications());
    }
}
