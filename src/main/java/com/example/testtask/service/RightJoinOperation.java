package com.example.testtask.service;

import com.example.testtask.entity.DataRow;
import com.example.testtask.entity.JoinedDataRow;
import com.example.testtask.service.JoinOperation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class RightJoinOperation<K extends Comparable<K>, V1, V2> implements JoinOperation<DataRow<K, V1>, DataRow<K, V2>, JoinedDataRow<K, V1, V2>> {
    @Override
    public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection, Collection<DataRow<K, V2>> rightCollection) {

        Collection<JoinedDataRow<K, V1, V2>> resultCollection = new ArrayList<>();
        Map<K, V1> leftMap = leftCollection.stream()
                .collect(Collectors.toMap(DataRow::getKey, DataRow::getValue));

        for (DataRow<K, V2> rightRow : rightCollection) {
            if (leftMap.get(rightRow.getKey()) != null) {
                resultCollection.add(new JoinedDataRow<>(rightRow.getKey(), leftMap.get(rightRow.getKey()), rightRow.getValue()));
            } else {
                resultCollection.add(new JoinedDataRow<>(rightRow.getKey(), null, rightRow.getValue()));
            }
        }
        resultCollection.stream().forEach(x -> System.out.println(x));
        return resultCollection;
    }
}