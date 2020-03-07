package pro3.attandance.controller;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Sponsor;
import pro3.attandance.model.Training;
import pro3.attandance.services.SponsorService;
import pro3.attandance.services.TrainingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sponsor")
public class SponsorController {

    private final SponsorService sponsorService;

    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @GetMapping
    public List<Sponsor> getUser() {
        return sponsorService.getUser();
    }

    @GetMapping("/{id}")
    public Optional<Sponsor> getUserById(@PathVariable("id") Integer id) {
        return sponsorService.getUserById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody Sponsor sponsor) {
        sponsorService.addUser(sponsor);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ("id") Integer id){
        sponsorService.deleteUser(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody Sponsor sponsor){
        sponsorService.updateUser(sponsor.getSponsorid(), sponsor);
    }
}
