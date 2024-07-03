//package com.example.demo.api;
//
//import com.example.demo.entity.Club;
//import com.example.demo.model.ClubRequest;
//import com.example.demo.service.ClubService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class ClubAPI {
//    @Autowired
//    ClubService clubService ;
//
//    //get all club
//    @GetMapping
//    public List<Club> getAllClubs() {
//        return clubService.getAllClubs();
//    }
//
//
//    @PostMapping("createNewClub")
//    public ResponseEntity creatNewClub(@RequestBody ClubRequest clubRequest){
//        Club club = clubService.createNewClub(clubRequest);
//        return ResponseEntity.ok(club);
//    }
//
//    @DeleteMapping("Club/{id}")
//    public ResponseEntity<Club> deleteClub(@PathVariable Long id) {
//        clubService.deleteClub(id);
//        return ResponseEntity.ok().body(null);
//    }
//    @PutMapping("Club/{id}")
//    public ResponseEntity<Club> updateClub(@PathVariable Long id, @RequestBody ClubRequest clubRequest) {
//        Club club = clubService.updateClub(id, clubRequest);
//        return ResponseEntity.ok().body(club);
//    }
//    @GetMapping("Club/{id}")
//    public ResponseEntity<Club> getClubById(@PathVariable Long id) {
//        return clubService.getClubById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//
//}
