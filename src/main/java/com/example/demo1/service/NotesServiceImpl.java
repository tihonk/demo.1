package com.example.demo1.service;

import com.example.demo1.dao.NotesRepository;
import com.example.demo1.model.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotesServiceImpl implements NotesService{
    @Autowired
    protected NotesRepository notesRepository;
    @Override
    public Notes save(Notes notes){
        return this.notesRepository.save(notes);
    }
}
