package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/__journal") //add mapping on class
public class JournalEntryControllerV2{

    @Autowired
    private JournalEntryService journalEntryService;
    //instance created by spring we injected it

    @GetMapping //its path becomes localhost:8080/journal
    public ResponseEntity<?> getAll()
    {
        List<JournalEntry> all=journalEntryService.getAll();
        if(all!=null && !all.isEmpty())
        {
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping //its path becomes localhost:8080/journal
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myentry)
    {
        try{
            myentry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myentry, null);
            return new ResponseEntity<>(myentry,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myId}") //its path becomes localhost:8080/journal
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId)
    {
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
        if(journalEntry.isPresent())
        {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myId}") //its path becomes localhost:8080/journal
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId)
    {
        journalEntryService.deleteById(myId, null);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //? signifies we return any type of body
    }

    @PutMapping("/id/{myId}") //its path becomes localhost:8080/journal
    public ResponseEntity<?>  updateJournalEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntry newentry)
    {
        JournalEntry old=journalEntryService.findById(myId).orElse(null);
        if(old!=null)
        {
            old.setTitle(newentry.getTitle()!=null && !newentry.getTitle().equals("") ? newentry.getTitle() : old.getTitle());
            old.setContent(newentry.getContent()!=null && !newentry.getContent().equals("") ? newentry.getContent() : old.getContent());
            journalEntryService.saveEntry(old, null);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(old,HttpStatus.NOT_FOUND);
    }


}
