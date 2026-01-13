package com.example.twoway_movie.Service;

import com.example.twoway_movie.DTO.MemberDTO;
import com.example.twoway_movie.Entity.MemberEntity;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MemberService {
    void memberinsert(MemberDTO memberDTO, HttpServletResponse response);

    List<MemberInterface> memberOut();

    List<MemberEntity> entityout();

    Page<MemberEntity> entitypage(int page);

    List<MemberInterface> interout2();
    //인터페이스 출력방식
    Page<MemberInterface> interpage2(int page);
}
