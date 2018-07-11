package mvp.app.com.mvparchitecturetetra.root;

import javax.inject.Singleton;

import dagger.Component;
import mvp.app.com.mvparchitecturetetra.login.LoginActivity;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(LoginActivity target);

}
