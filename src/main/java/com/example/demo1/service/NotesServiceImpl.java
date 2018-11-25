package com.example.demo1.service;

import com.example.demo1.dao.NotesRepository;
import com.example.demo1.model.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotesServiceImpl implements NotesService{
    @Autowired
    protected NotesRepository notesRepository;
    @Override
    public Notes save(Notes notes){
        return this.notesRepository.save(notes);
    }

    @Override
    public List<Notes> findAll() {
        return this.notesRepository.findAll();
    }

    @Override
    public void deleteNotes(Long id) {
        this.notesRepository.deleteById(id);
    }

}
