package data;

import java.io.Serializable;

/**
 * Created by Pawel on 07.06.2017.
 */
public abstract class Publication implements Serializable, Comparable<Publication>{
    private static final long serialVersionUID = 7910452641164094454L;
    private int year;
    private String title;
    private String publisher;

    //settery gettery
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
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


    // konstruktor
    protected Publication(int year,String title,String publisher){
        setYear(year);
        setTitle(title);
        setPublisher(publisher);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;

        Publication that = (Publication) o;

        if (getYear() != that.getYear()) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        return getPublisher() != null ? getPublisher().equals(that.getPublisher()) : that.getPublisher() == null;
    }

    @Override
    public int hashCode() {
        int result = getYear();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getPublisher() != null ? getPublisher().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Publication o) {
        return title.compareTo(o.getTitle());
    }
}
