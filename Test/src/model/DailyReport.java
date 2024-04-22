package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DailyReport
{
    private final LocalDateTime reportDate;
    private final List<EntryExitRecord> entryRecords;
    private final List<EntryExitRecord> exitRecords;

    public DailyReport(LocalDateTime reportDate)
    {
        this.reportDate = reportDate;
        this.entryRecords = new ArrayList<>();
        this.exitRecords = new ArrayList<>();
    }

    public void addEntryRecord(EntryExitRecord entryRecord)
    {
        entryRecords.add(entryRecord);
    }

    public void addExitRecord(EntryExitRecord exitRecord)
    {
        exitRecords.add(exitRecord);
    }

    public boolean hasUnmatchedEntry()
    {
        for (EntryExitRecord entryRecord : entryRecords)
        {
            boolean matched = false;
            for (EntryExitRecord exitRecord : exitRecords)
            {
                if (exitRecord.getTime().isAfter(entryRecord.getTime()))
                {
                    matched = true;
                    break;
                }
            }
            if (!matched)
            {
                return false;
            }
        }
        return true;
    }

    public LocalDateTime getReportDate()
    {
        return reportDate;
    }

    public List<EntryExitRecord> getEntryRecords()
    {
        return entryRecords;
    }

    public List<EntryExitRecord> getExitRecords()
    {
        return exitRecords;
    }
}
