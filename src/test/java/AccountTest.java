import Khoisama.Account;
import Khoisama.AccountService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testRegisterAccountUsingGetterSetter(String username, String password, String email, boolean expected) {
        Account account = new Account();
        AccountService service = new AccountService();


        account.setUsername(username);
        account.setPassword(password);
        account.setEmail(email);


        boolean actual = service.registerAccount(account.getUsername(), account.getPassword(), account.getEmail());

        assertEquals(expected, actual);
    }

}