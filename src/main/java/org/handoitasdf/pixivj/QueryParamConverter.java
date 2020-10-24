package org.handoitasdf.pixivj;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.HttpUrl;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.handoitasdf.pixivj.util.JsonUtils;

import java.util.Map;

class QueryParamConverter {
  public <T> void toQueryParams(@NonNull T obj, HttpUrl.@NonNull Builder urlBuilder) {
    JsonObject jsonObj = JsonUtils.GSON.toJsonTree(obj)
      .getAsJsonObject();
    for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
      if (entry.getValue() != null) {
        urlBuilder.addQueryParameter(entry.getKey(), entry.getValue().getAsString());
      }
    }
  }
}
