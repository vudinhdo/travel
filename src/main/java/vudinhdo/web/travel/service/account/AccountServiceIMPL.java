package vudinhdo.web.travel.service.account;

import org.springframework.security.core.userdetails.UserDetailsService;
import vudinhdo.web.travel.model.Accounts;

import java.util.List;

public interface AccountServiceIMPL extends UserDetailsService {

    List<Accounts> getAllAccount();

    Accounts saveAccount(Accounts accounts);

}
