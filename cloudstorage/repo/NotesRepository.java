package com.udacity.jwdnd.course1.cloudstorage.repo;

import com.udacity.jwdnd.course1.cloudstorage.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotesRepository extends JpaRepository<Note, Long> {
    List<Note> findByUserid(Long userid);
}
