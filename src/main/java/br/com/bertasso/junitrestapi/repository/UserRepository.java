package br.com.bertasso.junitrestapi.repository;

import br.com.bertasso.junitrestapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
