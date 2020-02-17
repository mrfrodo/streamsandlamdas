package com.frodo.moap;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    protected void removeColumnsFromAttributes(List<Column> columns, List<Attribute> attributes) {

        Set<String> attributeNames = attributes.stream()
                .map(Attribute::getAName)
                .collect(Collectors.toSet());

        columns.removeIf(column -> !attributeNames.contains(column.getCName()));

    }

    protected List<Column> removeColumnsFromAttributes2(List<Column> columns, List<Attribute> attributes) {

        Set<String> attributeNames = attributes.stream()
                .map(Attribute::getAName)
                .collect(Collectors.toSet());

        columns.stream().filter(column -> attributes.stream()
                .map(Attribute::getAName).anyMatch(attribute -> attribute.equals(column.getCName())))
                .collect(Collectors.toList());

        List<Column> listOutput =
                columns.stream()
                        .filter(column -> attributeNames.contains(column.getCName()))
                        .collect(Collectors.toList());

        return listOutput;


    }

}
