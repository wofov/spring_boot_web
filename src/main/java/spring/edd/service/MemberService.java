package spring.edd.service;

import org.springframework.stereotype.Service;
import spring.edd.domain.Member;
import spring.edd.repository.MemberRepository;
import spring.edd.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
//커맨 + 쉬프트 + T

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //AOP
    //관점지향 프로그램
    //공통 관심 사항과 핵심 관심 사항을 분리하는 것

    public long join(Member member){

        long start = System.currentTimeMillis();

        try{
            //옵션 + 커맨드 + v
            Optional<Member> result = memberRepository.findByName(member.getName());

            validateDuplicateMember(member);
            memberRepository.save(member);
            return member.getId();
        }finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println(time);
        }

    }

    public void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("exist user");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(long id){
        return memberRepository.findById(id);
    }

}
