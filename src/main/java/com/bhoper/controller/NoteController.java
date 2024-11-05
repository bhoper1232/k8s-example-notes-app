package com.bhoper.controller;

import com.bhoper.mode.Note;
import com.bhoper.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("notes", this.noteService.getAllNotes());
        return "home";
    }

    @GetMapping("/add-note")
    public String addNotePage(Model model) {
        model.addAttribute("note", new Note());
        return "add-note";
    }

    @PostMapping("/save-note")
    public String saveNote(@ModelAttribute("note") Note note) {
        noteService.saveOrUpdate(note);
        return "redirect:/";
    }

    @GetMapping("/edit-note/{id}")
    public String editNoteForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("note", noteService.getNoteById(id).orElse(new Note()));
        return "edit-note";
    }

    @PostMapping("/update-note/{id}")
    public String updateNote(@PathVariable("id") Long id, @ModelAttribute("note") Note note) {
        note.setId(id);
        noteService.saveOrUpdate(note);
        return "redirect:/";
    }

    @GetMapping("/delete-note/{id}")
    public String deleteNote(@PathVariable("id") Long id) {
        noteService.deleteNoteById(id);
        return "redirect:/";
    }
}
