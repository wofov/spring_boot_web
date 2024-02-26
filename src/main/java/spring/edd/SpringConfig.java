package spring.edd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.edd.repository.MemberRepository;
import spring.edd.repository.MemoryMemberRepository;
import spring.edd.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
