import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    private static final String MyNasaKey = "lVT9iSGWlYA2IWI2B61h0yLReeFrCf8Hu5CEWMcq";
    private static final String urlNasa = "https://api.nasa.gov/planetary/apod?api_key=" + MyNasaKey;

    private static CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                    .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                    .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                    .build())
            .build();

    public static void main(String[] args) throws IOException {
        task1();
        task2Version1();
        task2Version2();
    }


    public static void task1() throws IOException {
        final String url = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(request);
        ObjectMapper mapper = new ObjectMapper();
        List<CatsInfo> catsInfoList = mapper.readValue(
                response.getEntity().getContent(), new TypeReference<>() {
                });
        catsInfoList.stream().
                filter(value -> value.getUpVotes() != null && Integer.parseInt(value.getUpVotes()) > 0)
                .forEach(value -> System.out.println(value.getText()));
    }

    public static void task2Version1() throws IOException {
        HttpGet requestToNasa = new HttpGet(urlNasa);
        CloseableHttpResponse responseFromNasa = httpClient.execute(requestToNasa);

        ObjectMapper mapper = new ObjectMapper();
        NasaResponse nasaResponse = mapper.readValue(responseFromNasa.getEntity().getContent(), new TypeReference<>() {});
        URL nasaImageUrl = new URL(nasaResponse.getUrl());

        Files.copy(nasaImageUrl.openStream(),
                Path.of( FilenameUtils.getName(nasaImageUrl.getPath())),
                REPLACE_EXISTING);
    }
    public static void task2Version2() throws IOException {
        HttpGet requestToNasa = new HttpGet(urlNasa);
        CloseableHttpResponse responseFromNasa = httpClient.execute(requestToNasa);

        JSONObject jsonEntity = new JSONObject(EntityUtils.toString(responseFromNasa.getEntity()));
        URL nasaImageUrl = new URL(jsonEntity.get("hdurl").toString());

        Files.copy(nasaImageUrl.openStream(),
                Path.of( FilenameUtils.getName(nasaImageUrl.getFile())),
                REPLACE_EXISTING);
    }
}
