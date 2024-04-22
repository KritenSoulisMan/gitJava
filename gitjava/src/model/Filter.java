package model;

import java.util.Date;
import java.util.HashMap;

public class Filter {
    private String stringFilter;
    private Date dateFilter;
    private FilterType filterType;
    private HashMap<String, String> stringFilters = new HashMap<>();
    private HashMap<String, Date> dateFilters = new HashMap<>();

    public void addStringFilter(String fieldName, String fieldValue) {
        stringFilters.put(fieldName, fieldValue);
    }

    public HashMap<String, String> getTextFilters() {
        return stringFilters;
    }

    public void addDateFilter(String fieldName, Date fieldValue) {
        dateFilters.put(fieldName, fieldValue);
    }

    public HashMap<String, Date> getDateFilters() {
        return dateFilters;
    }

    public Filter(FilterType filterType) {
        this.filterType = filterType;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setStringFilter(String stringFilter) {
        this.stringFilter = stringFilter;
    }

    public String getStringFilter() {
        return stringFilter;
    }

    public void setDateFilter(Date dateFilter) {
        this.dateFilter = dateFilter;
    }

    public Date getDateFilter() {
        return dateFilter;
    }

    public enum FilterType { STRING, DATE }
}
