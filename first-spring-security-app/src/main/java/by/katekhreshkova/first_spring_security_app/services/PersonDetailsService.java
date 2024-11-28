package by.katekhreshkova.first_spring_security_app.services;

import by.katekhreshkova.first_spring_security_app.models.Person;
import by.katekhreshkova.first_spring_security_app.repositories.PeopleRepository;
import by.katekhreshkova.first_spring_security_app.security.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(username);
        if (person.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return new PersonDetails(person.get());
        }
    }
}
