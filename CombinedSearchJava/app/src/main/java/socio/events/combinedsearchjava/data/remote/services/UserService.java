package socio.events.combinedsearchjava.data.remote.services;



import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import socio.events.combinedsearchjava.data.model.Connection;
import socio.events.combinedsearchjava.data.model.Stranger;
import socio.events.combinedsearchjava.data.remote.ApiManager;
import socio.events.combinedsearchjava.data.remote.helpers.UpdateBasedList;

public interface UserService {

    @GET("load_random_connections")
    Observable<Response<UpdateBasedList<Connection>>> fetchRandomConnections();

    @GET("search_people")
    Observable<Response<List<Stranger>>> searchForPeople(
            @Query("query") String searchQuery
    );

    class Creator {
        public static UserService newService() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiManager.BASE_URL)
                    .client(ApiManager.buildClient())
                    .addConverterFactory(GsonConverterFactory.create(ApiManager.buildGson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(UserService.class);
        }
    }
}
