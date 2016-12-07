package io.falcon.pipeline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "messages")
public class Message {
    @Id
    long id;

    @Column(name="content")
    String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
