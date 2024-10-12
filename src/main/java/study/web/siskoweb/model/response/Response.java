package study.web.siskoweb.model.response;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T>{
    private int statusCode;
    private Object message;
    private T data;
    private int total;
}
