/*
init.groovy

A very simple example of initializing a Deephaven server through application mode.

This script simply makes a table with 5 values in it.

@author Jake Mulford
@copyright Deephaven Data Labs LLC
*/
import io.deephaven.appmode.ApplicationContext
import io.deephaven.appmode.ApplicationState

//Non ApplicationState examples
hello = { ->
    println "Hello world"
}

source = emptyTable(5)
result = source.update("Values = i")

//ApplicationState examples
def start = { ApplicationState app ->
    table = emptyTable(5)
    table = table.update("Values = i")

    app.setField("table", table)
}

ApplicationContext.initialize(start)
