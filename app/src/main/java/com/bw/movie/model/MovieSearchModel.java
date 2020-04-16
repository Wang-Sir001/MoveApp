package com.bw.movie.model;

import com.bw.movie.api.SearchApiService;
import com.bw.movie.contract.SearchContract;
import com.bw.movie.model.entity.SearchEntity.CinemaSearchEntity;
import com.bw.movie.model.entity.SearchEntity.MovieSearchEntity;
import com.bw.movie.util.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * data:2020/3/31
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class MovieSearchModel implements SearchContract.IModel {

    @Override
    public void getMovieSearchData(String keyword, int page, int count, MovieSearchModelCallback movieSearchModelCallback) {
        NetUtils.getInstance().getClear(SearchApiService.class)
                .movieSearch(keyword,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieSearchEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieSearchEntity movieSearchEntity) {
                        movieSearchModelCallback.MovieSearchSuccess(movieSearchEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        movieSearchModelCallback.MovieSearchError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCinemaSearchData(int page, int count, String cinemaName, MovieSearchModelCallback movieSearchModelCallback) {
        NetUtils.getInstance().getClear(SearchApiService.class)
                .cinemaSearch(page,count,cinemaName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaSearchEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaSearchEntity cinemaSearchEntity) {
                        movieSearchModelCallback.CinemaSearchSuccess(cinemaSearchEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        movieSearchModelCallback.CinemaSearchError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
