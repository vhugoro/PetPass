package br.com.fiap.PetPass.dto;


import java.io.Serializable;
import java.util.StringJoiner;

public class SlackMessagesDTO implements Serializable {

    private String username;
    private String text;
    private String icon_emoji;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon_emoji() {
        return icon_emoji;
    }

    public void setIcon_emoji(String icon_emoji) {
        this.icon_emoji = icon_emoji;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SlackMessagesDTO.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("text='" + text + "'")
                .add("icon_emoji='" + icon_emoji + "'")
                .toString();
    }
}
