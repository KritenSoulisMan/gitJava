package model;
import java.time.LocalDateTime;

class EntryExitRecord
{
    private LocalDateTime timeEntry;
    private LocalDateTime timeExit;

    public EntryExitRecord(LocalDateTime time)
    {
        this.timeEntry = time;
    }
    public LocalDateTime getTime()
    {
        return timeEntry;
    }
    public LocalDateTime getTimeExit()
    {
        return timeExit;
    }
    public LocalDateTime getTimeEntry()
    {
        return timeEntry;
    }
    public void setTimeExit(LocalDateTime time_exit)
    {
        this.timeExit = time_exit;
    }
    public void setTimeEntry(LocalDateTime time_entry)
    {
        this.timeEntry = time_entry;
    }

    public boolean isEntry()
    {
        return timeExit == null;
    }
}