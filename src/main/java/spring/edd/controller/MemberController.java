package spring.edd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.edd.domain.Member;
import spring.edd.service.MemberService;

import java.util.List;

@Controller
public class MemberController {

//    @Autowired
//    private MemberService memberService;
//    이건 필드 주입이라고 한다. 이러한 방법은 추천하지 않는다. 내가 사용하던 방법.
//    바꿀수 있는 방법이 없다라고 한다.

    private final MemberService memberService;

    //private final에 의해 아래 코드가 인잭션 받는다고 한다.
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
        //다시 보내기
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
