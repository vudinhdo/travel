package vudinhdo.web.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vudinhdo.web.travel.model.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Integer> {
//    Account findByUsername(String username);

    @Query(value = "FROM Accounts where username = :username")
    Accounts getDataByUsername(String username);
}