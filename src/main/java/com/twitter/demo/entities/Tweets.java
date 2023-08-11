package com.twitter.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tweets")
public class Tweets implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tweet_sequence")
    @SequenceGenerator(name = "sequence_tweet", sequenceName = "tweet_sequence", allocationSize = 100)
    private Long tweet_id;

    @Column(columnDefinition = "varchar(100) NOT NULL")
    private String message;

    @Column(columnDefinition = "integer DEFAULT 0")
    private Integer num_likes;

    @Column(columnDefinition = "integer DEFAULT 0")
    private Integer num_tweets;

    @Column(columnDefinition = "integer DEFAULT 0")
    private Integer num_comments;

    @Column(columnDefinition = "TIMESTAMP DEFAULT now()")
    private Date created_at;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

}