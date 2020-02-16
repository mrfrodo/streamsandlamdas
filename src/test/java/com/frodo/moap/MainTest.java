package com.frodo.moap;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class MainTest {

    Main main = new Main();
    MainTestData data = new MainTestData();

    @Before
    public void setup() {
        data = new MainTestData();

    }

    @Test
    public void removeColumnsOk() {

        List<Attribute> attributes = data.createAttributes();
        List<Column> columns = data.createColumns();

        main.removeColumnsFromAttributes4(columns, attributes);

        List<String> shouldNotContainList = Stream.of("name4")
                .collect(Collectors.toList());

        assertThat("columns", columns.size(), equalTo(2));

        System.out.println(columns);
        System.out.println(shouldNotContainList);
    }

    @Test
    public void removeColumnsOk2() {

        List<Attribute> attributes = data.createAttributes2();
        List<Column> columns = data.createColumns2();

        main.removeColumnsFromAttributes4(columns, attributes);

        List<String> shoudNotContainList = Stream.of("name99", "name101", "name102")
                .collect(Collectors.toList());

        assertThat("columns", columns.size(), equalTo(0));

        System.out.println(columns);
        System.out.println(shoudNotContainList);
    }

    @Test
    public void removeColumnsOk3() {

        List<Attribute> attributes = data.createAttributes3();
        List<Column> columns = data.createColumns3();

        main.removeColumnsFromAttributes4(columns, attributes);

        assertThat("columns", columns.size(), equalTo(1));

        List<String> shoudNotContainList = Stream.of("name99", "name101")
                .collect(Collectors.toList());
        System.out.println(columns);
        System.out.println(shoudNotContainList);

    }

    @Test
    public void removeColumnsOk4() {

        List<Attribute> attributes = data.createAttributes4();
        List<Column> columns = data.createColumns4();

        main.removeColumnsFromAttributes4(columns, attributes);

        assertThat("columns", columns.size(), equalTo(3));

        List<String> actualList = columns.stream()
                .map(Column::getCName)
                .collect(Collectors.toList());

        assertThat(actualList, containsInAnyOrder("name1", "name2", "name3"));

    }

    @Test
    public void removeColumnsOk5() {

        List<Attribute> attributes = data.createAttributes5();
        List<Column> columns = data.createColumns5();

        main.removeColumnsFromAttributes4(columns, attributes);

        assertThat("columns", columns.size(), equalTo(0));

        List<String> actualList = columns.stream()
                .map(Column::getCName)
                .collect(Collectors.toList());

        assertThat(actualList, empty());

    }

    @Test
    public void removeColumnsOk6() {

        List<Attribute> attributes = data.createAttributes6();
        List<Column> columns = data.createColumns6();

        main.removeColumnsFromAttributes4(columns, attributes);

        assertThat("columns", columns.size(), equalTo(2));

        List<String> actualList = columns.stream()
                .map(Column::getCName)
                .collect(Collectors.toList());

        assertThat(actualList, containsInAnyOrder("name1", "name2"));

    }

}
