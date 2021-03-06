package com.rakangsoftware.criteria;

import java.util.ArrayList;
import java.util.List;

public class OrCriteria<K> implements Criterion<K> {

    private final Criterion<K>[] mCriterion;

    public OrCriteria(Criterion<K>... criterion) {
        mCriterion = criterion;
    }

    @Override
    public List<K> meet(List<K> objects) {
        List<K> result = new ArrayList<>();

        for (K object : objects) {
            if (meet(object)) {
                result.add(object);
            }
        }

        return result;
    }

    @Override
    public boolean meet(final K object) {
        for (int i = 0; i < mCriterion.length; i++) {
            if (mCriterion[i].meet(object)) {
                return true;
            }
        }

        return false;
    }
}