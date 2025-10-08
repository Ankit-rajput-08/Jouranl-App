package com.example.Journal.Service;
import com.example.Journal.Entity.UserEntry;
import com.example.Journal.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveNewEntry(UserEntry userEntry){
        try {
            userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
            userEntry.setRoles(Arrays.asList("user"));
            userRepository.save(userEntry);
            return true;
        }catch (Exception e){
            log.error("error",e);
            return false;
        }
    }
    public void saveAdmin(UserEntry userEntry){
        userEntry.setPassword(passwordEncoder.encode(userEntry.getPassword()));
        userEntry.setRoles(Arrays.asList("user","ADMIN"));
        userRepository.save(userEntry);
    }

    public void saveUser(UserEntry userEntry){
        userRepository.save(userEntry);
    }

    public List<UserEntry> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntry> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public boolean deleteById(ObjectId id){
        userRepository.deleteById(id);
        return true;
    }
    public UserEntry findByUserName (String username){
        return userRepository.findByUserName(username);
    }
}