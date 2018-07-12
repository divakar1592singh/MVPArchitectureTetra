package mvp.app.com.mvparchitecturetetra.login;

import android.support.annotation.Nullable;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Nullable
    private LoginActivityMVP.View view;

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {

        if(view != null){
            if(view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")){
                view.inputError();
            }else {
                model.createUser(view.getFirstName().trim(), view.getLastName().trim());
                view.showSavedUserMsg();
            }
        }
    }

    @Override
    public void getCurrentUser() {

        User user = model.getUser();

        if(user == null){
            if(view != null){
                view.showUserNotAvailable();
            }
        }else {
            if(view != null){
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }

    }
}
