package com.bhoper.service;

import com.bhoper.mode.Note;
import com.bhoper.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return this.noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return this.noteRepository.findById(id);
    }

    public Note saveOrUpdate(Note note) {
        note.setCreationDate(LocalDate.now());
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
