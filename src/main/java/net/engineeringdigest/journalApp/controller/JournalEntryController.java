package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal") //add mapping on class
public class JournalEntryController {

    private Map<ObjectId, JournalEntry> journalEntries= new HashMap<>();

    @GetMapping //its path becomes localhost:8080/journal
    public List<JournalEntry> getAll()
    {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping //its path becomes localhost:8080/journal
    public boolean createEntry(@RequestBody JournalEntry myentry)
    {
        journalEntries.put(myentry.getId(),myentry);
        return true;
    }

    @GetMapping("/id/{myId}") //its path becomes localhost:8080/journal
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId)
    {
        return journalEntries.get(myId);
    }

    @DeleteMapping("/id/{myId}") //its path becomes localhost:8080/journal
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId)
    {
        return journalEntries.remove(myId);
    }

    @PutMapping("/id/{myId}") //its path becomes localhost:8080/journal
    public JournalEntry updateJournalEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry)
    {
        return journalEntries.put(myId,myEntry);
    }


}
