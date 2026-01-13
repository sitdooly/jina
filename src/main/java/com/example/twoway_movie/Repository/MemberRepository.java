package com.example.twoway_movie.Repository;



import com.example.twoway_movie.Entity.MemberEntity;
import com.example.twoway_movie.Service.MemberInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,String> {
    //아이디중복검사
    boolean existsById(String id);
    public MemberEntity findOneById(String id);
    @Query(value = """
               select id, name, tel 
              from mem1213 """, nativeQuery = true)
     List<MemberInterface> result();


@Query(value = """
select * 
from mem1213
""",nativeQuery = true)

    List<MemberInterface> interout3();


@Query(value = """
select * 
from mem1213
""",nativeQuery = true)
    Page<MemberInterface> interpage(Pageable pageable);
}
