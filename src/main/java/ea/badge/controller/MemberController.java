package ea.badge.controller;

import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.service.BadgeService;
import ea.badge.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public Member createMember(Member member){
     return memberService.createMember(member);
    }

    @GetMapping
    public Collection<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("{/id}")
    public Member getMemberById(@PathVariable Long id){
        return memberService.getMemberById(id);
    }

    @DeleteMapping("{/id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteById(id);
    }
    @PutMapping()
    public Member updateMember(@Valid @RequestBody Member member, @PathVariable Long id){
       return memberService.updateById(member,id);
    }
    @PostMapping("/createBadge")
    public Badge createBadge(@RequestBody Badge badge) {
        return memberService.createBadge(badge);
    }
    @PostMapping("/{id}/replace")
    public Badge replaceBadge(@RequestBody Badge bagde){
        return memberService.replaceBadge(bagde);
    }
    @PutMapping("/{id}/deactivate")
    public Badge deactivateBadge(@RequestBody Badge badge){
        return memberService.deactivateBadge(badge.getId());
    }



}
