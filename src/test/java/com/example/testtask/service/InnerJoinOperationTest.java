package com.example.testtask.service;

import com.example.testtask.entity.DataRow;
import com.example.testtask.entity.JoinedDataRow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InnerJoinOperationTest {
    @Test
    public void test_all_match() {
        InnerJoinOperation<Integer, String, String> joiner=new InnerJoinOperation<>();
        DataRow<Integer, String> left1=new DataRow<>(0,"Ukraine");
        DataRow<Integer, String> left2=new DataRow<>(1, "Germany");
        DataRow<Integer, String> left3=new DataRow<>(2, "France");
        DataRow<Integer, String> right1=new DataRow<>(0, "Kyiv");
        DataRow<Integer, String> right2=new DataRow<>(1, "Berlin");
        DataRow<Integer, String> right3=new DataRow<>(2, "Paris");
        Collection<DataRow<Integer, String>> leftCollection= List.of(left1,left2,left3);
        Collection<DataRow<Integer, String>> rightCollection= List.of(right1,right2,right3);
        Collection<JoinedDataRow<Integer, String, String>> result = joiner.join(leftCollection, rightCollection);
        assertEquals(3, result.size());
        assertTrue(result.contains(new JoinedDataRow<>(0, "Ukraine", "Kyiv")));
        assertTrue(result.contains(new JoinedDataRow<>(1, "Germany", "Berlin")));
        assertTrue(result.contains(new JoinedDataRow<>(2, "France", "Paris")));

    }
    @Test
    public void test_no_match() {
        InnerJoinOperation<Integer, String, String> joiner=new InnerJoinOperation<>();
        DataRow<Integer, String> left1=new DataRow<>(0,"Ukraine");
        DataRow<Integer, String> left2=new DataRow<>(1, "Germany");
        DataRow<Integer, String> left3=new DataRow<>(2, "France");
        DataRow<Integer, String> right1=new DataRow<>(3, "Rome");
        DataRow<Integer, String> right2=new DataRow<>(4, "Madrid");
        DataRow<Integer, String> right3=new DataRow<>(5, "Lisbon");
        Collection<DataRow<Integer, String>> leftCollection= List.of(left1,left2,left3);
        Collection<DataRow<Integer, String>> rightCollection= List.of(right1,right2,right3);
        Collection<JoinedDataRow<Integer, String, String>> result = joiner.join(leftCollection, rightCollection);
        assertEquals(0, result.size());

    }
    @Test
    public void test_few_match() {
        InnerJoinOperation<Integer, String, String> joiner=new InnerJoinOperation<>();
        DataRow<Integer, String> left1=new DataRow<>(0,"Ukraine");
        DataRow<Integer, String> left2=new DataRow<>(1, "Germany");
        DataRow<Integer, String> left3=new DataRow<>(2, "France");
        DataRow<Integer, String> right1=new DataRow<>(0, "Kyiv");
        DataRow<Integer, String> right2=new DataRow<>(4, "Madrid");
        DataRow<Integer, String> right3=new DataRow<>(2, "Paris");
        Collection<DataRow<Integer, String>> leftCollection= List.of(left1,left2,left3);
        Collection<DataRow<Integer, String>> rightCollection= List.of(right1,right2,right3);
        Collection<JoinedDataRow<Integer, String, String>> result = joiner.join(leftCollection, rightCollection);
        assertEquals(2, result.size());
        assertTrue(result.contains(new JoinedDataRow<>(0, "Ukraine", "Kyiv")));
        assertTrue(result.contains(new JoinedDataRow<>(2, "France", "Paris")));
    }
    @Test
    public void test_no_right_set() {
        InnerJoinOperation<Integer, String, String> joiner=new InnerJoinOperation<>();
        DataRow<Integer, String> left1=new DataRow<>(0,"Ukraine");
        DataRow<Integer, String> left2=new DataRow<>(1, "Germany");
        DataRow<Integer, String> left3=new DataRow<>(2, "France");
        Collection<DataRow<Integer, String>> leftCollection= List.of(left1,left2,left3);
        Collection<DataRow<Integer, String>> rightCollection= new ArrayList<>();
        Collection<JoinedDataRow<Integer, String, String>> result = joiner.join(leftCollection, rightCollection);
        assertEquals(0, result.size());
       }
    @Test
    public void test_no_left_set() {
        InnerJoinOperation<Integer, String, String> joiner=new InnerJoinOperation<>();
        DataRow<Integer, String> right1=new DataRow<>(0, "Kyiv");
        DataRow<Integer, String> right2=new DataRow<>(4, "Madrid");
        DataRow<Integer, String> right3=new DataRow<>(2, "Paris");
        Collection<DataRow<Integer, String>> leftCollection= new ArrayList<>();
        Collection<DataRow<Integer, String>> rightCollection= List.of(right1,right2,right3);
        Collection<JoinedDataRow<Integer, String, String>> result = joiner.join(leftCollection, rightCollection);
        assertEquals(0, result.size());
         }
}
