package com.frodo.moap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;

public class MainTest {

    Main main = new Main();

    @Test
    public void removeColumnsOk() {

        List<Attribute> attributes = createAttributes();
        List<Column> columns = createColumns();
        main.removeColumnsFromAttributes4(columns, attributes);

        assertThat("columns", columns.size(), equalTo(2));

        //check columns dont have name4
        columns.forEach(c -> {
            if(c.getCName().equals("name4")) {
                fail();
            }
        });

    }

    @Test
    public void removeColumnsOk2() {

        List<Attribute> attributes = createAttributes2();
        List<Column> columns = createColumns2();

        System.out.println("before");
        System.out.println("c: " + columns);
        System.out.println("a: " + attributes);
        main.removeColumnsFromAttributes4(columns, attributes);
        System.out.println("after");
        System.out.println("c: " + columns);
        System.out.println("a: " + attributes);

        assertThat("columns", columns.size(), equalTo(0));

        //check columns dont have name1
        columns.forEach(c -> {
            if(c.getCName().equals("name1")) {
                fail();
            }
        });

        //check columns dont have name2
        columns.forEach(c -> {
            if(c.getCName().equals("name2")) {
                fail();
            }
        });

        //check columns dont have name3
        columns.forEach(c -> {
            if(c.getCName().equals("name3")) {
                fail();
            }
        });

    }

    @Test
    public void removeColumnsOk3() {

        List<Attribute> attributes = createAttributes3();
        List<Column> columns = createColumns3();

        System.out.println("before");
        System.out.println("c: " + columns);
        System.out.println("a: " + attributes);
        main.removeColumnsFromAttributes4(columns, attributes);
        System.out.println("after");
        System.out.println("c: " + columns);
        System.out.println("a: " + attributes);

        assertThat("columns", columns.size(), equalTo(1));

        //check columns dont have name2
        columns.forEach(c -> {
            if(c.getCName().equals("name2")) {
                fail();
            }
        });

        //check columns dont have name3
        columns.forEach(c -> {
            if(c.getCName().equals("name3")) {
                fail();
            }
        });

    }

    private List<Attribute> createAttributes() {
        List<Attribute> attributes = new ArrayList();
        Attribute attribute1 = Attribute.builder().aName("name1").build();
        Attribute attribute2 = Attribute.builder().aName("name2").build();
        Attribute attribute3 = Attribute.builder().aName("name3").build();
        attributes.add(attribute1);
        attributes.add(attribute2);
        attributes.add(attribute3);

        return attributes;

    }


    private List<Column> createColumns() {
        List<Column> columns = new ArrayList();
        Column column1 = Column.builder().cName("name1").build();
        Column column2 = Column.builder().cName("name2").build();
        Column column3 = Column.builder().cName("name4").build();
        columns.add(column1);
        columns.add(column2);
        columns.add(column3);

        return columns;

    }

    private List<Attribute> createAttributes2() {
        List<Attribute> attributes = new ArrayList();
        Attribute attribute1 = Attribute.builder().aName("name1").build();
        Attribute attribute2 = Attribute.builder().aName("name2").build();
        Attribute attribute3 = Attribute.builder().aName("name3").build();
        Attribute attribute4 = Attribute.builder().aName("name4").build();
        Attribute attribute5 = Attribute.builder().aName("name5").build();
        attributes.add(attribute1);
        attributes.add(attribute2);
        attributes.add(attribute3);
        attributes.add(attribute4);
        attributes.add(attribute5);

        return attributes;

    }

    private List<Column> createColumns2() {
        List<Column> columns = new ArrayList();
        Column column99 = Column.builder().cName("name99").build();
        Column column100 = Column.builder().cName("name100").build();
        Column column101 = Column.builder().cName("name101").build();
        columns.add(column99);
        columns.add(column100);
        columns.add(column101);

        return columns;

    }

    private List<Attribute> createAttributes3() {
        List<Attribute> attributes = new ArrayList();
        Attribute attribute1 = Attribute.builder().aName("name1").build();
        Attribute attribute2 = Attribute.builder().aName("name2").build();
        Attribute attribute3 = Attribute.builder().aName("name3").build();
        Attribute attribute4 = Attribute.builder().aName("name4").build();
        Attribute attribute5 = Attribute.builder().aName("name5").build();
        attributes.add(attribute1);
        attributes.add(attribute2);
        attributes.add(attribute3);
        attributes.add(attribute4);
        attributes.add(attribute5);

        return attributes;

    }

    private List<Column> createColumns3() {
        List<Column> columns = new ArrayList();
        Column column99 = Column.builder().cName("name99").build();
        Column column1 = Column.builder().cName("name1").build();
        Column column101 = Column.builder().cName("name101").build();
        columns.add(column99);
        columns.add(column1);
        columns.add(column101);

        return columns;

    }
}
