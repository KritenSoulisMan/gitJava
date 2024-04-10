package model;

import java.util.Date;

public class Filter {
    private String stringFilter;
    private Date dateFilter;

    public void setString(String stringFilter) {
        this.stringFilter = stringFilter;
    }

    public String getString() {
        return stringFilter;
    }

    public void setDate(Date dateFilter) {
        this.dateFilter = dateFilter;
    }

    public Date getDate() {
        return dateFilter;
    }
}
