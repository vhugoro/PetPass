package br.com.fiap.PetPass.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
