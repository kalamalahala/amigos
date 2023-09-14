package rh.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rh.spring.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

}
