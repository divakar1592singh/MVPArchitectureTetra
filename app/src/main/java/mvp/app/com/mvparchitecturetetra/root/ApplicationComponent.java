package mvp.app.com.mvparchitecturetetra.root;

import javax.inject.Singleton;

import dagger.Component;
import mvp.app.com.mvparchitecturetetra.login.LoginActivity;
import mvp.app.com.mvparchitecturetetra.login.LoginModule;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity target);

}
