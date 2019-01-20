package com.example.firstnavigation.utils;

import com.example.firstnavigation.base.BaseData;
import com.example.firstnavigation.https.ApiException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 马明祥 on 2019/1/18.
 */

public class RxUtils {

    public static <T> ObservableTransformer<T, T> rxObserableSchedulerHelper() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> ObservableTransformer<BaseData<T>, T> handleResule() {
        return new ObservableTransformer<BaseData<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseData<T>> upstream) {
                return upstream.flatMap(new Function<BaseData<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(BaseData<T> tBaseData) throws Exception {
                        if (tBaseData.getCode() == 0) {
                            return createData(tBaseData.getData());
                        } else {
                            return Observable.error(new ApiException(tBaseData.getCode(), tBaseData.getMessage()));
                        }
                    }
                });
            }
        };
    }

    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }
}
