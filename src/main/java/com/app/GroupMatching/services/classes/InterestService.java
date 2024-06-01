package com.app.GroupMatching.services.classes;

import com.app.GroupMatching.entities.Interest;
import com.app.GroupMatching.entities.Language;
import com.app.GroupMatching.repositories.InterestRepo;
import com.app.GroupMatching.repositories.LanguageRepository;
import com.app.GroupMatching.services.Interfaces.LanguageServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InterestService{

    private final InterestRepo interestRepo;

    public List<Interest> findInterestBasedOnId(List<Long> interestId){
         return interestRepo.findAll()
                .stream()
                .filter(interest -> interestId.contains(interest.getId()))
                .collect(Collectors.toList());
    }

    public List<Interest> findAllInterests(){
        return interestRepo.findAll();
    }
}
