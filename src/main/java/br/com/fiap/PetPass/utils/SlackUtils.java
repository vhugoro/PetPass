package br.com.fiap.PetPass.utils;

import br.com.fiap.PetPass.dto.SlackMessagesDTO;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class SlackUtils {

    @Autowired
    Environment environment;

    public void sendMessage(SlackMessagesDTO message) throws IOException {
        OkHttpClient client2 = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, new Gson().toJson(message));

        Request request2 = new Request.Builder()
                .url(new URL(environment.getProperty("slack.webhook.url")))
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Host", "hooks.slack.com")
                .addHeader("accept-encoding", "gzip, deflate")
                .addHeader("Connection", "keep-alive")
                .addHeader("cache-control", "no-cache")
                .build();
        Response response2 = client2.newCall(request2).execute();
    }

    public void sendMessage(String inChannel, String inText) throws IOException {
        SlackMessagesDTO slackMessage = SlackMessagesDTO.builder()
                .channel(inChannel)
                .username("PetBot =^.^=")
                .text(inText)
                .icon_emoji(":slightly_smiling_face:")
                .build();

        sendMessage(slackMessage);
    }
}