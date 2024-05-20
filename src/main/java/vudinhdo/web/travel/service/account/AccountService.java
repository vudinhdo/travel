package vudinhdo.web.travel.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vudinhdo.web.travel.model.Accounts;

import vudinhdo.web.travel.repository.AccountRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AccountService implements AccountServiceIMPL {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public AccountService(AccountRepository accountRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.accountRepository = accountRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * @return
     */
    @Override
    public List<Accounts> getAllAccount() {
        List<Accounts> accounts = accountRepository.findAll();
        return accounts;
    }

    /**
     * @param accounts
     * @return
     */
    @Override
    public Accounts saveAccount(Accounts accounts) {
        String encodedPassword = bCryptPasswordEncoder.encode(accounts.getPassword());
        accounts.setPassword(bCryptPasswordEncoder.encode(encodedPassword));
        return accountRepository.save(accounts);
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accounts accounts = accountRepository.getDataByUsername(username);
        if (accounts == null) {
            throw new UsernameNotFoundException("Account not found");
        }
        return new User(username, accounts.getPassword(), Collections.emptyList());
    }
}
