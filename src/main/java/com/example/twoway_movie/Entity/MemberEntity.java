package com.example.twoway_movie.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  @NoArgsConstructor  @Data

@Table(name="mem1213")
public class MemberEntity {
    @Id     @Column    private String id;
    @Column    private String pw;
    @Column    private String name;
    @Column    private String tel;
    @Column  private String  role;

}
