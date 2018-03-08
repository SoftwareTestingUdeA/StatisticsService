package com.udea.testing.program1.statisticsService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.udea.testing.program1.statisticsService.model.NumberLinkedList;
import com.udea.testing.program1.statisticsService.model.Node;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberLinkedListTests {


    @Test
	public void isEmptyWhenListIsEmptyTest() {
		NumberLinkedList numberLinkedList = new NumberLinkedList();
        assertTrue("La lista se encuentra vacia", numberLinkedList.isEmpty());
	}

	@Test
    public void isEmptyWithNotEmptyListTest(){
        Node node = new Node( Double.parseDouble("1"), null);
        NumberLinkedList numberLinkedList = new NumberLinkedList(node, null);
        assertFalse("La lista no se encuentra vacia", numberLinkedList.isEmpty());
    }
	
	@Test
	public void insertWhenListIsEmptyValidateFirstNodeTest() {
		Node nodeToCompare = new Node(Double.parseDouble("2"), null);
		NumberLinkedList numberLinkedList = new NumberLinkedList();
		numberLinkedList.insert(Double.parseDouble("2"));
		
		assertEquals(nodeToCompare.getNumber(), numberLinkedList.getFirst().getNumber());
	}
	
	@Test
	public void insertWhenListIsEmptyValidateLastNodeTest() {
		Node nodeToCompare = new Node(Double.parseDouble("2"), null);
		NumberLinkedList numberLinkedList = new NumberLinkedList();
		numberLinkedList.insert(Double.parseDouble("2"));
		
		assertEquals(nodeToCompare.getNumber(), numberLinkedList.getLast().getNumber());
	}
	
	@Test
	public void insertWhenListIsNotEmptyValidateLastNodeTest() {
		Node nodeToCompare = new Node(Double.parseDouble("2"), null);
		
		Node nodeInserted = new Node(Double.parseDouble("4"), null);
		NumberLinkedList numberLinkedList = new NumberLinkedList(nodeInserted,nodeInserted);
		numberLinkedList.insert(Double.parseDouble("2"));
		
		assertEquals(nodeToCompare.getNumber(), numberLinkedList.getLast().getNumber());
	}

}
