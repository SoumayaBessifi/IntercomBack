package com.intercom.webapp.webapplication.Integration;


import com.intercom.webapp.webapplication.Entities.Equip;
import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import com.intercom.webapp.webapplication.business.EquipBusiness;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

public class IndexTest  {

    private static final String EQUIPEMENT_NUMSERIE = "X541U";

    @Autowired
    private WebDriver webDriver;

    @Mock
    EquipBusiness equipBusiness=mock(EquipBusiness.class);


    @Value("${server.port}")
    private int serverPort;


    @Test
    public void visitHomePage() throws Exception {

        webDriver.get(String.format("http://localhost:%d/", serverPort));

        WebElement HomePage = webDriver.findElement(By.id("numserie"));

        assertThat(HomePage.getText(),is(EQUIPEMENT_NUMSERIE));

        WebElement table = webDriver.findElement(By.cssSelector("table"));
        List<WebElement> datatableElements = table.findElements(By.cssSelector("th"));
        assertEquals(2, datatableElements.size());
    }

}
