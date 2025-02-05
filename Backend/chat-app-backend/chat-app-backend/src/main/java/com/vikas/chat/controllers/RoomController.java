package com.vikas.chat.controllers;

import com.vikas.chat.entities.Room;
import com.vikas.chat.repositories.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }
    // create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
        if(roomRepository.findByRoomId(roomId)!= null){
            //room is already there
            return ResponseEntity.badRequest().body("Room already exists");
        }

        //create a room
        Room room = new Room();
        room.setRoomId(roomId);
        Room saveRoom = roomRepository.save(room);

        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }
}
