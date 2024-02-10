package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.dto.DeleteNoteDto;
import com.udacity.jwdnd.course1.cloudstorage.dto.NotesDto;
import com.udacity.jwdnd.course1.cloudstorage.models.Note;
import com.udacity.jwdnd.course1.cloudstorage.models.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;

import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private NotesService notesService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getHomePage(Model model, Authentication authentication) {
        User user = userService.getUser(authentication.getName());
        List<Note> allNotes = notesService.getAllNotes(user);
        model.addAttribute("notes", allNotes);
        return "home";
    }

    @PostMapping("/notes")
    public String createNotes(@ModelAttribute NotesDto notesDto, Model model, Authentication authentication) {
        User user = userService.getUser(authentication.getName());
        notesService.addNewNote(notesDto, user);
        List<Note> allNotes = notesService.getAllNotes(user);
        model.addAttribute("notes", allNotes);
        return "home";
    }

    @PostMapping("/notes/deleteNote")
    public String deleteNote(@ModelAttribute DeleteNoteDto deleteNoteDto, Model model, Authentication authentication) {
        User user = userService.getUser(authentication.getName());
//        notesService.addNewNote(notesDto, user);
        notesService.deleteNote(deleteNoteDto.getNoteid());
        List<Note> allNotes = notesService.getAllNotes(user);
        model.addAttribute("notes", allNotes);
        return "home";
    }

}
