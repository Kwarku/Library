package data;

/**
 * Created by Pawel on 07.06.2017.
 */
public class Magazine extends Publication {
    //pola
    private int month;
    private int day;
    private String language;

    // settery gettery
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    // konstruktory
    public Magazine(String title, String publisher,
                    String language,int year,int month,int day ){
        super(year,title,publisher);
        setLanguage(language);
        setMonth(month);
        setDay(day);
    }

    //wyswietlanie
    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(getTitle());
        print.append("; ");
        print.append(getPublisher());
        print.append("; ");
        print.append(getYear());
        print.append("; ");
        print.append(getMonth());
        print.append("; ");
        print.append(getDay());
        print.append("; ");
        print.append(getLanguage());

        return print.toString();

    }


    // do porownania stringow i metody equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;

        Magazine magazine = (Magazine) o;

        if (getMonth() != magazine.getMonth()) return false;
        if (getDay() != magazine.getDay()) return false;
        return getLanguage().equals(magazine.getLanguage());
    }

    @Override
    public int hashCode() {
        int result = getMonth();
        result = 31 * result + getDay();
        result = 31 * result + getLanguage().hashCode();
        return result;
    }
}
