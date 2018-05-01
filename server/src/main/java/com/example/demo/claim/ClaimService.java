package com.example.demo.claim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository repository;

    public Optional<Claim> getClaim(Long id) {
        return repository.findById(id);
    }

    public void saveClaim(Claim claim){
        repository.save(claim);
    }

    public void updateClaim(Claim claim) {
        repository.save(claim);
    }

    public void deleteClaim(Long id) {
        repository.deleteById(id);
    }

    public List<Claim> getAllClaims() {
        return newArrayList(repository.findAll());
    }
}
