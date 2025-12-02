package org.cutecats.rest.json;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Singleton;

import java.util.LinkedHashSet;

@Singleton
public class CatStorage extends LinkedHashSet<Cat> {

}
