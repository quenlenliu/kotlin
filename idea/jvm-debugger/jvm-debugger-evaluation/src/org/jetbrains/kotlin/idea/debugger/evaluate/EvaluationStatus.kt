/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.debugger.evaluate

class EvaluationStatus {
    private var error: EvaluationError? = null
    private var values = mutableMapOf<String, String>()

    fun error(kind: EvaluationError) {
        if (error == null) {
            error = kind
        }
    }

    fun flag(name: String, value: Boolean) {
        values[name] = value.toString()
    }

    fun <T : Enum<T>> value(name: String, value: T) {
        values[name] = value.name
    }

    fun send() {
        /*
            TODO add reporting here

            val statusName = error?.name ?: "Success"
            System.out.println(statusName + " " + values.map { (k, v) -> "$k=$v" }.joinToString())
         */
    }

    enum class EvaluatorType {
        Bytecode, Eval4j
    }

    enum class EvaluationContextLanguage {
        Java, Kotlin, Other
    }
}

enum class EvaluationError {
    NoFrameProxy,
    ThreadNotAvailable,
    ThreadNotSuspended,

    ProcessCancelledException,
    InterpretingException,
    EvaluateException,
    SpecialException,
    GenericException,

    FrontendException,
    BackendException,
    ErrorsInCode
}

fun EvaluationStatus.classLoadingFailed() {
    flag("classLoadingFailed", true)
}

fun EvaluationStatus.compilingEvaluatorFailed() {
    flag("compilingEvaluatorFailed", true)
}

fun EvaluationStatus.usedEvaluator(evaluator: EvaluationStatus.EvaluatorType) {
    value("evaluator", evaluator)
}

fun EvaluationStatus.contextLanguage(language: EvaluationStatus.EvaluationContextLanguage) {
    value("contextLanguage", language)
}

fun EvaluationStatus.evaluationType(type: KotlinDebuggerEvaluator.EvaluationType) {
    value("evaluationType", type)
}