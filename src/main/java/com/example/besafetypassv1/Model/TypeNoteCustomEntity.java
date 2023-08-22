package com.example.besafetypassv1.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TYPE_NOTE_CUSTOM")
public class TypeNoteCustomEntity {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    private String name;
}
