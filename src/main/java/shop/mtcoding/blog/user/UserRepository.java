package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {

    private EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void save(UserRequest.JoinDTO reqDTO) {
        Query query = em.createNativeQuery("insert into user_tb (username, password, email, created_at) values (?, ?, ?, now())");
        query.setParameter(1, reqDTO.getUsername());
        query.setParameter(2, reqDTO.getPassword());
        query.setParameter(3, reqDTO.getEmail());
        query.executeUpdate();
    }
}
