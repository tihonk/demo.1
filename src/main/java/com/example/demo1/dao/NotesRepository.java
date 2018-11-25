package com.example.demo1.dao;

import com.example.demo1.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotesRepository extends JpaRepository <Notes, Long>{
    @SuppressWarnings("unchecked2")
    Notes save(Notes notes);
}
