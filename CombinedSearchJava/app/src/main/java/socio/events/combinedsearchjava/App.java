package socio.events.combinedsearchjava;


import android.app.Application;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.CookieJar;

public class App extends Application {
    public static long RealmSchemaVersion = 1L;
    public static CookieJar cookieJar;

    @Override
    public void onCreate() {
        super.onCreate();

        setupRealm();
        getCookieJar();
    }


    public CookieJar getCookieJar() {
        if(cookieJar == null) {
            cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(this));
        }
        return cookieJar;
    }
    private void setupRealm() {
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .schemaVersion(RealmSchemaVersion)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);

        if(BuildConfig.DEBUG) {
            Realm.deleteRealm(realmConfig);
        }
    }

}
