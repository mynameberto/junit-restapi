package br.com.bertasso.junitrestapi.service;

import br.com.bertasso.junitrestapi.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById(Integer id);
}
