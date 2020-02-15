package com.frodo.moap;

import com.frodo.moap.Column;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    protected void removeColumnsFromAttributes(List<Column> columns, List<Attribute> attributes) {

        for (Attribute a : attributes) {
            for (Column c : columns) {
                if (!c.getCName().equals(a.getAName())) {
                    // remove c from columns list
                    System.out.println(" remove c from columns list");

                }
            }
        }
    }

    protected void removeColumnsFromAttributes2(List<Column> columns, List<Attribute> attributes) {

        for (Attribute a : attributes) {
            columns.removeIf(column -> !column.getCName().equals(a.getAName()));
        }
    }

    protected void removeColumnsFromAttributes3(List<Column> columns, List<Attribute> attributes) {

        attributes.forEach(attribute -> {
            columns.removeIf(column -> attribute.getAName().equals(column.getCName()));
        });
    }

    protected void removeColumnsFromAttributes4(List<Column> columns, List<Attribute> attributes) {

        Set<String> attributeNames = attributes.stream()
                .map(Attribute::getAName)
                .collect(Collectors.toSet());


        columns.removeIf(column -> !attributeNames.contains(column.getCName()));

    }

}
