package com.pb.challangeThree.msNotify.kafkaConsumer.entitie;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
@Document(collection = "notify")
public class Notify implements Serializable {

    @Id
    private String id;
    private String username;
    private String operation;
    private String timestamp;

    public Notify(String id, String username, String operation, String timestamp) {
        this.id = id;
        this.username = username;
        this.operation = operation;
        this.timestamp = timestamp;
    }

    public Notify() {
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Notify{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", operation='" + operation + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
