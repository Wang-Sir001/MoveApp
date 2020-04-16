package com.bw.movie.presenter;

import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.contract.SearchContract;
import com.bw.movie.model.MovieSearchModel;
import com.bw.movie.model.entity.SearchEntity.CinemaSearchEntity;
import com.bw.movie.model.entity.SearchEntity.MovieSearchEntity;

/**
 * data:2020/3/31
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class MovieSearchPresenter extends BasePresenter<MovieSearchModel, SearchContract.IView> implements SearchContract.IPresenter {
    @Override
    protected MovieSearchModel initModel() {
        return new MovieSearchModel();
    }

    @Override
    public void getMovieSearchData(String keyword, int page, int count) {
        model.getMovieSearchData(keyword, page, count, new SearchContract.IModel.MovieSearchModelCallback() {
            @Override
            public void MovieSearchSuccess(MovieSearchEntity movieSearchEntity) {
                getView().MovieSearchSuccess(movieSearchEntity);
            }

            @Override
            public void MovieSearchError(Throwable throwable) {
                getView().MovieSearchError(throwable);
            }

            @Override
            public void CinemaSearchSuccess(CinemaSearchEntity cinemaSearchEntity) {

            }

            @Override
            public void CinemaSearchError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getCinemaSearchData(int page, int count, String cinemaName) {
        model.getCinemaSearchData(page, count, cinemaName, new SearchContract.IModel.MovieSearchModelCallback() {
            @Override
            public void MovieSearchSuccess(MovieSearchEntity movieSearchEntity) {

            }

            @Override
            public void MovieSearchError(Throwable throwable) {

            }

            @Override
            public void CinemaSearchSuccess(CinemaSearchEntity cinemaSearchEntity) {
                getView().CinemaSearchSuccess(cinemaSearchEntity);
            }

            @Override
            public void CinemaSearchError(Throwable throwable) {
                getView().CinemaSearchError(throwable);
            }
        });
    }
}
