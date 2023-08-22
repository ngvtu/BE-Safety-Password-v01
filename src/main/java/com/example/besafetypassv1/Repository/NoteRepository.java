package com.example.besafetypassv1.Repository;

import com.example.besafetypassv1.Model.NoteEntity;
import com.example.besafetypassv1.Model.TypeNoteCustomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
    List<NoteEntity> getAllByTypeNoteCustomId(long typeNoteCustom_id);
}
