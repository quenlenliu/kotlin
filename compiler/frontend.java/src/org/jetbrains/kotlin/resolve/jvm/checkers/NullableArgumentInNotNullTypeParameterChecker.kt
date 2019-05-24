/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.resolve.jvm.checkers

import com.intellij.psi.PsiElement
import org.jetbrains.kotlin.config.LanguageFeature
import org.jetbrains.kotlin.diagnostics.Errors
import org.jetbrains.kotlin.diagnostics.reportDiagnosticOnce
import org.jetbrains.kotlin.load.java.typeEnhancement.NotNullTypeParameter
import org.jetbrains.kotlin.psi.KtConstantExpression
import org.jetbrains.kotlin.resolve.calls.checkers.CallChecker
import org.jetbrains.kotlin.resolve.calls.checkers.CallCheckerContext
import org.jetbrains.kotlin.resolve.calls.model.ReceiverKotlinCallArgument
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import org.jetbrains.kotlin.resolve.calls.tower.NewResolvedCallImpl
import org.jetbrains.kotlin.resolve.calls.tower.PSIKotlinCallArgument
import org.jetbrains.kotlin.resolve.scopes.receivers.ReceiverValueWithSmartCastInfo
import org.jetbrains.kotlin.types.TypeUtils
import org.jetbrains.kotlin.utils.addToStdlib.safeAs

object NullableArgumentInNotNullTypeParameterChecker : CallChecker {
    override fun check(resolvedCall: ResolvedCall<*>, reportOn: PsiElement, context: CallCheckerContext) {
        if (!context.languageVersionSettings.supportsFeature(LanguageFeature.NewInference)) return
        val newResolvedCall = resolvedCall as? NewResolvedCallImpl<*> ?: return

        for ((parameter, arg) in newResolvedCall.argumentMappingByOriginal) {
            val parameterType = parameter.type as? NotNullTypeParameter ?: continue
            val argument = arg.arguments.firstOrNull() ?: continue
            val receiver = argument.safeAs<ReceiverKotlinCallArgument>()?.receiver as? ReceiverValueWithSmartCastInfo
                ?: continue
            val expression = argument.safeAs<PSIKotlinCallArgument>()?.valueArgument?.getArgumentExpression() ?: continue
            val argumentType = receiver.receiverValue.type
            if (TypeUtils.acceptsNullable(argumentType)) {
                if (expression is KtConstantExpression) {
                    context.trace.reportDiagnosticOnce(Errors.NULL_FOR_NONNULL_TYPE.on(expression, parameterType))
                } else {
                    context.trace.reportDiagnosticOnce(Errors.TYPE_MISMATCH.on(expression, parameterType, argumentType))
                }
            }
        }
    }
}