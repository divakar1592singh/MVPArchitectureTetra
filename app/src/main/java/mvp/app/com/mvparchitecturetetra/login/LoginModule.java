package mvp.app.com.mvparchitecturetetra.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepositary repositary){
        return new LoginModel(repositary);
    }

    @Provides
    public LoginRepositary provideLoginRepositary(){
        return new MemoryRepositary();
    }


}
