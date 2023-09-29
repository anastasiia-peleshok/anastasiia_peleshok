package com.example.testtask.entity;

import java.util.Objects;

public class JoinedDataRow<K extends Comparable<K>, V1, V2> {
    private K key;
    private V1 value_first;
    private V2 value_second;

    public JoinedDataRow(K key, V1 value_first, V2 value_second) {
        this.key = key;
        this.value_first = value_first;
        this.value_second = value_second;
    }

    @Override
    public String toString() {
        return "JoinedDataRow{" +
                "key=" + key +
                ", value_first=" + value_first +
                ", value_second=" + value_second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinedDataRow<?, ?, ?> that = (JoinedDataRow<?, ?, ?>) o;
        return Objects.equals(key, that.key) && Objects.equals(value_first, that.value_first) && Objects.equals(value_second, that.value_second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value_first, value_second);
    }
}
