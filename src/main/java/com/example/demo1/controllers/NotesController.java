package com.example.demo1.controllers;

import com.example.demo1.model.Notes;
import com.example.demo1.service.NotesService;
import com.example.demo1.util.QueryResult;
import com.example.demo1.util.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Lob;
import java.io.IOException;
import java.util.List;

@RestController
public class NotesController {
    @Autowired
    protected NotesService notesService;
    protected ObjectMapper mapper;
    @Lob
    @RequestMapping(value="/saveNotes", method = RequestMethod.POST)
    public RestResponse saveNotes(@RequestBody String notesJson) throws IOException, JsonParseException {
        this.mapper = new ObjectMapper();
        Notes notes = this.mapper.readValue(notesJson, Notes.class);
        if(!this.validate(notes)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Please, add a new fucking note! ");
        }
        this.notesService.save(notes);
         return new RestResponse(HttpStatus.OK.value(), "Operation is fucking great!");
    }
    @RequestMapping(value = "/getNotes", method = RequestMethod.GET)
    public List<Notes> getNotes(){
        return this.notesService.findAll();
    }
    @RequestMapping(value = "/deleteNotes", method = RequestMethod.POST)
    public void deleteNotes(@RequestBody String notesJson) throws Exception {
         this.mapper = new ObjectMapper();
         Notes notes = this.mapper.readValue(notesJson, Notes.class);
         if (notes.getId() == null) {
             throw new Exception("Id is not found!");
         }
         this.notesService.deleteNotes(notes.getId());
    }
    private boolean validate (Notes notes) {
        boolean isValid = true;
        if (StringUtils.trimToNull(notes.getTag()) == null) {
            isValid = false;
        }
        if (StringUtils.trimToNull(notes.getContent()) == null) {
            isValid = false;
        }
        return isValid;
    }
}
