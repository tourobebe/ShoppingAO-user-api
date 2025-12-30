package ao.shopping.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 
import ao.shopping.user.Model.User;
import java.util.List;

@Repository 
public interface UserRepository extends JpaRepository<User, Long> { 
User findBybi(String bi); 
List<User> queryByNomeLike(String name); 
}
