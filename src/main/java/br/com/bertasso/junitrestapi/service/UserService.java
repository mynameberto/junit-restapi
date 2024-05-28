package br.com.bertasso.junitrestapi.service;

import br.com.bertasso.junitrestapi.domain.User;
import br.com.bertasso.junitrestapi.domain.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User addUser(UserDTO obj);
    User updateUser(UserDTO obj);
    void deleteUser(Integer id);
}
