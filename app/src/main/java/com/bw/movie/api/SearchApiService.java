package com.bw.movie.api;

import com.bw.movie.model.entity.SearchEntity.CinemaSearchEntity;
import com.bw.movie.model.entity.SearchEntity.MovieSearchEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * data:2020/3/31
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public interface SearchApiService {

    @GET("movieApi/movie/v2/findMovieByKeyword")
    Observable<MovieSearchEntity> movieSearch(@Query("keyword") String keyword,
                                              @Query("page")int page,
                                              @Query("count")int count);

    @GET("movieApi/cinema/v1/findAllCinemas")
    Observable<CinemaSearchEntity> cinemaSearch(@Query("page")int page,
                                                @Query("count")int count,
                                                @Query("cinemaName") String cinemaName);

}
