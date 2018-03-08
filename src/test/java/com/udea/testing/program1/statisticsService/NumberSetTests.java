package com.udea.testing.program1.statisticsService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.udea.testing.program1.statisticsService.model.NumberSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.udea.testing.program1.statisticsService.model.NumberLinkedList;
import com.udea.testing.program1.statisticsService.model.Node;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberSetTests {

    @Test
    public void calculateMeanTest() {
        NumberSet numberSet = new NumberSet();
        NumberLinkedList numberLinkedList = new NumberLinkedList();
        numberLinkedList.insert(2.0);
        numberLinkedList.insert(3.0);
        numberLinkedList.insert(4.0);
        numberLinkedList.insert(5.0);
        numberLinkedList.insert(6.0);
        numberSet.setList(numberLinkedList);
        numberSet.calculateMean();
        assertTrue(" ", 4.0 == numberSet.getMean());
    }
}
