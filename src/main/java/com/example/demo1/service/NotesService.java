package com.example.demo1.service;

import com.example.demo1.model.Notes;

import java.util.List;

public interface NotesService {
    Notes save(Notes notes);
    List<Notes> findAll();
    void deleteNotes(Long id);
}
