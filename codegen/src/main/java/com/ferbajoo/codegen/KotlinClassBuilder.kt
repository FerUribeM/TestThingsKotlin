package com.ferbajoo.codegen

import com.ferbajoo.annotation_test.Foo
import com.google.common.collect.ImmutableList
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.TypeElement
import javax.lang.model.util.ElementFilter

/**
 * Custom Kotlin Class Builder which returns file content string
 * This is for learning purpose only.
 * Use KotlinPoet for production app
 * KotlinPoet can be found at https://github.com/square/kotlinpoet
 */
class KotlinClassBuilder(
    className: String,
    packageName: String,
    roundEnvironment: RoundEnvironment
) {

    val annotatedElements = roundEnvironment.getElementsAnnotatedWith(Foo::class.java)

    val types = ImmutableList.builder<TypeElement>()
        .addAll(ElementFilter.typesIn(annotatedElements))
        .build()

    private val builder = StringBuilder()
        .append("package $packageName")
        .append(";\n\n")
        .append("import\t")
        .append("com.ferbajoo.testthingskotlin.core.models.ClassModel")
        .append(";\n\n")
        .append("import\t")
        .append("java.lang.annotation.Annotation")
        .append(";\n")
        .append("import\t")
        .append("kotlin.reflect.KClass")
        .append(";\n")
        .append("import\t")
        .append("android.util.Log.e")
        .append(";\n")
        .append("import\t")
        .append(com.ferbajoo.annotation_test.Foo::class.java.canonicalName) //get package from class Foo
        .append(";\n\n")
        .append("import\t")
        .append("java.util.ArrayList")
        .append(";\n/**\n")
        .append("* Auto generate class\n")
        .append("**/\n")
        .append("public final class ")
        .append("GlobalClasses")
        .append("{\n\n")
        .append("\tprivate val all_classes = mutableListOf<KClass<*>>()")
        .append("\n\t")
        .append("init {")


    private val builderContinue = StringBuilder()
        .append(builder.toString())
        .append(getTypes())
        .append("\n\t")
        .append("}")
        .append("\n\t")
        .append("fun getAllClasses(): MutableList<ClassModel> {")
        .append("\n\t\t")
        .append("val models = mutableListOf<ClassModel>()")
        .append("\n\t\t")
        .append("for (aClass in all_classes) {")
        .append("\n\t\t\t")
        .append("for (annotation in aClass.java.declaredAnnotations) {")
        .append("\n\t\t\t\t")
        .append("if (annotation is Foo) {")
        .append("\n\t\t\t\t\t")
        .append("val foo = annotation")
        .append("\n\t\t\t\t\t")
        .append("models.add(ClassModel(foo.name, foo.value, foo.drawable))")
        .append("\n\t\t\t\t\t")
        .append("}")
        .append("\n\t\t\t\t")
        .append("}")
        .append("\n\t\t\t")
        .append("}")
        .append("\n\t\t")
        .append("return models")
        .append("\n\t")
        .append("}")
        .append("\n}\n")

    private fun getTypes(): String {
        var classList = ""
        for (type in types) {
            classList += "\n\t\t all_classes.add(${type.asType()}::class)"
        }
        return classList
    }

    fun getContent(): String {
        return builderContinue.toString().trimIndent()
    }

}