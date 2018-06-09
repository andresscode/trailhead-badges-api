package com.andresscode.trailheadbadgesapi.repository;

import com.andrescode.trailheadbadgesapi.Main;
import com.andrescode.trailheadbadgesapi.collection.User;
import com.andrescode.trailheadbadgesapi.model.UserBadge;
import com.andrescode.trailheadbadgesapi.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private User user;

    @Test
    public void findByCompanyTest() {
        int expected = 1;
        List<User> result = userRepository.findByCompanyContainingIgnoreCase(user.getCompany());
        Assert.assertEquals(expected, result.size());
    }

    @Before
    public void setupBefore() {
        UserBadge badge = new UserBadge();
        badge.setHref("https://trailhead.salesforce.com/modules/API Basics");
        badge.setEarned("2018-03-27");
        badge.setPoints(400);

        List<UserBadge> badges = new ArrayList<>();
        badges.add(badge);

        user = new User();
        user.setTrailheadId("00550000007YrA5AAK");
        user.setFirstName("Andres Felipe");
        user.setLastName("Martinez Amorocho");
        user.setCompany("Avanxo");
        user.setBadges(badges);

        userRepository.save(user);
    }

    @After
    public void setupAfter() {
        userRepository.delete(user);
    }
}
