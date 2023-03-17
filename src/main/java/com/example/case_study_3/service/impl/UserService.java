package com.example.case_study_3.service.impl;
import com.example.case_study_3.model.User;
import com.example.case_study_3.repository.UserRepository;
import com.example.case_study_3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
   private UserRepository userRepository;
    @Override
    public List<User> findALl() {
        return userRepository.findAll();
    }
    @Override
    public User finOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public void save(User user) {
    userRepository.save(user);
    }
    @Override
    public void delete(Long id) {
    userRepository.deleteById(id);
    }
    @Override
    public User findByUserNameAndPassWord(String username, String passWord) {
        User user =userRepository.findByUsernameAndPassword(username,passWord);
        return user;
    }
}
