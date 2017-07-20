package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Pawel on 07.06.2017.
 */
public abstract class Publication implements Serializable, Comparable<Publication>{
    private static final long serialVersionUID = 7910452641164094454L;

    private LocalDate date;
    private String title;
    private String publisher;

    //settery gettery

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getYear() {
        return date.getYear();
    }

    // konstruktor
    protected Publication(int year,String title,String publisher){
        setDate(LocalDate.of(year,1,1));
        setTitle(title);
        setPublisher(publisher);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        Publication that = (Publication) o;
        return Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getPublisher(), that.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getTitle(), getPublisher());
    }

    @Override
    public int compareTo(Publication o) {
        return title.compareTo(o.getTitle());
    }
}
