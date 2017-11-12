package socio.events.combinedsearchjava.data.remote;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import socio.events.combinedsearchjava.App;
import socio.events.combinedsearchjava.BuildConfig;
import socio.events.combinedsearchjava.data.remote.helpers.LongDateDeserializer;

public class ApiManager {
    public static String BASE_URL = "https://socio-staging.herokuapp.com/";

    public static Gson buildGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy/MM/dd HH:mm:ss Z")
                .registerTypeAdapter(Long.class, new LongDateDeserializer())
                .registerTypeAdapter(long.class, new LongDateDeserializer())
                .create();
    }

    public static OkHttpClient buildClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if(BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return new OkHttpClient.Builder()
                .cookieJar(App.cookieJar)
                .addInterceptor(interceptor)
                .build();
    }
}
