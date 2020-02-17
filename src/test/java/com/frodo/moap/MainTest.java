package com.frodo.moap;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
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

        List<Column> columns = data.createColumns();
        List<Attribute> attributes = data.createAttributes();

        main.removeColumnsFromAttributes(columns, attributes);

        List<String> shouldNotContainList = Stream.of("name4")
                .collect(Collectors.toList());

        assertThat("columns", columns.size(), equalTo(2));

        System.out.println(columns);
        System.out.println(shouldNotContainList);
    }

    @Test
    public void removeColumnsOk2() {

        List<Column> columns = data.createColumns2();
        List<Attribute> attributes = data.createAttributes2();

        main.removeColumnsFromAttributes(columns, attributes);

        List<String> shoudNotContainList = Stream.of("name99", "name101", "name102")
                .collect(Collectors.toList());

        assertThat("columns", columns.size(), equalTo(0));

        System.out.println(columns);
        System.out.println(shoudNotContainList);
    }

    @Test
    public void removeColumnsOk3() {

        List<Column> columns = data.createColumns3();
        List<Attribute> attributes = data.createAttributes3();

        main.removeColumnsFromAttributes(columns, attributes);

        assertThat("columns", columns.size(), equalTo(1));

        List<String> shoudNotContainList = Stream.of("name99", "name101")
                .collect(Collectors.toList());
        System.out.println(columns);
        System.out.println(shoudNotContainList);

    }

    @Test
    public void removeColumnsOk4() {

        List<Column> columns = data.createColumns4();
        List<Attribute> attributes = data.createAttributes4();

        main.removeColumnsFromAttributes(columns, attributes);

        assertThat("columns", columns.size(), equalTo(3));

        List<String> actualList = columns.stream()
                .map(Column::getCName)
                .collect(Collectors.toList());

        assertThat(actualList, containsInAnyOrder("name1", "name2", "name3"));

    }

    @Test
    public void removeColumnsOk5() {

        List<Column> columns = data.createColumns5();
        List<Attribute> attributes = data.createAttributes5();

        main.removeColumnsFromAttributes(columns, attributes);

        assertThat("columns", columns.size(), equalTo(0));

        List<String> actualList = columns.stream()
                .map(Column::getCName)
                .collect(Collectors.toList());

        assertThat(actualList, empty());

    }

    @Test
    public void removeColumnsOk6() {

        List<Column> columns = data.createColumns6();
        List<Attribute> attributes = data.createAttributes6();

        main.removeColumnsFromAttributes(columns, attributes);

        assertThat("columns", columns.size(), equalTo(2));

        List<String> actualList = columns.stream()
                .map(Column::getCName)
                .collect(Collectors.toList());

        assertThat(actualList, containsInAnyOrder("name1", "name2"));

    }

    @Test
    public void removeColumnsOk7() {

        // Should remove "name3" from columns
        // Because "name3" is not in attributes

        List<Column> columns = data.createColumns7();
        List<Attribute> attributes = data.createAttributes7();

        List<Column> response = main.removeColumnsFromAttributes2(columns, attributes);

        assertThat("columns", response.size(), equalTo(2));

        Column name1 = response.get(0);
        Column name2 = response.get(1);

        assertThat(name1.getCName(), equalTo("name1"));
        assertThat(name2.getCName(), equalTo("name2"));

    }

    @Test
    public void removeColumnsOk8() {

        List<Column> columns = data.createColumns8();
        List<Attribute> attributes = data.createAttributes8();

        List<Column> response = main.removeColumnsFromAttributes2(columns, attributes);

        assertThat("columns", response.size(), equalTo(0));

    }

    @Test
    public void removeColumnsOk9() {

        List<Column> columns = data.createColumns9();
        List<Attribute> attributes = data.createAttributes9();

        List<Column> response = main.removeColumnsFromAttributes2(columns, attributes);

        assertThat("columns", response.size(), equalTo(3));

        Column name1 = response.get(0);
        Column name2 = response.get(1);
        Column name3 = response.get(2);

        assertThat(name1.getCName(), equalTo("name1"));
        assertThat(name2.getCName(), equalTo("name2"));
        assertThat(name3.getCName(), equalTo("name3"));

    }

    @Test
    public void removeColumnsOk10() {

        List<Column> columns = data.createColumns10();
        List<Attribute> attributes = data.createAttributes10();

        List<Column> response = main.removeColumnsFromAttributes2(columns, attributes);

        assertThat("columns", response.size(), equalTo(2));

        Column name2 = response.get(0);
        Column name3 = response.get(1);

        assertThat(name2.getCName(), equalTo("name2"));
        assertThat(name3.getCName(), equalTo("name3"));

    }

}
