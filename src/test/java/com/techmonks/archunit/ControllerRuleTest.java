package com.techmonks.archunit;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.http.ResponseEntity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "com.techmonks.archunit")
public class ControllerRuleTest {
    @ArchTest
    static ArchRule controller_name_should_be_suffixed_controller =
            classes()
                    .that().resideInAPackage("..controller..")
                    .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    static ArchRule classes_named_controller_should_be_in_a_controller_package =
            classes()
                    .that().haveSimpleNameEndingWith("Controller")
                    .should().resideInAPackage("..controller..");

    @ArchTest
    static ArchRule all_public_methods_in_the_controller_layer_should_return_API_response_wrappers =
            methods()
                    .that().areDeclaredInClassesThat().resideInAPackage("..controller..")
                    .and().arePublic()
                    .should().haveRawReturnType(ResponseEntity.class);


}
