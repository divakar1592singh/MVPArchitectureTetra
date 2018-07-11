package mvp.app.com.mvparchitecturetetra.login;

public interface LoginActivityMVP {

    interface View{

        String getFirstName();
        String getLastName();

        void setFirstName(String firstName);
        void setLastName(String lastName);

        void inputError();
        void showSavedUserMsg();
        void showUserNotAvailable();

    }
    interface Presenter{

        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();

    }
    interface Model{

        void createUser(String fname, String lname);
        User getUser();

    }


}
