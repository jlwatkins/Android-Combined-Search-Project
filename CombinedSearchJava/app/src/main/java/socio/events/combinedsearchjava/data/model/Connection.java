package socio.events.combinedsearchjava.data.model;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.annotations.PrimaryKey;

public class Connection {
    @PrimaryKey @Expose @SerializedName("id") @NonNull Long id = 0L;
    @Expose @SerializedName("first_name") @NonNull String firstName = "";
    @Expose @SerializedName("last_name") @NonNull String lastName = "";
    @Expose @SerializedName("personal_info") @Nullable String info;
    @Expose @SerializedName("picture_url") @Nullable String imageUrl;
    @Expose @SerializedName("bio") @Nullable String bio;
    @Expose @SerializedName("place_address") @Nullable String location;
    @Expose @SerializedName("connected_at") @NonNull Long connectedAt = 0L;
    @Expose @SerializedName("created_at") @NonNull Long createdAt = 0L;
    @Expose @SerializedName("updated_at") @NonNull Long updatedAt = 0L;
}
