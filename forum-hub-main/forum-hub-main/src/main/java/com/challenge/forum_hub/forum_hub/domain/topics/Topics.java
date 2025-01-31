package com.challenge.forum_hub.forum_hub.domain.topics;

import com.challenge.forum_hub.forum_hub.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topics")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "topic_status")
    @Enumerated(EnumType.STRING)
    private TopicStatus topicStatus = TopicStatus.valueOf("OPEN");

    //    @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
    private User author;

    private String course;


    public Topics(Long id, String title, String message, LocalDateTime creationDate, TopicStatus topicStatus, User author, String course) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.creationDate = LocalDateTime.now();
        this.topicStatus = topicStatus;
        this.author = author;
        this.course = course;
    }

    public Topics() {};


    public Topics(TopicsCreateData data, User author){
        this.title = data.title();
        this.message = data.message();
        this.creationDate = LocalDateTime.now();
        this.topicStatus = data.topicStatus();
        this.author = author; // Passamos o objeto User
        this.course = data.course();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public TopicStatus getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(TopicStatus topicStatus) {
        this.topicStatus = topicStatus;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.valueOf(message);
    }
}