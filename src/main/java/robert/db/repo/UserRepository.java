package robert.db.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import robert.db.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
