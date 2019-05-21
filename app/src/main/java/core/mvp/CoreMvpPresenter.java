package core.mvp;

import android.support.annotation.Nullable;

public class CoreMvpPresenter <T extends ICoreMvpContract.View>
        implements ICoreMvpContract.Presenter<T>{

    @Nullable
    protected T view;

    @Override
    public void attachView(T view) {
        this.view = view;
        if (view !=null){
            view.attachPresenter(this);
        }
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void onViewCreated() {

    }
}
