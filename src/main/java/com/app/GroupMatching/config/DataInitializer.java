package com.app.GroupMatching.config;
import com.app.GroupMatching.entities.Language;
import com.app.GroupMatching.entities.Skill;
import com.app.GroupMatching.entities.Interest;
import com.app.GroupMatching.repositories.InterestRepo;
import com.app.GroupMatching.repositories.LanguageRepository;
import com.app.GroupMatching.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private InterestRepo interestRepository;
    @Override
    public void run(String... args) throws Exception {
        initializeLanguages();
        initializeSkills();
        initializeInterests();
    }

    private void initializeLanguages() {
        addLanguage("English");
        addLanguage("Spanish");
        addLanguage("French");
        addLanguage("German");
        addLanguage("Chinese");
        addLanguage("Japanese");
        addLanguage("Korean");
        addLanguage("Italian");
        addLanguage("Portuguese");
        addLanguage("Russian");
        addLanguage("Arabic");addLanguage("Hindi");
        addLanguage("Bengali");
        addLanguage("Urdu");
        addLanguage("Swahili");
        addLanguage("Dutch");
        addLanguage("Turkish");
        addLanguage("Vietnamese");
        addLanguage("Thai");
        addLanguage("Greek");
    }

    private void initializeSkills() {
        addSkill("Java");
        addSkill("Python");
        addSkill("JavaScript");
        addSkill("C++");
        addSkill("SQL");
        addSkill("HTML");
        addSkill("CSS"); addSkill("Project Management");
        addSkill("Data Analysis");
        addSkill("Machine Learning");
        addSkill("Cloud Computing");
        addSkill("DevOps");
        addSkill("Cybersecurity");
        addSkill("Artificial Intelligence");
        addSkill("Blockchain");
        addSkill("Docker");
        addSkill("Kubernetes");
        addSkill("Microservices");
        addSkill("Big Data");
        addSkill("React");
        addSkill("Angular");
        addSkill("Vue.js");
    }

    private void initializeInterests() {
        addInterest("Reading");
        addInterest("Traveling");
        addInterest("Cooking");
        addInterest("Sports");
        addInterest("Music");
        addInterest("Gaming");
        addInterest("Photography");
        addInterest("Writing");
        addInterest("Art");
        addInterest("Technology");
        addInterest("Hiking");
        addInterest("Yoga");
        addInterest("Fitness");
        addInterest("Gardening");
        addInterest("DIY Projects");
        addInterest("Movies");
        addInterest("Theater");
        addInterest("Volunteering");
        addInterest("Blogging");
        addInterest("Podcasting");
        addInterest("Astronomy");
        addInterest("Bird Watching");
    }

    private void addLanguage(String name) {

        languageRepository.save(new Language(name));
    }

    private void addSkill(String name) {

        skillRepository.save(new Skill(name));
    }
    private void addInterest(String name) {

        interestRepository.save(new Interest(name));}
}




