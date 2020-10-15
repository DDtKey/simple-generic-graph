package com.ddtkey.graphs.impl;

import java.util.Objects;

class Vertex<T> {
    private T data;

    public Vertex(T data) {
        Objects.requireNonNull(data);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return Objects.toString(data);
    }
}
