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
}
