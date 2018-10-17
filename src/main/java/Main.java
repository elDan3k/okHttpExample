import okhttp3.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {

            System.out.println(run(""));
            System.out.println(post("",""));
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    static String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    static String post(String url, String json) throws IOException {
        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
