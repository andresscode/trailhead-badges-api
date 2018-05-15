package com.andresscode.trailheadbadgesapi.repository;

import com.andrescode.trailheadbadgesapi.Main;
import com.andrescode.trailheadbadgesapi.collection.Badge;
import com.andrescode.trailheadbadgesapi.repository.BadgeRespository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class BadgeRepositoryTest {
    @Autowired
    private BadgeRespository badgeRespository;

    private Badge module;

    @Test
    public void findByHrefTest() {
        Badge found = badgeRespository.findByHref(module.getHref());
        Assert.assertEquals(module.getName(), found.getName());
    }

    @Before
    public void setupBefore() {
        module = new Badge();
        module.setType("Module");
        module.setName("Apex Module");
        module.setHref("https://trailhead.salesforce.com/modules/apex_module");
        module.setHours(1.83f);
        badgeRespository.save(module);
    }

    @After
    public void setupAfter() {
        badgeRespository.delete(module);
    }
}
