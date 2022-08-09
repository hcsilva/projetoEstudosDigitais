package br.com.digitaLife.cardapioDigital.repository;

import br.com.digitaLife.cardapioDigital.model.UserModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
}
