package com.example.twoway_movie.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor@Data
public class MemberDTO {
    @NotBlank(message = "아이디는 필수 입력입니다.")
    private String id;
    private String pw;
    private String name;
    private String tel;

}
