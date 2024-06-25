package org.spring.codingStory.config;

import lombok.RequiredArgsConstructor;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.spring.codingStory.mRank.entity.RankEntity;
import org.spring.codingStory.mRank.repository.MRankRepository;
import org.spring.codingStory.member.entity.MemberEntity;
import org.spring.codingStory.member.repository.MemberRepository;
import org.spring.codingStory.member.role.Role;
import org.spring.codingStory.member.serviceImpl.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StartComponent implements CommandLineRunner {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;
  private final MRankRepository mRankRepository;



  @Override
  public void run(String... args) throws Exception {


    Optional<MemberEntity> member=memberRepository.findByUserEmail("admin@naver.com");

    MemberEntity memberEntity=MemberEntity.builder()
            .role(Role.ADMIN)
            .userEmail("admin@naver.com")
            .userPw(passwordEncoder.encode("1234"))
            .name("관리자")
            .phoneNumber("10504010")
            .department("본사")
            .mRank("사장")
            .address("서울")
            .memberAttachFile(0)
            .build();


    if(!member.isPresent()){
    memberRepository.save(memberEntity);
    }


    Optional<RankEntity> rank1=mRankRepository.findByRankName("사원");
    Optional<RankEntity> rank2=mRankRepository.findByRankName("팀장");
    Optional<RankEntity> rank3=mRankRepository.findByRankName("지점장");
    Optional<RankEntity> rank4=mRankRepository.findByRankName("사장");

    RankEntity rankEntity = RankEntity.builder()
            .rankName("사원")
            .build();
    RankEntity rankEntity1 = RankEntity.builder()
            .rankName("팀장")
            .build();
    RankEntity rankEntity2 = RankEntity.builder()
            .rankName("지점장")
            .build();
    RankEntity rankEntity3 = RankEntity.builder()
            .rankName("사장")
            .build();


    if(!rank1.isPresent()){
    mRankRepository.save(rankEntity);
    }
    if(!rank2.isPresent()){
    mRankRepository.save(rankEntity1);
    }
    if(!rank3.isPresent()){
    mRankRepository.save(rankEntity2);
    }
    if(!rank4.isPresent()){
    mRankRepository.save(rankEntity3);
    }



  }
}
