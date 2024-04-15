package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DailyReport {
    private final LocalDateTime reportDate;
    private final List<EntryExitRecord> entryRecords = new ArrayList<>();
    private final List<EntryExitRecord> exitRecords = new ArrayList<>();
    public DailyReport(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public void addEntryRecord(EntryExitRecord record)
    {
        entryRecords.add(record);
    }
    public void addExitRecord(EntryExitRecord record)
    {
        exitRecords.add(record);
    }

    public boolean hasUnmatchedEntry() {
        for (EntryExitRecord entryRecord : entryRecords) {
            boolean matched = false;
            for (EntryExitRecord exitRecord : exitRecords) {
                if (exitRecord.getTime().isAfter(entryRecord.getTime())) {
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                return false;
            }
        }
        return true;
    }

    public boolean checkEntryConsistency() {
        return entryRecords.size() % 2 == 0;
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

    public Duration calculateTotalWorkingTime()
    {
        Duration totalWorkingTime = Duration.ZERO;

        for (EntryExitRecord entryRecord : entryRecords)
        {
            if (!entryRecord.isEntry())
            {
                continue;
            }
            LocalDateTime entryTime = entryRecord.getTime();
            EntryExitRecord exitRecord = exitRecords.stream()
                    .filter(record -> !record.isEntry() && record.getTime().isAfter(entryTime))
                    .findFirst()
                    .orElse(null);
            if (exitRecord != null)
            {
                LocalDateTime exitTime = exitRecord.getTime();
                totalWorkingTime = totalWorkingTime.plus(Duration.between(entryTime, exitTime));
            }
        }
        return totalWorkingTime;
    }

}