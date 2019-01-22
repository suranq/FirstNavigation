package com.example.firstnavigation.base;

import com.example.firstnavigation.https.ApiException;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public abstract class BaseObserver<T> implements Observer<T> {

    public BaseObserver(BaseModuleHttpFinish baseModuleHttpFinish) {
        this.sHttpFinishCallbak = sHttpFinishCallbak;
    }

    private BaseModuleHttpFinish sHttpFinishCallbak;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
        mCompositeDisposable.add(d);
    }

    @Override
    public void onError(Throwable e) {
        String error = "";
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            switch (apiException.getCode()) {
                case 1001:
                    error = apiException.getMessage();
                    break;
                case 2001:
                    error = apiException.getMessage();
                    break;
                case 2002:
                    error = apiException.getMessage();
                    break;
                case 2003:
                    error = apiException.getMessage();
                    break;
                case 2004:
                    error = apiException.getMessage();
                    break;
                case 2005:
                    error = apiException.getMessage();
                    break;
                case 2006:
                    error = apiException.getMessage();
                    break;
                case 2100:
                    error = apiException.getMessage();
                    break;
                case 2101:
                    error = apiException.getMessage();
                    break;
                case 2102:
                    error = apiException.getMessage();
                    break;
                case 2103:
                    error = apiException.getMessage();
                    break;
            }
        }else if (e instanceof HttpException){
            error = "网络请求错误";
        }else {
            error = "其他错误";
        }
        if (sHttpFinishCallbak != null){
            sHttpFinishCallbak.setShowError(error);
        }
    }

    @Override
    public void onComplete() {
        if (mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }
}
