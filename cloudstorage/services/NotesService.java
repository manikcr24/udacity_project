package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.dto.NotesDto;
import com.udacity.jwdnd.course1.cloudstorage.models.Note;
import com.udacity.jwdnd.course1.cloudstorage.models.User;
import com.udacity.jwdnd.course1.cloudstorage.repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    @Autowired
    private NotesRepository notesRepository;

    public Note addNewNote(NotesDto notesDto, User user) {
        Note note = Note.builder()
                .notedescription(notesDto.getNoteDescription())
                .notetitle(notesDto.getNoteTitle())
                .userid(user.getUserid())
                .build();
        Note save = notesRepository.save(note);
        return save;
    }


    public List<Note> getAllNotes(User user) {
        return notesRepository.findByUserid(user.getUserid());
    }

    public void deleteNote(Long noteid) {
        notesRepository.deleteById(noteid);
    }
}
