package model;

import java.util.Date;
import java.util.HashMap;

public class Filter
{
    private String stringFilter;
    private Date dateFilter;
    private FilterType filterType;

    public void addStringFilter(String FieldName, String FieldValue)
    {
        //todo Придумать с HashMap функцию.
    }

    public HashMap <String, String> getTextFilters()
    {
        return new HashMap<>();
    }

    public Filter(FilterType filterType)
    {
        this.filterType = filterType;
    }

    public void setStringFilter(String stringFilter)
    {
        this.stringFilter = stringFilter;
    }

    public String getStringFilter()
    {
        return stringFilter;
    }

    public void setDateFilter(Date dateFilter)
    {
        this.dateFilter = dateFilter;
    }

    public Date getDateFilter()
    {
        return dateFilter;
    }

    public FilterType getFilterType()
    {
        return filterType;
    }

    public enum FilterType { STRING, DATE }
}
