package mvp.app.com.mvparchitecturetetra.login;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import mvp.app.com.mvparchitecturetetra.R;
import mvp.app.com.mvparchitecturetetra.root.App;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View{

    @Inject
    LoginActivityMVP.Presenter presenter;

    EditText etFirstName, etLastName;
    Button actionSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getComponent().inject(this);

        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etLastName = (EditText)findViewById(R.id.etLastName);
        actionSubmit = (Button)findViewById(R.id.actionSubmit);

        actionSubmit.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            presenter.loginButtonClicked();
          }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.setView(this);
        presenter.getCurrentUser();

    }

    @Override
    public String getFirstName() {
        return etFirstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return etLastName.getText().toString();
    }

    @Override
    public void setFirstName(String firstName) {
        etFirstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        etLastName.setText(lastName);
    }

    @Override
    public void inputError() {
        Snackbar.make(
                findViewById(android.R.id.content),
                "First Name/Last Name can't be empty",
                Snackbar.LENGTH_INDEFINITE)
                .setAction(
                        "Ok",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {}
                        })
                .setActionTextColor(getResources().getColor(android.R.color.holo_orange_light))
                .show();

    }

    @Override
    public void showSavedUserMsg() {
        Snackbar.make(
                findViewById(android.R.id.content),
                "Data saved",Snackbar.LENGTH_SHORT)
                .setActionTextColor(getResources().getColor(android.R.color.holo_orange_light))
                .show();
    }

    @Override
    public void showUserNotAvailable() {
        Snackbar.make(
                findViewById(android.R.id.content),
                "User not available!",
                Snackbar.LENGTH_INDEFINITE)
                .setAction(
                        "Ok",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {}
                        })
                .setActionTextColor(getResources().getColor(android.R.color.holo_orange_light))
                .show();
    }

}
