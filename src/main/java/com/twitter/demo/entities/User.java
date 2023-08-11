package com.twitter.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user_t")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "sequence_user", sequenceName = "user_sequence", allocationSize = 100)
    private Long user_id;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL UNIQUE")
    private String usert_handle;

    @Column(columnDefinition = "VARCHAR(50) NOT NULL UNIQUE")
    private String email_address;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String first_name;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String last_name;

    @Column(columnDefinition = "VARCHAR(10)")
    private String phonenumber;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL")
    private String pass;

    @Column(columnDefinition = "integer DEFAULT 1")
    private Integer estado;// estado 1 es activo

    @Column(columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date created_at;

}