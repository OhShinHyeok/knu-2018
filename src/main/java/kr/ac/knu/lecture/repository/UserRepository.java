package kr.ac.knu.lecture.repository;

import kr.ac.knu.lecture.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rokim on 2018. 11. 30..
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> getUserByAccountNotNull();
}
