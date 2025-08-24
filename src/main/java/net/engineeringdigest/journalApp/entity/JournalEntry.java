package net.engineeringdigest.journalApp.entity;

import lombok.*;
import net.engineeringdigest.journalApp.enums.Sentiment;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")
@Data //it adds getter,setter,constructor etc.
@NoArgsConstructor
//we use @Data it includes @getter,@setter,@tostring,@requiredargscontructor,@value
public class JournalEntry {

    @Id
    private ObjectId id; //maps with mongodb _id whcih is unque
    @NonNull
    private String title;

    private String content;

    private LocalDateTime date;

    private Sentiment sentiment;  //maps with database as string

}
