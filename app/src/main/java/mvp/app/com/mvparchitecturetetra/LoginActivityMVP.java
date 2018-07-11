package mvp.app.com.mvparchitecturetetra;

public interface LoginActivityMVP {

    interface View{

        String getFirstName();
        String getLastName();

        void setFirstName(String firstName);
        void setLastName(String lastName);

        void inputError();
        void showSavedUserMsg();

    }
    interface Presenter{

        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();

    }
    interface Model{

    }


}
