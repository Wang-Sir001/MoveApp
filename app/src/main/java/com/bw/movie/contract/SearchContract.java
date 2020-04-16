package com.bw.movie.contract;

import com.bw.movie.base.mvp.IBaseModel;
import com.bw.movie.base.mvp.IBaseView;
import com.bw.movie.model.entity.SearchEntity.CinemaSearchEntity;
import com.bw.movie.model.entity.SearchEntity.MovieSearchEntity;

import retrofit2.http.Query;

/**
 * data:2020/3/31
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface SearchContract {

    interface IModel extends IBaseModel {
        void getMovieSearchData(String keyword,int page,int count,MovieSearchModelCallback movieSearchModelCallback);
        void getCinemaSearchData(int page,int count,String cinemaName,MovieSearchModelCallback movieSearchModelCallback);

        interface MovieSearchModelCallback{
            void MovieSearchSuccess(MovieSearchEntity movieSearchEntity);
            void MovieSearchError(Throwable throwable);
            void CinemaSearchSuccess(CinemaSearchEntity cinemaSearchEntity);
            void CinemaSearchError(Throwable throwable);
        }

    }
    interface IView extends IBaseView {

        void MovieSearchSuccess(MovieSearchEntity movieSearchEntity);
        void MovieSearchError(Throwable throwable);
        void CinemaSearchSuccess(CinemaSearchEntity cinemaSearchEntity);
        void CinemaSearchError(Throwable throwable);

    }
    interface IPresenter{
        void getMovieSearchData(String keyword,int page,int count);
        void getCinemaSearchData(int page,int count,String cinemaName);
    }

}
