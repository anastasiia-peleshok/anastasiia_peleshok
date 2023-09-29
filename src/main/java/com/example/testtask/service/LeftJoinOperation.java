package com.example.testtask.service;

import com.example.testtask.entity.DataRow;
import com.example.testtask.entity.JoinedDataRow;
import com.example.testtask.service.JoinOperation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class LeftJoinOperation<K extends Comparable<K>, V1, V2> implements JoinOperation<DataRow<K, V1>, DataRow<K, V2>, JoinedDataRow<K, V1, V2>> {
    @Override
    public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection, Collection<DataRow<K, V2>> rightCollection) {
        Collection<JoinedDataRow<K, V1, V2>> resultCollection = new ArrayList<>();
        Map<K, V2> rightMap = rightCollection.stream()
                .collect(Collectors.toMap(DataRow::getKey, DataRow::getValue));

        for (DataRow<K, V1> leftRow : leftCollection) {
            if (rightMap.get(leftRow.getKey()) != null) {
                resultCollection.add(new JoinedDataRow<>(leftRow.getKey(), leftRow.getValue(), rightMap.get(leftRow.getKey())));
            } else {
                resultCollection.add(new JoinedDataRow<>(leftRow.getKey(), leftRow.getValue(), null));
            }
        }
        resultCollection.stream().forEach(x -> System.out.println(x));
        return resultCollection;
    }
}