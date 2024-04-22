package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class EntryExitRecord
{
    private LocalDateTime timeEntry;
    private LocalDateTime timeExit;
    private boolean isExitRecorded;

    public EntryExitRecord(LocalDateTime time)
    {
        this.timeEntry = time;
        this.isExitRecorded = false;
    }

    public LocalDateTime getTime()
    {
        return timeEntry;
    }
    /*
    public LocalDateTime getTimeExit() {
        return timeExit;
    }

    public LocalDateTime getTimeEntry() {
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
     */
    public boolean isEntry()
    {
        return timeExit == null;
    }

    public boolean isExitRecorded()
    {
        return isExitRecorded;
    }

    public void recordExit()
    {
        if (!isExitRecorded())
        {
            timeExit = LocalDateTime.now();
            isExitRecorded = true;
        }
    }

    public static Duration calculateTotalWorkingTime(List<EntryExitRecord> entryExitRecords)
    {
        Duration totalWorkingTime = Duration.ZERO;
        for (EntryExitRecord entryRecord : entryExitRecords)
        {
            if (!entryRecord.isEntry())
            {
                continue;
            }
            LocalDateTime entryTime = entryRecord.getTime();
            for (EntryExitRecord exitRecord : entryExitRecords)
            {
                if (!exitRecord.isEntry() && exitRecord.getTime().isAfter(entryTime))
                {
                    LocalDateTime exitTime = exitRecord.getTime();
                    totalWorkingTime = totalWorkingTime.plus(Duration.between(entryTime, exitTime));
                    break;
                }
            }
        }
        return totalWorkingTime;
    }
}
