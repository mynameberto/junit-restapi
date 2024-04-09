package br.com.bertasso.junitrestapi.service.impl;

import br.com.bertasso.junitrestapi.domain.User;
import br.com.bertasso.junitrestapi.repository.UserRepository;
import br.com.bertasso.junitrestapi.service.UserService;
import br.com.bertasso.junitrestapi.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
