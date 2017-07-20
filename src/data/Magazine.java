package data;

import java.time.LocalDate;

/**
 * Created by Pawel on 07.06.2017.
 */



public class Magazine extends Publication {
    private static final long serialVersionUID = 2061400934707882805L;

    //pola
    private int month;
    private int day;
    private String language;

    // settery gettery
    public int getMonth(){
        return getDate().getMonthValue();
    }
    public int getDay(){
        return getDate().getDayOfMonth();
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
        setDate(LocalDate.of(year,month,day));
    }

    @Override
    public String toString() {
        return getTitle() +  "; " + getPublisher() + "; " + getYear() + "-"
                + getMonth() + "-" + getDay() + "; " + getLanguage();
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
