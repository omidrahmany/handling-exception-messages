package com.example.exceptionhandling.servic;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Response<INPUT, OUTPUT> {
    @JsonView({InfBaseView.ResponseView.class})
    private String uniqueId;
    @JsonView({InfBaseView.ResponseView.class})
    private INPUT inputArguments;
    @JsonView({InfBaseView.ResponseView.class})
    private OUTPUT response;
    @JsonView({InfBaseView.ResponseView.class})
    private ResponseCode code = ResponseCode.GENERAL;
}
