package com.chapter.io;

public interface Filter<S> {
    boolean accept(S source);
}
