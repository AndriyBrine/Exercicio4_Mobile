# Fix Unresolved Reference 'parcelize'

The project is missing the explicit application of the Kotlin Android plugin, and the `kotlin-parcelize` plugin is applied without a version or a managed alias. This causes the Kotlin compiler to fail to recognize the `@Parcelize` annotation.

## Proposed Changes

### Build Configuration

#### [MODIFY] [libs.versions.toml](file:///C:/Users/magna/StudioProjects/Exercicio4_Mobile/gradle/libs.versions.toml)
- Add Kotlin version `2.0.0`.
- Define `kotlin-android` and `kotlin-parcelize` plugins.

#### [MODIFY] [build.gradle.kts](file:///C:/Users/magna/StudioProjects/Exercicio4_Mobile/build.gradle.kts)
- Declare the Kotlin and Parcelize plugins in the top-level build file.

#### [MODIFY] [app/build.gradle.kts](file:///C:/Users/magna/StudioProjects/Exercicio4_Mobile/app/build.gradle.kts)
- Apply the `kotlin-android` plugin.
- Update the `kotlin-parcelize` plugin to use the version-controlled alias.

## Verification Plan

### Automated Tests
- Run `./gradlew :app:compileDebugKotlin` to verify the build succeeds.
