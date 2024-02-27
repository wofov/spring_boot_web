package spring.edd.service;


import org.assertj.core.api.AbstractStringAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import spring.edd.domain.Member;
import spring.edd.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@Transactional
//jdbc 의존성 필요, 테스트에 트랙잭션 있으면 자동으로 롤백
class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository repository;
    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());


    }

    @Test
    void validateDuplicateMember() {
        Member member = new Member();
        member.setName("sp");

        Member member1 = new Member();
        member1.setName("sp");

        memberService.join(member);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        assertThat(e.getMessage()).isEqualTo("exist user");

//        try{
//            memberService.join(member1);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("exist user1");
//        }
    }

    @Test
    void findOne() {
    }
}