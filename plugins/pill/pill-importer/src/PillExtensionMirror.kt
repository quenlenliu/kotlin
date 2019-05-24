/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.pill

import org.gradle.api.Project
import java.io.File

class PillExtensionMirror(
    variant: String,
    val importAsLibrary: Boolean,
    val excludedDirs: List<File>,
    val libraryPath: File?
) {
    val variant = Variant.valueOf(variant)

    enum class Variant {
        // Default variant (./gradlew pill)
        BASE {
            override val includes = setOf(BASE)
        },

        // Full variant (./gradlew pill -Dpill.variant=full)
        FULL {
            override val includes = setOf(BASE, FULL)
        },

        // Do not import the project to JPS model, but set some options for it
        NONE {
            override val includes = emptySet<Variant>()
        },

        // 'BASE' if the "jps-compatible" plugin is applied, 'NONE' otherwise
        DEFAULT {
            override val includes = emptySet<Variant>()
        };

        abstract val includes: Set<Variant>
    }
}

fun Project.findPillExtensionMirror(): PillExtensionMirror? {
    val ext = extensions.findByName("pill") ?: return null
    @Suppress("UNCHECKED_CAST")
    val serialized = ext::class.java.getMethod("serialize").invoke(ext) as Map<String, Any>

    val constructor = PillExtensionMirror::class.java.declaredConstructors.single()
    val constructorArgs = constructor.parameters.map { serialized[it.name] }

    return constructor.newInstance(*constructorArgs.toTypedArray()) as PillExtensionMirror
}