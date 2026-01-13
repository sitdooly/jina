package com.example.twoway_movie.Service;

import com.example.twoway_movie.DTO.MemberDTO;
import com.example.twoway_movie.Entity.MemberEntity;
import com.example.twoway_movie.Repository.MemberRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
   private final MemberRepository memberRepository;
   //암호화 과정남아있음
   private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void memberinsert(MemberDTO memberDTO, HttpServletResponse response) {
      //  memberDTO.setPw(bCryptPasswordEncoder.encode(memberDTO.getPw()));
     //  memberRepository.save(memberDTO.toEntity());
        if(memberRepository.existsById(memberDTO.getId())){
           // throw new IllegalStateException("이미존재하는 아이디입니다");

         //response.sendRedirect();
        }
        MemberEntity me=new MemberEntity();
        me.setId(memberDTO.getId());
        me.setPw(bCryptPasswordEncoder.encode(memberDTO.getPw()));
        me.setName(memberDTO.getName());
        me.setTel(memberDTO.getTel());
        me.setRole("ROLE_USER");
        memberRepository.save(me);
    }
    @Override
    public List<MemberInterface> memberOut() {

        return memberRepository.result();
    }

    @Override
    //엔티티 자료 출력
    public List<MemberEntity> entityout() {
        return memberRepository.findAll();
    }
   //엔티티 자료 페이징 처리 출력
    @Override
    public Page<MemberEntity> entitypage(int page) {
        return memberRepository.findAll(PageRequest.of(page,3));
    }
//자료를 인터페이스 방식으로 출력
    @Override
    public List<MemberInterface> interout2() {
        List<MemberInterface>list=memberRepository.interout3();
        return list;
    }
//인터페이스 페이징 처리 출력
    @Override
    public Page<MemberInterface> interpage2(int page) {
        Page<MemberInterface> list2=memberRepository.interpage(PageRequest.of(page,3));
        return list2;
    }
}
