package ea.badge.controller;


import ea.badge.domain.Badge;
import ea.badge.domain.Member;
import ea.badge.domain.Membership;
import ea.badge.service.MemberService;
import ea.badge.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memberships")
public class MembershipController {
    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public void addMembership(Membership membership){
        membershipService.addMembership(membership);
    }

    @DeleteMapping("/{id}")
    public void removeMembership(@PathVariable Long id){
        membershipService.removeMembership(id);
    }





    }


