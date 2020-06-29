package br.com.fiap.PetPass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Getter
@Setter
public class SlackMessagesDTO implements Serializable {
    private String channel;
    private String username;
    private String text;
    private String icon_emoji;
}
