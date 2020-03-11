package pro3.attandance.controller;

import org.springframework.web.bind.annotation.*;
import pro3.attandance.model.Sponsor;
import pro3.attandance.services.SponsorService;

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
        return sponsorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Sponsor> getUserById(@PathVariable("id") Integer id) {
        return sponsorService.getById(id);
    }

    @PostMapping(produces = "application/json")
    public void addUser(@RequestBody Sponsor sponsor) {
        sponsorService.add(sponsor);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        sponsorService.deleteById(id);
    }

    @PutMapping(produces = "application/json")
    public void updateUser(@RequestBody Sponsor sponsor) {
        sponsorService.update(sponsor.getSponsorid(), sponsor);
    }
}
