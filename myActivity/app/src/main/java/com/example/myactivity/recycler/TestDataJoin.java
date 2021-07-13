 package com.example.myactivity.recycler;

import java.util.ArrayList;
import java.util.List;

public class TestDataJoin {

    public static List<TestData> getData() {
        List<TestData> result = new ArrayList();
        result.add(new TestData("国足挺进世界杯", "524.6w"));
        result.add(new TestData("肖战ringringring合唱挑战", "433.6w"));
        result.add(new TestData("我麻了", "357.8w"));
        result.add(new TestData("万物皆可世界波", "333.6w"));
        result.add(new TestData("王源甩手舞", "285.6w"));
        result.add(new TestData("被青蛇劫起惊艳到", "183.2w"));
        result.add(new TestData("沉浸式深度卸妆", "139.4w"));
        result.add(new TestData("灰太狼宠妻人设崩塌", "75.6w"));
        result.add(new TestData("王力宏状态", "55w"));
        result.add(new TestData("I'm numb...", "43w"));
        result.add(new TestData("IU真好看", "22.2w"));
        return result;
    }
}