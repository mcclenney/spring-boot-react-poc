package com.example.demo.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="v1/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Optional<Claim> getClaims(@PathVariable("id") Long id) {
        return claimService.getClaim(id);
    }

    @RequestMapping(value="{id}",method = RequestMethod.PUT)
    public void updateClaims( @PathVariable("id") Long id, @RequestBody Claim claim) {
        claimService.updateClaim(claim);
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public void saveClaims(@RequestBody Claim claim) {
        claimService.saveClaim(claim);
    }

    @RequestMapping(value="{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClaims( @PathVariable("id") Long id) {
        claimService.deleteClaim(id);
    }
}
