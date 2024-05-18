package vudinhdo.web.travel.service.account;

import org.springframework.security.core.userdetails.UserDetailsService;
import vudinhdo.web.travel.model.Accounts;

import java.util.List;

public interface AccountService extends UserDetailsService {

    List<Accounts> getAllAccount();

}
