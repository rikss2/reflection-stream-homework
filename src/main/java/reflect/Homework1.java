package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

/**
 * @noinspection unused
 */
public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Stream.of(String.class.getDeclaredMethods()).sorted(Comparator.comparing(java.lang.reflect.Method::getName)).forEach(System.out::println);
    }

    /**
     * Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Stream.of(String.class.getDeclaredMethods()).map(java.lang.reflect.Method::getName).distinct().sorted().forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Stream.of(java.lang.String.class.getDeclaredMethods()).filter(method -> {
            var parameters = method.getGenericParameterTypes();
            return parameters.length > 1 && Stream.of(parameters).distinct().count() == 1;
        }).sorted(Comparator.comparing(java.lang.reflect.Method::getName)).forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Stream.of(String.class.getDeclaredMethods()).map(java.lang.reflect.Method::getGenericReturnType).map(java.lang.reflect.Type::getTypeName).distinct().sorted(Comparator.comparing(t -> t.toString())).forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Stream.of(String.class.getDeclaredMethods()).filter(method -> Stream.of(method.getGenericParameterTypes()).map(java.lang.reflect.Type::getTypeName).anyMatch(type -> type.equals("boolean"))).map(java.lang.reflect.Method::getName).sorted().forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Stream.of(String.class.getDeclaredMethods()).filter(method -> {
            var parameters = method.getGenericParameterTypes();
            return Stream.of(parameters).count()>0 && Stream.of(parameters).map(java.lang.reflect.Type::getTypeName).allMatch(type -> type.equals("int"));}).sorted(Comparator.comparing(java.lang.reflect.Method::getName)).forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return Stream.of(String.class.getDeclaredMethods()).map(java.lang.reflect.Method::getName).max(Comparator.comparingInt(String::length)).get();
    }

    /**
     * Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Stream.of(String.class.getDeclaredMethods()).filter(method -> method.getModifiers() % 2 == 1).map(java.lang.reflect.Method::getName).max(Comparator.comparingInt(String::length)).get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return  Stream.of(String.class.getDeclaredMethods()).map(method -> method.getGenericParameterTypes()).mapToInt(parameters->parameters.length).summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {

        return Stream.of(String.class.getDeclaredMethods()).map(method -> method.getGenericParameterTypes()).mapToInt(parameters->parameters.length).max().getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Stream.of(String.class.getDeclaredMethods()).max(Comparator.comparingInt(method->method.getGenericParameterTypes().length)).get();
        ;
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Stream.of(String.class.getDeclaredMethods()).
    }

}
