package mvp.app.com.mvparchitecturetetra.login;

public class LoginModel implements LoginActivityMVP.Model{

    private LoginRepositary repositary;

    public LoginModel(LoginRepositary repositary) {
        this.repositary = repositary;
    }

    @Override
    public void createUser(String fname, String lname) {
        repositary.saveUser(new User(fname, lname));
    }

    @Override
    public User getUser() {
        return repositary.getUser();
    }
}
