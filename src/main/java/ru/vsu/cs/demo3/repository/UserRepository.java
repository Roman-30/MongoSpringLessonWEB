package ru.vsu.cs.demo3.repository;

import ru.vsu.cs.demo3.model.User;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findUserById(@NonNull Long id);
}
