package com.example.besafetypassv1.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NOTE")
@Data
@Entity
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String title_note;
    private String content;

    @OneToOne
    @JoinColumn(name = "type_note_custom_id", nullable = false)
    private TypeNoteCustomEntity typeNoteCustom;


}
